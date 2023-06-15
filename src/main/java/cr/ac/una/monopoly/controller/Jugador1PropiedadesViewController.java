/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopoly.util.AppContext;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Joshua Cambronero
 */
public class Jugador1PropiedadesViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TableView<List<Object>> tViewDatosPropiedades;
    @FXML
    private TableColumn<List<Object>, String> nombreColumna;
    @FXML
    private TableColumn<List<Object>, Double> valorColumna;
    @FXML
    private TableColumn<List<Object>, Double> valorDeVentaColumna;
    @FXML
    private TableColumn<List<Object>, Double> valorDeHipotecaColumna;
    @FXML
    private TableColumn<List<Object>, String> propietarioColumna;
    @FXML
    private TableColumn<List<Object>, Boolean> venderColumna;
    @FXML
    private TableColumn<List<Object>, Boolean> hipotecarColumna;
    @FXML
    private JFXButton btnActualizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       llenarTabla();
    }
    public void llenarTabla() {
        ObservableList<List<Object>> datosPropiedades = FXCollections.observableArrayList();
        List<List<Object>> datosJ1 = (List<List<Object>>) AppContext.getInstance().get("J1");
        List<List<Object>> listaPreestablecida = (List<List<Object>>) AppContext.getInstance().get("Vacia");
        if (datosJ1 == null) {
            datosPropiedades.addAll(listaPreestablecida);
        } else {
            datosPropiedades.addAll(datosJ1);
        }

        tViewDatosPropiedades.setItems(datosPropiedades);
        // Configurar las celdas de cada columna
        nombreColumna.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get(0)));
        valorColumna.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(1)));
        valorDeVentaColumna.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(2)));
        valorDeHipotecaColumna.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(3)));
        propietarioColumna.setCellValueFactory(cellData -> new SimpleObjectProperty<>((String) cellData.getValue().get(4)));
        // Configurar celdas de botón personalizadas para las columnas de vender y hipotecar
        venderColumna.setCellFactory(createButtonCellFactory("Vender"));
        hipotecarColumna.setCellFactory(createButtonCellFactory("Hipotecar"));

    }

    private Callback<TableColumn<List<Object>, Boolean>, TableCell<List<Object>, Boolean>> createButtonCellFactory(String buttonText) {
        return new Callback<TableColumn<List<Object>, Boolean>, TableCell<List<Object>, Boolean>>() {
            @Override
            public TableCell<List<Object>, Boolean> call(final TableColumn<List<Object>, Boolean> param) {
                return new TableCell<List<Object>, Boolean>() {
                    private final Button button = new Button(buttonText);

                    {
                        button.setOnAction(event -> {
                            // Lógica de acción del botón
                            List<Object> property = getTableView().getItems().get(getIndex());
                            
                            if (buttonText == "Vender"){
                                System.out.println(buttonText + " Funcion 1");
                                System.out.println(buttonText + " para: " + valorDeVentaColumna);
                                
                            }if (buttonText == "Hipotecar"){
                                System.out.println(buttonText + " Funcion 2");
                                System.out.println(buttonText + " para: " + valorDeVentaColumna);
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Boolean item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            button.setStyle("-fx-background-color: orange;");
                            setGraphic(button);
                        }
                    }
                };
            }
        };
    }

    @Override
    public void initialize() {
    }
    
  
    
    
    @FXML
    private void onActionBtnActualizar(ActionEvent event) {
       llenarTabla();
    }
}
