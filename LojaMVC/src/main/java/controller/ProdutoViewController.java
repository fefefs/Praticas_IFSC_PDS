package controller;

import java.sql.Date;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteDAO;
import model.Produto;
import model.ProdutoDAO;

public class ProdutoViewController {
    
    private Produto produto;
    private Stage StageProdutoView;
    ObservableList<Produto> lista;
    
    ProdutoDAO dao = new ProdutoDAO();
    
    
    void setStage(Stage StageProdutoView) {
        this.StageProdutoView = StageProdutoView;
    }

    @FXML
    private TableView<Produto> TableViewProd;

    @FXML
    private Button btnSalvar;

    @FXML
    private Label lblDescricao;

    @FXML
    private Label lblEstoque;

    @FXML
    private Label lblValor;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtEstoque;

    @FXML
    private TextField txtValor;

    
    
    private ObservableList<Produto> listarProds() throws SQLException {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.selecionarProduto();
        
    }
    
    
    private void carregarTabelaProds() throws SQLException{
         lista = FXCollections.observableArrayList(listarProds());
         if(!lista.isEmpty()){
             TableViewProd.getColumns().clear();
             
            TableColumn<Produto, Number> colunaID = new TableColumn<>("ID");
            colunaID.setCellValueFactory(u -> u.getValue().idProperty());
            colunaID.setStyle("-fx-alignment: CENTER;");
            colunaID.setPrefWidth(100);
            
            TableColumn<Produto, String> colunaDescricao = new TableColumn<>("Descrição");
            colunaDescricao.setCellValueFactory(u -> u.getValue().descricaoProperty());
            colunaDescricao.setStyle("-fx-alignment: CENTER;");
            colunaDescricao.setPrefWidth(250);
            
            TableColumn<Produto, Number> colunaValor = new TableColumn<>("Valor");
            colunaValor.setCellValueFactory(u -> u.getValue().valorProperty());
            colunaValor.setStyle("-fx-alignment: CENTER;");
            colunaValor.setPrefWidth(100);
            
            TableColumn<Produto, Number> colunaEstoque = new TableColumn<>("Estoque");
            colunaEstoque.setCellValueFactory(u -> u.getValue().estoqueProperty());
            colunaEstoque.setStyle("-fx-alignment: CENTER;");
            colunaEstoque.setPrefWidth(100);
            
            TableViewProd.getColumns().addAll(colunaID, colunaDescricao, colunaValor, colunaEstoque);

            TableViewProd.setItems(lista);
         }
     }
    
    @FXML
    void onClickSalvar(ActionEvent event) throws SQLException {
        Produto produto = new Produto();
        
        produto.setDescricao(txtDescricao.getText());
        produto.setValor(Double.parseDouble(txtValor.getText()));
        produto.setEstoque(Integer.parseInt(txtEstoque.getText()));
        dao.inserirCliente(produto);
       
        ajustarElementosJanela();

    }

    void ajustarElementosJanela() throws SQLException {
        carregarTabelaProds();
    }

}
