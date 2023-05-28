/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopoly.util.FlowController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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

    public String getTxtJugador1() {
        return txtJugador1.getText();
    }

    public void setTxtJugador1(TextField txtJugador1) {
        this.txtJugador1 = txtJugador1;
    }

    public String getTxtJugador2() {
        return txtJugador2.getText();
    }

    public void setTxtJugador2(TextField txtJugador2) {
        this.txtJugador2 = txtJugador2;
    }

   
       @FXML
    void onActionCancelar(ActionEvent event) {
        ((Stage)btnCancelar.getScene().getWindow()).close();
    }

    @FXML
void onActionJugar(ActionEvent event) throws IOException {
 FlowController.getInstance().goMain();
   PrincipalViewController principalView = (PrincipalViewController) FlowController.getInstance().getController("PrincipalView"); 
   String jugador1 = getTxtJugador1();
   String jugador2 = getTxtJugador2();
    principalView.nombreJugadores(jugador1,jugador2);
}
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     
    }    

    @Override
    public void initialize() {
      
            }

}
