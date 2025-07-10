
package controller;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteDAO;
import model.UsuarioDAO;


public class ClienteViewController implements Initializable {
    
    private Cliente cliente;
    private Stage StageClienteView;
    ObservableList<Cliente> lista;
    
    ClienteDAO dao = new ClienteDAO();
    
    
    void setStage(Stage StageClienteView) {
        this.StageClienteView = StageClienteView;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    @FXML
    private TableView<Cliente> TableView;

    @FXML
    private Button btnSalvar;

    @FXML
    private Label lblEndereco;

    @FXML
    private Label lblNascimento;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblTelefone;

    @FXML
    private TextField txtDataNasc;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;
    
    private ObservableList<Cliente> listarCnts() throws SQLException {
        ClienteDAO dao = new ClienteDAO();
        return dao.listarClientes(cliente);
        
    }
    
    
    private void carregarTabelaADMS() throws SQLException{
         lista = FXCollections.observableArrayList(listarCnts());
         if(!lista.isEmpty()){
             TableView.getColumns().clear();
             
            TableColumn<Cliente, Number> colunaID = new TableColumn<>("ID");
            colunaID.setCellValueFactory(u -> u.getValue().idProperty());
            colunaID.setStyle("-fx-alignment: CENTER;");
            colunaID.setPrefWidth(100);
            
            TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
            colunaNome.setCellValueFactory(u -> u.getValue().nomeProperty());
            colunaNome.setStyle("-fx-alignment: CENTER;");
            colunaNome.setPrefWidth(250);
            
            TableColumn<Cliente, String> colunaEndereco = new TableColumn<>("Endereco");
            colunaEndereco.setCellValueFactory(u -> u.getValue().enderecoProperty());
            colunaEndereco.setStyle("-fx-alignment: CENTER;");
            colunaEndereco.setPrefWidth(250);
            
            TableView.getColumns().addAll(colunaID, colunaNome, colunaEndereco);

            TableView.setItems(lista);
         }
     }
    
    @FXML
    void onClickSalvar(ActionEvent event) throws SQLException {
        cliente = new Cliente();
        
        cliente.setNome(txtNome.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setEndereco(txtEndereco.getText());
        cliente.setDataNascimento(Date.valueOf(txtDataNasc.getText()));
        dao.inserirCliente(cliente);
       
        ajustarElementosJanela();

    }

    void ajustarElementosJanela() throws SQLException {
        carregarTabelaADMS();
    }

    
    
}
