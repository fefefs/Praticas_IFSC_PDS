package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Tela2Controller {

      @FXML
    private MenuItem BtnMenuSair;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Menu menuAjuda;

    @FXML
    private Menu menuArquivo;

    @FXML
    private Menu menuCalculadora;

    @FXML
    private MenuItem menuPesquisa;

    @FXML
    private MenuItem menuSobre;

    @FXML
    private MenuItem menuSomar;
    
    @FXML
    void onClickMenuPesquisa(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TelaPesquisa.fxml"));
        Parent root = loader.load();
        
        Scene cena = new Scene(root);
        
        Stage telaPesquisa = new Stage();
        
        ControllerPesquisa pc = loader.getController();
        pc.setStage(telaPesquisa);
        
        telaPesquisa.setOnShown(evento -> {
            pc.ajustarElementosJanela();
        });
        
        telaPesquisa.setTitle("Pesquisa");
        telaPesquisa.setScene(cena);
        telaPesquisa.show();

    }

    @FXML
    void onClickMenuSair(ActionEvent event) {
        
        if (fecharSistema())
        {
          System.exit(0);
        } 
        else 
        {
            event.consume();
        }

    }

    @FXML
    void onClickMenuSobre(ActionEvent event) {
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Sobre");
        alerta.setHeaderText("Informações do sistema");
        alerta.setContentText("Sistema desenvolvido na aula de PDS-1");
        alerta.showAndWait();

    }

    @FXML
    void onClickMenuSomar(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SomarView.fxml"));
        Parent root = loader.load();
        Stage telaSomar = new Stage();
        
        SomarController sc = loader.getController();
        sc.setStage(telaSomar);
        
        telaSomar.setTitle("Soma de números");
        telaSomar.setScene(new Scene(root));
        telaSomar.show();

    }
    
    public boolean fecharSistema()
    {
        Alert confirma = new Alert(Alert.AlertType.CONFIRMATION);
        confirma.setTitle("Confirmação");
        confirma.setHeaderText("Você tem certeza que deseja fechar o sistema ?");
        confirma.setContentText("Todas as alterações não salvas serão perdiadas");
        
        return confirma.showAndWait().filter(response -> response == ButtonType.OK).isPresent();
        
    }

}


