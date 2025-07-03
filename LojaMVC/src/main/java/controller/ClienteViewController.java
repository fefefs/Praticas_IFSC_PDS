
package controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteDAO;
import model.UsuarioDAO;


public class ClienteViewController implements Initializable {
    
    private Cliente cliente;
    private Stage StageClienteView;
    
    ClienteDAO dao = new ClienteDAO();
    
    void setStage(Stage StageClienteView) {
        this.StageClienteView = StageClienteView;
    }
    

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
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
    private TextArea txtListaClientes;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;
    
    @FXML
    void onClickSalvar(ActionEvent event) {
        cliente.setNome(txtNome.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setEndereco(txtEndereco.getText());
        cliente.setDataNascimento(Date.valueOf(txtDataNasc.getText()));
        dao.inserirCliente(cliente);
       

    }

    void ajustarElementosJanela() {
        
    }

    
    
}
