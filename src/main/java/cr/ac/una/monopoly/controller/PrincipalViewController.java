/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.monopoly.util.AppContext;
import cr.ac.una.monopoly.util.FlowController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import cr.ac.una.monopoly.controller.Datos;
import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Servidor
 */
public class PrincipalViewController extends Controller implements Initializable {

    @FXML
    private JFXTextField txfJugador2;
    @FXML
    private JFXTextField txfJugador1;

   public void nombreJugadores(String nombre1,String nombre2){
       lblName1.setText(nombre1);
          lblName2.setText(nombre2);
    }
    @FXML
    private JFXButton btnFinalizarJuego;

    @FXML
    private JFXButton btnLanzarDados;

    @FXML
    private JFXButton btnPagarHipoteca;

    @FXML
    private JFXButton btnPropiedades1;

    @FXML
    private JFXButton btnPropiedades2;

    @FXML
    private JFXButton btnTerminarTurno;

    @FXML
    private GridPane gridPaneTablero;

    @FXML
    private ImageView imgDado1;

    @FXML
    private ImageView imgDado2;

    @FXML
    private Label lblName1;

    @FXML
    private Label lblName2;

    @FXML
    private Label lblresul;

    private int valDados= 0;
    private int valTotal=0;
       private int sumaTotal1=0;
         private int sumaTotal2=0;
    private int comodin;
    
    private int fila;
    
    private int columna;
    private int c;
    private int f;
    private Image fichaJugador1=new Image("/cr/ac/una/monopoly/resources/helicoptero.png");
    private Image fichaJugador2=new Image("/cr/ac/una/monopoly/resources/sombrero.png");
    @FXML
    void onActionBtnFinalizarJuego(ActionEvent event) {
        FlowController.getInstance().salir();

    }

    @FXML
void onActionBtnLanzarDados(ActionEvent event) {
    int dado1 = lanzarDado();
    int dado2 = lanzarDado();
    int total = dado1 + dado2;

    mostrarResultado(total);
    actualizarValores(total);
    actualizarSumaTotal(total);
    actualizarTextoJugador1();
    mostrarImagenDado(dado1, imgDado1);
    mostrarImagenDado(dado2, imgDado2);
    btnLanzarDados.setDisable(true);
}

int lanzarDado() {
    return (int) (Math.random() * 6) + 1;
}

void mostrarResultado(int total) {
    lblresul.setText("Suma: " + total);
    valDados = total;
    valTotal = 0;
}

void actualizarValores(int total) {
    if (jugadorActual == 1) {
        valTotal = total + sumaTotal1;
    } else if (jugadorActual == 2) {
        valTotal = total + sumaTotal2;
    }

    if (valTotal > 31) {
        valTotal %= 32;
    }
}

void actualizarSumaTotal(int total) {
    if (jugadorActual == 1) {
        sumaTotal1 = valTotal;
    } else if (jugadorActual == 2) {
        sumaTotal2 = valTotal;
    }
}

void actualizarTextoJugador1() {
    txfJugador1.setText(String.valueOf(valTotal));
}

void mostrarImagenDado(int dado, ImageView imageView) {
    Image uno = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado1.png"));
    Image dos = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado2.png"));
    Image tres = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado3.png"));
    Image cuatro = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado4.png"));
    Image cinco = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado5.png"));
    Image seis = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado6.png"));

    switch (dado) {
        case 1:
            imageView.setImage(uno);
            break;
        case 2:
            imageView.setImage(dos);
            break;
        case 3:
            imageView.setImage(tres);
            break;
        case 4:
            imageView.setImage(cuatro);
            break;
        case 5:
            imageView.setImage(cinco);
            break;
        case 6:
            imageView.setImage(seis);
            break;
    }
}

    @FXML
    void onActionBtnPagarHipoteca(ActionEvent event) {

    }

    @FXML
    void onActionBtnPropiedades1(ActionEvent event) {

    }

    @FXML
    void onActionBtnPropiedades2(ActionEvent event) {

    }
    private boolean fichaJugador2Creada = false;
private int jugadorActual = 1;
    @FXML
    void onActionBtnTerminarTurno(ActionEvent event) {
        imgDado1.setImage(new Image("/cr/ac/una/monopoly/resources/fondoDado.png"));
        imgDado2.setImage(new Image("/cr/ac/una/monopoly/resources/fondoDado.png"));
        btnLanzarDados.setDisable(false);
        jugadorActual = (jugadorActual == 1) ? 2 : 1;
    if (!fichaJugador2Creada) {
        Circle ficha2 = crearFicha(Color.BLUE, fichaJugador2);
        fichaJugador2Creada = true;
    }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Datos datos = (Datos) AppContext.getInstance().get("Llave");
    lblName1.setText(datos.getJugador1());
    lblName2.setText(datos.getJugador2());
    
    Circle ficha1 = crearFicha(Color.GREEN, fichaJugador1);
        
 
   initPositionMap();
    }    
    @Override
    public void initialize() {
    }
      
    
    private Map<Integer, Position> positionMap;

// Clase auxiliar para representar una posición en el GridPane
private class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}

// Método de inicialización para crear el mapeo de posiciones
private void initPositionMap() {
            positionMap = new HashMap<>();
    positionMap.put(0, new Position(8, 8));
    positionMap.put(1, new Position(8, 7));
    positionMap.put(2, new Position(8, 6));
    positionMap.put(3, new Position(8, 5));
    positionMap.put(4, new Position(8, 4));
    positionMap.put(5, new Position(8, 3));
    positionMap.put(6, new Position(8, 2));
    positionMap.put(7, new Position(8, 1));
    positionMap.put(8, new Position(8, 0));
    positionMap.put(9, new Position(7, 0));
    positionMap.put(10, new Position(6, 0));
    positionMap.put(11, new Position(5, 0));
    positionMap.put(12, new Position(4, 0));
    positionMap.put(13, new Position(3, 0));
    positionMap.put(14, new Position(2, 0));
    positionMap.put(15, new Position(1, 0));
    positionMap.put(16, new Position(0, 0));
    positionMap.put(17, new Position(0, 1));
    positionMap.put(18, new Position(0, 2));
    positionMap.put(19, new Position(0, 3));
    positionMap.put(20, new Position(0, 4));
    positionMap.put(21, new Position(0, 5));
    positionMap.put(22, new Position(0, 6));
    positionMap.put(23, new Position(0, 7));
    positionMap.put(24, new Position(0, 8));
    positionMap.put(25, new Position(1, 8));
    positionMap.put(26, new Position(2, 8));
    positionMap.put(27, new Position(3, 8));
    positionMap.put(28, new Position(4, 8));
    positionMap.put(29, new Position(5, 8));
    positionMap.put(30, new Position(6, 8));
    positionMap.put(31, new Position(7, 8));


}
private Circle crearFicha(Color color, Image fichaImage) {
    Circle ficha = new Circle(14);
    ficha.setFill(color);
    ImageView fichaImageView = new ImageView(fichaImage);
    fichaImageView.setFitWidth(50);
    fichaImageView.setFitHeight(50);
    gridPaneTablero.add(fichaImageView, 8, 8);

    fichaImageView.setOnMouseClicked(event -> {
        if ((jugadorActual == 1 && color == Color.GREEN) || (jugadorActual == 2 && color == Color.BLUE)) {
            c = gridPaneTablero.getColumnIndex(fichaImageView);
            f = gridPaneTablero.getRowIndex(fichaImageView);
            int comodin = 0;

            Position position = positionMap.get(valTotal);
            if (position != null) {
                columna = position.getColumn();
                fila = position.getRow();
            } 

            gridPaneTablero.setColumnIndex(ficha, columna);
            gridPaneTablero.setRowIndex(ficha, fila);
            gridPaneTablero.setColumnIndex(fichaImageView, columna);
            gridPaneTablero.setRowIndex(fichaImageView, fila);
        }
    });
    
    txfJugador2.setText("C:" + c + " y F:" + f);
    
    return ficha;
}
}
