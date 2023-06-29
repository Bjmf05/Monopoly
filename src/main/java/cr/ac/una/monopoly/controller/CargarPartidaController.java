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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Servidor
 */
public class CargarPartidaController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private VBox vbxParametros;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private TableView<?> tbvResultados;
    @FXML
    private TableColumn<?, ?> tbcFecha;
    @FXML
    private TableColumn<?, ?> tbcJugador1;
    @FXML
    private TableColumn<?, ?> tbcJugador2;
    @FXML
    private TableColumn<?, ?> tbcCargar;
    @FXML
    private TableColumn<?, ?> tbcEliminar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnAceptar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onActionBtnBuscar(ActionEvent event) {
    }

    @FXML
    private void onMousePressedTbvResultados(MouseEvent event) {
    }

    @FXML
    private void onActionBtnCancelar(ActionEvent event) {
    }

    @FXML
    private void onActionBtnAceptar(ActionEvent event) {
    }
    
    
}
