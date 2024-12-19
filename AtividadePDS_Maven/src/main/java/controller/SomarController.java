package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SomarController implements Initializable {
    
    private Stage stageSomar;

    @FXML
    private Label Result;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSomar;
    
    @FXML
    private Label lblN1;

    @FXML
    private Label lblN2;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtNumero1;

    @FXML
    private TextField txtNumero2;

    @FXML
    void onClickBtnFechar(ActionEvent event) 
    {
        if(stageSomar != null)
        {
            stageSomar.close();
        }
    }
    
    //método para atribuir um stage ao controller atual
    public void setStage(Stage stage)
    {
        this.stageSomar = stage;
    }

    @FXML
    void onClickBtnLimpar(ActionEvent event) 
    {
        
        txtNumero1.setText("");
        txtNumero2.setText("");
        Result.setText("");
        txtNumero1.requestFocus();

    }

    @FXML
    void onClickBtnSomar(ActionEvent event) 
    {
        try {
 
        Double n1 = Double.valueOf(txtNumero1.getText());
        Double n2 = Double.valueOf(txtNumero2.getText());
        Double resultado = n1 + n2;
        Result.setText(resultado.toString());
        } catch (NumberFormatException n){
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("inPut Invalidos");
        alerta.setHeaderText("Esse inPut e invalido");
        alerta.setContentText("insira novamente!");
        alerta.showAndWait();
            
        }

    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

}
