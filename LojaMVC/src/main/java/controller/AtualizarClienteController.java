package controller;

import static java.lang.String.valueOf;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteDAO;
import model.Usuario;
import model.UsuarioDAO;
import util.AlertaUtil;

public class AtualizarClienteController {
    
    Stage stageAtualizarCliente;
    Cliente ClienteSelecionado;
    private Runnable onUsuarioSalvo;
    private static final Pattern TELEFONE_PATTERN = Pattern.compile("^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$");

    ClienteDAO dao = new ClienteDAO();

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnIncluirAlterar;

    @FXML
    private TextField txtDataNasc;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    @FXML
    void btnExcluirClick(ActionEvent event) throws SQLException {
        Optional<ButtonType> resultado = AlertaUtil.mostrarConfirmacao("Atenção",
                "Tem certeza que quer excluir o registro?");
        if(resultado.isPresent()){
            ButtonType botaoPressionado = resultado.get();
            if(botaoPressionado == ButtonType.OK){
                excluir(ClienteSelecionado.getId());
            }
        }
    }

    @FXML
    void btnFecharClick(ActionEvent event) {
        stageAtualizarCliente.close();
    }

    @FXML
    void btnIncluirAlterarClick(ActionEvent event) throws SQLException {
        if(ClienteSelecionado == null){
            if(txtNome.getText().isEmpty() ||
                    txtTelefone.getText().isEmpty() || txtEndereco.getText().isEmpty() ||
                    txtNome.getText().isBlank() ||  
                    txtTelefone.getText().isBlank() || txtEndereco.getText().isBlank()){
             
                AlertaUtil.mostrarErro("Campos não preenchidos",
                "Você deve preencher todos os campos!");
                
            }
            if(verifTelefone(txtTelefone.toString()) == false){
                AlertaUtil.mostrarErro("Telefone incompativel",
                txtTelefone.getText());
            }
            else{
            incluir(txtNome.getText(),
            txtTelefone.getText(), txtEndereco.getText(), Date.valueOf(txtDataNasc.getText()) );
            }
        } else {
            if(txtNome.getText().isEmpty() || 
                    txtTelefone.getText().isEmpty() || txtEndereco.getText().isEmpty() ||
                    txtNome.getText().isBlank() || 
                    txtTelefone.getText().isBlank() || txtEndereco.getText().isBlank()){
             
                AlertaUtil.mostrarErro("Campos não preenchidos",
                "Você deve preencher todos os campos!");
                
            }
            else{
            
            alterar(ClienteSelecionado.getId(), txtNome.getText(),
                    txtTelefone.getText(), txtEndereco.getText(), Date.valueOf(txtDataNasc.getText()));
            }
        }
    }
    
    void setStage(Stage stageAtualizarCliente){
        this.stageAtualizarCliente = stageAtualizarCliente;
    }
    
    void ajustarElementosJanela(Cliente user){
        this.ClienteSelecionado = user;
            btnIncluirAlterar.setText("Editar");
            txtNome.setText(user.getNome());
            txtTelefone.setText(user.getTelefone());
            txtEndereco.setText(user.getEndereco());
            txtDataNasc.setText(valueOf(user.getDataNascimento()));
            
            
        }
    

    void incluir(String nome, String fone,String endereco, Date dataNasc) throws SQLException {
        Cliente ci = new Cliente(nome, fone, endereco, dataNasc);
        dao.inserirCliente(ci);
        if(onUsuarioSalvo != null){
            onUsuarioSalvo.run();
        }
        AlertaUtil.mostrarInformacao("Informação",
                "Registro inserido com sucesso!");
        stageAtualizarCliente.close();
    }
    
    void alterar(int id, String nome, String fone, String endereco, Date dataNasc) throws SQLException{
        Cliente ca = new Cliente(id, nome, fone, endereco, dataNasc);
        dao.alterar(ca);
        if(onUsuarioSalvo != null){
            onUsuarioSalvo.run();
        }
         AlertaUtil.mostrarInformacao("Informação",
                "Registro alterado com sucesso!");
        stageAtualizarCliente.close();
    }
    
    public void setOnUsuarioSalvo(Runnable callback){
        this.onUsuarioSalvo = callback;
    }
    
    public void excluir(int id) throws SQLException{
        new ClienteDAO().excluir(id);
         if(onUsuarioSalvo != null){
            onUsuarioSalvo.run();
        }
         AlertaUtil.mostrarInformacao("Informação", 
                 "Registro excluído com sucesso!");
         stageAtualizarCliente.close();
    }
    
    public boolean verifTelefone(String telefone) {
        
        Matcher matcher = TELEFONE_PATTERN.matcher(telefone);
        if (matcher.matches()){
            return true;
        } else {
            return false;
        }
    }
}

