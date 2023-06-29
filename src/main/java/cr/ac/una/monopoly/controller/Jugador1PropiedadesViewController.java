/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopoly.util.AppContext;
import cr.ac.una.monopoly.model.Position;
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
import cr.ac.una.monopoly.controller.PrincipalViewController;
import java.util.ArrayList;
import javafx.scene.control.Tab;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joshua Cambronero
 */
public class Jugador1PropiedadesViewController extends Controller implements Initializable {
PrincipalViewController principal = new PrincipalViewController();
     @FXML
    private AnchorPane root;
    @FXML
    private TableView<List<Object>> tViewDatosPropiedades;
        @FXML
    private TableColumn<List<Object>,Integer> idColumna;
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
    private TableColumn<List<Object>, Boolean> perteneceColumna;
    @FXML
    private JFXButton btnCerrar;
    @FXML
    private Tab pestPropiedades;
    @FXML
    private Tab pestHipotecas;
    @FXML
    private TableView<List<Object>> tViewDatosProopiedadesHipotecadas;
    @FXML
    private TableColumn<List<Object>,Integer> idColumnaH;
    @FXML
    private TableColumn<List<Object>,String> nombreColumnaH;
    @FXML
    private TableColumn<List<Object>,Double> valorColumnaH;
    @FXML
    private TableColumn<List<Object>,Double> valorDeVentaColumnaH;
    @FXML
    private TableColumn<List<Object>,Double> valorDeHipotecaColumnaH;
    @FXML
    private TableColumn<List<Object>,Boolean> liberarHColumna;
   
    private ObservableList<List<Object>> propiedadesOcupadas1 = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
    public void setPrincipal(PrincipalViewController principal) {
    this.principal = principal;
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
        idColumna.setCellValueFactory(cellData -> new SimpleObjectProperty((Integer) cellData.getValue().get(0)));
        nombreColumna.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get(1)));
        valorColumna.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(2)));
        valorDeVentaColumna.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(3)));
        valorDeHipotecaColumna.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(4)));
        propietarioColumna.setCellValueFactory(cellData -> new SimpleObjectProperty<>((String) cellData.getValue().get(5)));
        // Configurar celdas de botón personalizadas para las columnas de vender y hipotecar
        venderColumna.setCellFactory(createButtonCellFactory("Vender"));
        hipotecarColumna.setCellFactory(createButtonCellFactory("Hipotecar"));
        perteneceColumna.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Boolean) cellData.getValue().get(6)));
    }
    public void llenarTablaDeHipoteca(int indice) {
        //ObservableList<List<Object>> datosPropiedadesHipotecadas = tViewDatosProopiedadesHipotecadas.getItems();
        ObservableList<List<Object>> datosPropiedadesHipotecadas = tViewDatosProopiedadesHipotecadas.getItems();
        List<List<Object>> datosJ1 = (List<List<Object>>) AppContext.getInstance().get("J1");

        if (indice >= 0 && indice < datosJ1.size()) {
            List<Object> datoEliminado = datosJ1.get(indice);  // Obtiene el dato a eliminar
            datosPropiedadesHipotecadas.addAll(datoEliminado);
            datosJ1.remove(indice);
        } else {
            System.out.println("El índice no existe");
        }

        // Configurar las celdas de cada columna
        idColumnaH.setCellValueFactory(cellData -> new SimpleObjectProperty((Integer) cellData.getValue().get(0)));
        nombreColumnaH.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get(1)));
        valorColumnaH.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(2)));
        valorDeVentaColumnaH.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(3)));
        valorDeHipotecaColumnaH.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(4)));
        // Configurar celdas de botón personalizadas para las columnas de vender y hipotecar
        liberarHColumna.setCellFactory(createButtonCellFactory("Liberar"));
    }
    
     public void liberarHipoteca() {
       
    }
    
    
        
    private Callback<TableColumn<List<Object>, Boolean>, TableCell<List<Object>, Boolean>> createButtonCellFactory(String buttonText) {
        return new Callback<TableColumn<List<Object>, Boolean>, TableCell<List<Object>, Boolean>>() {
            @Override
            public TableCell<List<Object>, Boolean> call(final TableColumn<List<Object>, Boolean> param) {
                return new TableCell<List<Object>, Boolean>() {
                    private final Button button = new Button(buttonText);

                    {
                        button.setOnAction(event -> {

                            List<Object> rowData = getTableView().getItems().get(getIndex());

                            if (buttonText == "Vender") {

                                VentasJ1 ventaJ1 = new VentasJ1();
                                ventaJ1.setVentaJ1((Double) rowData.get(2));
                                AppContext.getInstance().set("VentaJ1", ventaJ1);

                                List<String> propiedadesLibres = (List<String>) AppContext.getInstance().get("propiedadesLibres");
                                List<String> propiedadesOcupadasJ1 = (List<String>) AppContext.getInstance().get("propiedadesOcupadasJ1");
                                propiedadesOcupadasJ1.remove(rowData.get(1));  // Elimina el dato de propiedadesOcupadas
                                propiedadesLibres.add((String) rowData.get(1));   // Agrega el dato a propiedadesLibres
                                AppContext.getInstance().set("propiedadesLibres", propiedadesLibres);
                                AppContext.getInstance().set("propiedadesOcupadasJ1", propiedadesOcupadasJ1);

                                List<List<Object>> datosJ1 = (List<List<Object>>) AppContext.getInstance().get("J1");
                                int indiceABorrar = getIndex(); // Índice que se desea borrar

                                if (indiceABorrar >= 0 && indiceABorrar < datosJ1.size()) {
                                    datosJ1.remove(indiceABorrar);

                                } else {
                                    System.out.println("El índice no existe");
                                }
                                llenarTabla();
                            }
                            if (buttonText == "Hipotecar") {

                                VentasJ1 ValHipoteca1 = new VentasJ1();
                                ValHipoteca1.setValHipoteca1((Double) rowData.get(4));
                                AppContext.getInstance().set("ValHipoteca1", ValHipoteca1);

                                List<String> listaPropiedadHipotecadaJ1 = (List<String>) AppContext.getInstance().get("listaPropiedadHipotecadaJ1");
                                List<String> propiedadesOcupadasJ1 = (List<String>) AppContext.getInstance().get("propiedadesOcupadasJ1");
                                propiedadesOcupadasJ1.remove(rowData.get(1));  // Elimina el dato de propiedadesOcupadas
                                listaPropiedadHipotecadaJ1.add((String) rowData.get(1));   // Agrega el dato a propiedadesLibres
                                AppContext.getInstance().set("propiedadesOcupadasJ1", propiedadesOcupadasJ1);
                                AppContext.getInstance().set("listaPropiedadHipotecadaJ1", listaPropiedadHipotecadaJ1);

                                llenarTablaDeHipoteca(getIndex());
                                llenarTabla();
                               // liberarHipoteca(getIndex());
                            }

                            if (buttonText == "Liberar") {
                                
                                VentasJ1 RestaPagoHipoteca1 = new VentasJ1();
                                RestaPagoHipoteca1.setRestaPagoHipoteca1((Double) rowData.get(4)+(Double) rowData.get(4)*0.2);
                                AppContext.getInstance().set("RestaPagoHipoteca1", RestaPagoHipoteca1);
                                
                                
                                
                                List<String> listaPropiedadHipotecadaJ1 = (List<String>) AppContext.getInstance().get("listaPropiedadHipotecadaJ1");
                                List<String> propiedadesOcupadasJ1 = (List<String>) AppContext.getInstance().get("propiedadesOcupadasJ1");
                                listaPropiedadHipotecadaJ1.remove(rowData.get(1));  // Elimina el dato de propiedadesOcupadas
                                propiedadesOcupadasJ1.add((String) rowData.get(1));   // Agrega el dato a propiedadesLibres
                                AppContext.getInstance().set("propiedadesOcupadasJ1", propiedadesOcupadasJ1);
                                AppContext.getInstance().set("listaPropiedadHipotecadaJ1", listaPropiedadHipotecadaJ1);

                                /// de aqui en adelante
                                ObservableList<List<Object>> datosPropiedadesHipotecadas = tViewDatosProopiedadesHipotecadas.getItems();

                                if (getIndex() >= 0 && getIndex() < datosPropiedadesHipotecadas.size()) {
                                    List<Object> datoEliminado = datosPropiedadesHipotecadas.get(getIndex());  // Obtiene el dato a eliminar
                                    propiedadesOcupadas1.addAll(datoEliminado);
                                    datosPropiedadesHipotecadas.remove(getIndex());
                                } else {
                                    System.out.println("El índice no existe");
                                }

                               /* // Configurar las celdas de cada columna
                                idColumnaH.setCellValueFactory(cellData -> new SimpleObjectProperty((Integer) cellData.getValue().get(0)));
                                nombreColumnaH.setCellValueFactory(cellData -> new SimpleStringProperty((String) cellData.getValue().get(1)));
                                valorColumnaH.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(2)));
                                valorDeVentaColumnaH.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(3)));
                                valorDeHipotecaColumnaH.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get(4)));
                                // Configurar celdas de botón personalizadas para las columnas de vender y hipotecar
                                liberarHColumna.setCellFactory(createButtonCellFactory("Liberar"));

                                // Actualizar la tabla con las propiedades ocupadas
                                tViewDatosProopiedadesHipotecadas.setItems(propiedadesOcupadas1);*/
         
                             ///////////////////////////////////////////////Hata aqui   
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
        llenarTabla();
      
    }

    @FXML
    private void onActionBtnCerrar(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    private void onKeyPressedCargar(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            llenarTabla();
        }
    }

}

class VentasJ1 {
    private int ventaPropi=0;
    private double VentaJ1;
    private double ValHipoteca1;
    private double RestaPagoHipoteca1;
    

    public int getVentaPropi() {
        return ventaPropi;
    }

    public void setVentaPropi(int ventaPropi) {
        this.ventaPropi = ventaPropi;
    }

    public double getVentaJ1() {
        return VentaJ1;
    }

    public void setVentaJ1(double VentaJ1) {
        this.VentaJ1 = VentaJ1;
    }

    public double getValHipoteca1() {
        return ValHipoteca1;
    }

    public void setValHipoteca1(double ValHipoteca) {
        this.ValHipoteca1 = ValHipoteca;
    }

    public double getRestaPagoHipoteca1() {
        return RestaPagoHipoteca1;
    }

    public void setRestaPagoHipoteca1(double RestaPagoHipoteca1) {
        this.RestaPagoHipoteca1 = RestaPagoHipoteca1;
    }
    

}
