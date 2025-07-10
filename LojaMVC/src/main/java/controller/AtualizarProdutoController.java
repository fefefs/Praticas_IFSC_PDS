package controller;

import static java.lang.String.valueOf;
import java.sql.Date;
import java.sql.SQLException;
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
import model.Produto;
import model.ProdutoDAO;
import util.AlertaUtil;

public class AtualizarProdutoController {
    
    Stage stageAtualizarProduto;
    Produto ProdutoSelecionado;
    private Runnable onUsuarioSalvo;
    private static final Pattern TELEFONE_PATTERN = Pattern.compile("^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$");

    ProdutoDAO dao = new ProdutoDAO();

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnIncluirAlterar;
    
    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtEstoque;

    @FXML
    private TextField txtValor;

    @FXML
    void btnExcluirClick(ActionEvent event) throws SQLException {
        Optional<ButtonType> resultado = AlertaUtil.mostrarConfirmacao("Atenção",
                "Tem certeza que quer excluir o registro?");
        if(resultado.isPresent()){
            ButtonType botaoPressionado = resultado.get();
            if(botaoPressionado == ButtonType.OK){
                excluir(ProdutoSelecionado.getId());
            }
        }
    }

    @FXML
    void btnFecharClick(ActionEvent event) {
        stageAtualizarProduto.close();
    }

    @FXML
    void btnIncluirAlterarClick(ActionEvent event) throws SQLException {
        if(ProdutoSelecionado == null){
            if(txtDescricao.getText().isEmpty() ||
                    txtEstoque.getText().isEmpty() || txtValor.getText().isEmpty() ||
                    txtDescricao.getText().isBlank() ||  
                    txtEstoque.getText().isBlank() || txtValor.getText().isBlank()){
             
                AlertaUtil.mostrarErro("Campos não preenchidos",
                "Você deve preencher todos os campos!");
                
            }
            
            incluir(txtDescricao.getText(),Double.parseDouble(txtValor.getText()),
            Integer.parseInt(txtEstoque.getText()) );
            
        } else {
            if(txtDescricao.getText().isEmpty() || 
                    txtEstoque.getText().isEmpty() || txtValor.getText().isEmpty() ||
                    txtDescricao.getText().isBlank() || 
                    txtEstoque.getText().isBlank() || txtValor.getText().isBlank()){
             
                AlertaUtil.mostrarErro("Campos não preenchidos",
                "Você deve preencher todos os campos!");
                
            }
            else{
            
            alterar(ProdutoSelecionado.getId(), txtDescricao.getText(),Double.parseDouble(txtValor.getText()),
                    Integer.parseInt(txtEstoque.getText()));
            }
        }
    }
    
    void setStage(Stage stageAtualizarCliente){
        this.stageAtualizarProduto = stageAtualizarCliente;
    }
    
    void ajustarElementosJanela(Produto user){
        this.ProdutoSelecionado = user;
            btnIncluirAlterar.setText("Editar");
            txtDescricao.setText(user.getDescricao());
            txtEstoque.setText(valueOf(user.getEstoque()));
            txtValor.setText(valueOf(user.getValor()));
            
            
            
        }
    

    void incluir(String descricao,Double valor, int estoque) throws SQLException {
        Produto pi = new Produto(descricao, valor, estoque);
        dao.inserirProduto(pi);
        if(onUsuarioSalvo != null){
            onUsuarioSalvo.run();
        }
        AlertaUtil.mostrarInformacao("Informação",
                "Registro inserido com sucesso!");
        stageAtualizarProduto.close();
    }
    
    void alterar(int id, String descricao,Double valor, int estoque) throws SQLException{
        Produto ca = new Produto(id, descricao, valor, estoque);
        dao.alterar(ca);
        if(onUsuarioSalvo != null){
            onUsuarioSalvo.run();
        }
         AlertaUtil.mostrarInformacao("Informação",
                "Registro alterado com sucesso!");
        stageAtualizarProduto.close();
    }
    
    public void setOnUsuarioSalvo(Runnable callback){
        this.onUsuarioSalvo = callback;
    }
    
    public void excluir(int id) throws SQLException{
        new ProdutoDAO().excluir(id);
         if(onUsuarioSalvo != null){
            onUsuarioSalvo.run();
        }
         AlertaUtil.mostrarInformacao("Informação", 
                 "Registro excluído com sucesso!");
         stageAtualizarProduto.close();
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
