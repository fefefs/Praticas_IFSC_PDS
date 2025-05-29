package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;
import model.UsuarioDAO;
import util.AlertaUtil;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CadastroUsuariosController {
    Stage stageCadastroUsuarios;
    Usuario usuarioSelecionado;
    private Runnable onUsuarioSalvo; //Este é o callback
    
    private static final Pattern TELEFONE_PATTERN = Pattern.compile("^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$");
    
      @FXML
    private Button btnExcluir;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnIncluirAlterar;

    @FXML
    private ComboBox<String> cbPerfil;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtTelefone;
    
        @FXML
    private DatePicker dtDataNasc;

    @FXML
    private TextField txtEmail;
    

    @FXML
    void btnExcluirClick(ActionEvent event) throws SQLException {
        Optional<ButtonType> resultado = AlertaUtil.mostrarConfirmacao("Atenção",
                "Tem certeza que quer excluir o registro?");
        if(resultado.isPresent()){
            ButtonType botaoPressionado = resultado.get();
            if(botaoPressionado == ButtonType.OK){
                excluir(usuarioSelecionado.getId());
            }
        }
    }

    @FXML
    void btnFecharClick(ActionEvent event) {
        stageCadastroUsuarios.close();
    }

    @FXML
    void btnIncluirAlterarClick(ActionEvent event) throws SQLException {
        if(usuarioSelecionado == null){
            if(txtNome.getText().isEmpty() || txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty() || 
                    txtTelefone.getText().isEmpty() || txtEmail.getText().isEmpty() ||
                    txtNome.getText().isBlank() || txtLogin.getText().isBlank() || txtSenha.getText().isBlank() || 
                    txtTelefone.getText().isBlank() || txtEmail.getText().isBlank()){
             
                AlertaUtil.mostrarErro("Campos não preenchidos",
                "Você deve preencher todos os campos!");
                
            }
            if(verifTelefone(txtTelefone.toString()) == false){
                AlertaUtil.mostrarErro("Telefone incompativel",
                txtTelefone.getText());
            }
            else{
            incluir(txtNome.getText(),
            txtTelefone.getText(), txtLogin.getText(),
            txtSenha.getText(), cbPerfil.getValue(), txtEmail.getText(), dtDataNasc.getValue() );
            }
        } else {
            if(txtNome.getText().isEmpty() || txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty() || 
                    txtTelefone.getText().isEmpty() || txtEmail.getText().isEmpty() ||
                    txtNome.getText().isBlank() || txtLogin.getText().isBlank() || txtSenha.getText().isBlank() || 
                    txtTelefone.getText().isBlank() || txtEmail.getText().isBlank()){
             
                AlertaUtil.mostrarErro("Campos não preenchidos",
                "Você deve preencher todos os campos!");
                
            }
            else{
            
            alterar(usuarioSelecionado.getId(), txtNome.getText(),
                    txtTelefone.getText(), txtLogin.getText(),
                    txtSenha.getText(), cbPerfil.getValue(), txtEmail.getText(), dtDataNasc.getValue());
            }
        }
    }

    
    void setStage(Stage telaCadastroUsuarios){
        this.stageCadastroUsuarios = telaCadastroUsuarios;
    }
    
    void ajustarElementosJanela(Usuario user){
        this.usuarioSelecionado = user;
        if(user == null){ //Incluir
            txtNome.requestFocus();
            btnExcluir.setVisible(false);
            btnIncluirAlterar.setText("Salvar");
            cbPerfil.getItems().addAll("admin", "user");
        } else {
            btnIncluirAlterar.setText("Editar");
            txtNome.setText(user.getNome());
            txtTelefone.setText(user.getFone());
            txtLogin.setText(user.getLogin());
            txtSenha.setText(user.getSenha());
            cbPerfil.getItems().addAll("admin", "user");
            cbPerfil.setValue(user.getPerfil());
            txtEmail.setText(user.getEmail());
            dtDataNasc.setValue(user.getDataNasc());
            
            
        }
    }

    void incluir(String nome, String fone, 
        String login, String senha, String perfil, String email, LocalDate dataNasc) throws SQLException {
        Usuario usuario = new Usuario(nome, fone, login, senha, perfil, email, dataNasc);
        new UsuarioDAO().salvar(usuario);
        if(onUsuarioSalvo != null){
            onUsuarioSalvo.run();
        }
        AlertaUtil.mostrarInformacao("Informação",
                "Registro inserido com sucesso!");
        stageCadastroUsuarios.close();
    }
    
    void alterar(int id, String nome, String fone, String login,
       String senha, String perfil, String email, LocalDate dataNasc) throws SQLException{
        Usuario usuarioAlterado = new Usuario(id, nome, fone, login,
        senha, perfil, email, dataNasc);
        new UsuarioDAO().alterar(usuarioAlterado);
        if(onUsuarioSalvo != null){
            onUsuarioSalvo.run();
        }
         AlertaUtil.mostrarInformacao("Informação",
                "Registro alterado com sucesso!");
        stageCadastroUsuarios.close();
    }
    
    public void setOnUsuarioSalvo(Runnable callback){
        this.onUsuarioSalvo = callback;
    }
    
    public void excluir(int id) throws SQLException{
        new UsuarioDAO().excluir(id);
         if(onUsuarioSalvo != null){
            onUsuarioSalvo.run();
        }
         AlertaUtil.mostrarInformacao("Informação", 
                 "Registro excluído com sucesso!");
         stageCadastroUsuarios.close();
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
