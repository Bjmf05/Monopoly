/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Servidor
 */
public class LogInViewController extends Controller implements Initializable {
   @FXML
    private AnchorPane root;
       

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnJugar;
       @FXML
 private ImageView imvFondo;
    @FXML
 
    private Label lblJugador1;

    @FXML
    private Label lblJugador2;


    @FXML
    private TextField txtJugador1;

    @FXML
    private TextField txtJugador2;

   
       @FXML
    void onActionCancelar(ActionEvent event) {
        ((Stage)btnCancelar.getScene().getWindow()).close();
    }

    @FXML
    void onActionJugar(ActionEvent event) {

    }

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     
    }    

    @Override
    public void initialize() {
      
            }

}
