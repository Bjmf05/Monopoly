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
public class Jugador2PropiedadesViewController extends Controller implements Initializable {

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
    @FXML
    private TableColumn<List<Object>, Boolean> perteneceColumna;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       llenarTabla();
    }
    public void llenarTabla() {
        ObservableList<List<Object>> datosPropiedades = FXCollections.observableArrayList();
        List<List<Object>> datosJ1 = (List<List<Object>>) AppContext.getInstance().get("J2");
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
        perteneceColumna.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Boolean) cellData.getValue().get(5)));
    }

    private Callback<TableColumn<List<Object>, Boolean>, TableCell<List<Object>, Boolean>> createButtonCellFactory(String buttonText) {
        return new Callback<TableColumn<List<Object>, Boolean>, TableCell<List<Object>, Boolean>>() {
            @Override
            public TableCell<List<Object>, Boolean> call(final TableColumn<List<Object>, Boolean> param) {
                return new TableCell<List<Object>, Boolean>() {
                    private final Button button = new Button(buttonText);

                    {
                        button.setOnAction(event -> {
                            
                           
                            
                            if (buttonText == "Vender") {
                                List<Object> rowData = getTableView().getItems().get(getIndex());
                                System.out.println("datin: "+getIndex());
                                System.out.println("Nombre: " + (String) rowData.get(0));
                                System.out.println("Precio: " + (Double) rowData.get(2));
                         
                                VentasJ2 ventaJ2 = new VentasJ2();
                                ventaJ2.setVentaJ2((Double) rowData.get(2));
                                AppContext.getInstance().set("VentaJ1", ventaJ2);
                         
                                List<List<Object>> datosJ1 = (List<List<Object>>) AppContext.getInstance().get("J1");
                        
                                int indiceABorrar = getIndex(); // Índice que deseas borrar
                                  
                                if (indiceABorrar >= 0 && indiceABorrar < datosJ1.size()) {
                                    datosJ1.remove(indiceABorrar);
                                } else {
                                    System.out.println("El índice está fuera de rango");
                                }
                      
                                llenarTabla();
                                
                               
                            }if (buttonText == "Hipotecar"){
    
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

    @FXML
    private void onActionBtnCerrar(ActionEvent event) {
      
    }
}
class VentasJ2{

private double VentaJ2;

    public double getVentaJ2() {
        return VentaJ2;
    }

    public void setVentaJ2(double VentaJ2) {
        this.VentaJ2 = VentaJ2;
    }

}