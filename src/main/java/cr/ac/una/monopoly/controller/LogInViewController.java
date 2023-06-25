/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.monopoly.util.AppContext;
import cr.ac.una.monopoly.util.FlowController;
import cr.ac.una.monopoly.util.Mensaje;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    private ImageView imVJugador1;
    @FXML
    private ImageView imVJugador2;
    @FXML
    private JFXButton btnElegirFichas;
    private Image imageJ1;
    private Image imageJ2;

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
        ((Stage) btnCancelar.getScene().getWindow()).close();

    }

    @FXML
    void onActionJugar(ActionEvent event) throws IOException {

        try {
            if (txtJugador1.getText() == null || txtJugador1.getText().isEmpty()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Digite el jugador 1", getStage(), "Es necesario digitar el Jugador 1");
            } else if (txtJugador2.getText() == null || txtJugador2.getText().isEmpty()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Digite el jugador 2", getStage(), "Es necesario digitar el Jugador 2");
            } else {
                Datos datos = new Datos();
                datos.setJugador1(txtJugador1.getText());
                datos.setJugador2(txtJugador2.getText());
                String Llave = "Llave";
                AppContext.getInstance().set(Llave, datos);

                FlowController.getInstance().goMain();
                // PrincipalViewController principalView = (PrincipalViewController) FlowController.getInstance().getController("PrincipalView");
                getStage().close();
                //String jugador1 = getTxtJugador1();
                //String jugador2 = getTxtJugador2();
                //principalView.nombreJugadores(jugador1, jugador2);
            }
        } catch (Exception ex) {
            Logger.getLogger(LogInViewController.class.getName()).log(Level.SEVERE, "Error ingresando.", ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void initialize() {
        System.out.println("Hola");
    }

    @FXML
    private void onActionBtnElegirFichas(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("FichaView");
    }

}

class Datos {

    private String Jugador1;
    private String Jugador2;
    private String Ruta1;

    public String getRuta1() {
        return Ruta1;
    }

    public void setRuta1(String Ruta1) {
        this.Ruta1 = Ruta1;
    }

    public String getRuta2() {
        return Ruta2;
    }

    public void setRuta2(String Ruta2) {
        this.Ruta2 = Ruta2;
    }
    private String Ruta2;

    public String getJugador1() {
        return this.Jugador1;
    }

    public void setJugador1(String Jugador1) {
        this.Jugador1 = Jugador1;
    }

    public String getJugador2() {
        return this.Jugador2;
    }

    public void setJugador2(String Jugador2) {
        this.Jugador2 = Jugador2;
    }
}
