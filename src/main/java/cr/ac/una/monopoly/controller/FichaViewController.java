/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.monopoly.util.AppContext;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joshua Cambronero
 */
public class FichaViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    private HBox contImageFichas;
    @FXML
    private JFXButton btnCargar;
    private String Cargar;
    private String rutaImagen1;
    private String rutaImagen2;
    @FXML
    private HBox contImageFichasJ1;
    @FXML
    private HBox contImageFichasJ2;
    @FXML
    private ImageView imageContJ1;
    @FXML
    private ImageView imageContJ2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agregarContenidoJ1("/cr/ac/una/monopoly/resources/helicoptero.png");
        agregarContenidoJ1("/cr/ac/una/monopoly/resources/jeep.png");
        agregarContenidoJ1("/cr/ac/una/monopoly/resources/camion.png");
        agregarContenidoJ1("/cr/ac/una/monopoly/resources/embarcacion.png");
        agregarContenidoJ1("/cr/ac/una/monopoly/resources/sombrero.png");

        agregarContenidoJ2("/cr/ac/una/monopoly/resources/helicoptero.png");
        agregarContenidoJ2("/cr/ac/una/monopoly/resources/jeep.png");
        agregarContenidoJ2("/cr/ac/una/monopoly/resources/camion.png");
        agregarContenidoJ2("/cr/ac/una/monopoly/resources/embarcacion.png");
        agregarContenidoJ2("/cr/ac/una/monopoly/resources/sombrero.png");
    }

    @Override
    public void initialize() {
    }

    private void agregarContenidoJ1(String link1) {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        Image imagen = new Image(link1);
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        imageView.setOnMouseClicked(event -> {
            rutaImagen1 = link1;
            Image image = new Image(rutaImagen1);
            imageContJ1.setImage(image);
        });
        vbox.getChildren().add(imageView);
        contImageFichasJ1.getChildren().add(vbox);
    }

    private void agregarContenidoJ2(String link2) {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        Image imagen = new Image(link2);
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        imageView.setOnMouseClicked(event -> {
            rutaImagen2 = link2;
            Image image = new Image(rutaImagen2);
            imageContJ2.setImage(image);
        });
        vbox.getChildren().add(imageView);
        contImageFichasJ2.getChildren().add(vbox);
    }

    @FXML
    private void onActionBtnCargar(ActionEvent event) {
        Datos rut = new Datos();
        rut.setRuta1(rutaImagen1);
        rut.setRuta2(rutaImagen2);
        //   cargaImagen();
        AppContext.getInstance().set("Ruta", rut);
        ((Stage) root.getScene().getWindow()).close();
    }

}
