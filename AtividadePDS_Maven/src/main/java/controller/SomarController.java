package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SomarController {

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
        
        System.exit(0);

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
            
            Result.setText("Números invalidos");
            
        }

    }

}
