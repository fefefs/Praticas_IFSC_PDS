package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerPesquisa {
    
    private Stage stagePesquisa;
    RadioButton botaoLinguagemSelecionado;
    ToggleGroup tgLinguagens = new ToggleGroup();
    
    ToggleButton botaoSOSelecionado;
    ToggleGroup tgSO = new ToggleGroup();

    @FXML
    private Label LblQuestProg;

    @FXML
    private Label LblSisOp;

    @FXML
    private AnchorPane anchorPane;
    
     @FXML
    private Button btnFecharPq;

    @FXML
    private Button btnSubmeter;

    @FXML
    private CheckBox ckbxGostaDeProg;

    @FXML
    private CheckBox ckbxProgDia;

    @FXML
    private Label lblLinguagemProg;

    @FXML
    private Label lblNome;

    @FXML
    private RadioButton rBtnC;

    @FXML
    private RadioButton rBtnJava;

    @FXML
    private RadioButton rBtnPhyton;

    @FXML
    private ToggleButton tBtnLinux;

    @FXML
    private ToggleButton tBtnMac;

    @FXML
    private ToggleButton tBtnWindows;

    @FXML
    private TextField txtNome;

    @FXML
    void onClickbtnSubmeter(ActionEvent event) {
        System.out.println("\n\n");
        if(!txtNome.getText().isEmpty())
        {
            String nome = txtNome.getText();
            System.out.println("Nome : " + nome);
        } else {
            System.out.println("Nao informado");
        }
        
        botaoLinguagemSelecionado = (RadioButton) tgLinguagens.getSelectedToggle();
        System.out.println("Linguagem favorita : ");
        if(botaoLinguagemSelecionado != null)
        {
            System.out.println(botaoLinguagemSelecionado.getText());
        } else {
            System.out.println("Não selecionado");
        }
        
        botaoSOSelecionado = (ToggleButton) tgSO.getSelectedToggle();
        System.out.println("Sistema operacional : ");
        if(botaoLinguagemSelecionado != null)
        {
            System.out.println(botaoSOSelecionado.getText());
        } else {
            System.out.println("Não selecionado");
        }
         if(ckbxGostaDeProg.isSelected())
         {
             System.out.println("Gosta de Programar!");
         }
         if(ckbxProgDia.isSelected())
         {
             System.out.println("Programa Todo Dia!");
         }
       
       
        

    }

    @FXML
    void onClickckbxGostaDeProg(ActionEvent event) {

    }

    @FXML
    void onClickckbxProgDia(ActionEvent event) {

    }

    @FXML
    void onClickrBtnC(ActionEvent event) {

    }

    @FXML
    void onClickrBtnJava(ActionEvent event) {

    }

    @FXML
    void onClickrBtnPhyton(ActionEvent event) {

    }

    @FXML
    void onClicktBtnLinux(ActionEvent event) {

    }

    @FXML
    void onClicktBtnMac(ActionEvent event) {

    }

    @FXML
    void onClicktBtnWindows(ActionEvent event) {

    }
    
     @FXML
    void onClickBtnFecharPq(ActionEvent event) 
    {
        if(stagePesquisa != null)
        {
            stagePesquisa.close();
        }
    }
    
    void setStage(Stage telaPesquisa)
    {
        this.stagePesquisa = telaPesquisa;
        
    }

    void ajustarElementosJanela()
    {
        tgLinguagens.getToggles().addAll(rBtnPhyton, rBtnC, rBtnJava);
        tgSO.getToggles().addAll(tBtnLinux,tBtnMac ,tBtnWindows );
    }
}
