/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import com.jfoenix.controls.JFXButton;
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

/**
 * FXML Controller class
 *
 * @author Servidor
 */
public class PrincipalViewController extends Controller implements Initializable {

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

    @FXML
    void onActionBtnFinalizarJuego(ActionEvent event) {
        FlowController.getInstance().salir();

    }

    @FXML
    void onActionBtnLanzarDados(ActionEvent event) {
        
        int dado1=(int)(Math.random()*6)+1;
    int dado2=(int)(Math.random()*6)+1;
     int total = dado1+dado2;
    lblresul.setText("Suma: "+total);
    valDados=total;
    valTotal+=valDados;
    
    if (valTotal>32){
    valTotal = 0;
    //txfJugador1.setText(String.valueOf(valTotal));
    }
    else { /*txfJugador1.setText(String.valueOf(valTotal));*/}
    txfJugador1.setText(String.valueOf(valTotal));
    Image uno=new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado1.png"));
    Image dos=new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado2.png"));
    Image tres=new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado3.png"));
    Image cuatro=new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado4.png"));
    Image cinco=new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado5.png"));
    Image seis=new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Dado6.png"));
    switch(dado1){
        case 1:imgDado1.setImage(uno); break;
     case 2:imgDado1.setImage(dos); break;
      case 3:imgDado1.setImage(tres); break;
       case 4:imgDado1.setImage(cuatro); break;
        case 5:imgDado1.setImage(cinco); break;
         case 6:imgDado1.setImage(seis); break;
    }
    switch(dado2){
        case 1:imgDado2.setImage(uno); break;
     case 2:imgDado2.setImage(dos); break;
      case 3:imgDado2.setImage(tres); break;
       case 4:imgDado2.setImage(cuatro); break;
        case 5:imgDado2.setImage(cinco); break;
         case 6:imgDado2.setImage(seis); break;
    }
   btnLanzarDados.setDisable(true);

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

    @FXML
    void onActionBtnTerminarTurno(ActionEvent event) {
        imgDado1.setImage(new Image("/cr/ac/una/monopoly/resources/fondoDado.png"));
        imgDado2.setImage(new Image("/cr/ac/una/monopoly/resources/fondoDado.png"));
         btnLanzarDados.setDisable(false);
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Datos datos = (Datos) AppContext.getInstance().get("Llave");
   /* txfJugador1.setText(datos.getJugador1());
    txfJugador2.setText(datos.getJugador2());*/
    lblName1.setText(datos.getJugador1());
    lblName2.setText(datos.getJugador2());
    
    Circle ficha1 = crearFicha(Color.GREEN);
   // Circle ficha2 = crearFicha(Color.BLUE); 
    
    gridPaneTablero.add(ficha1, 8, 8);
   // gridPaneTablero.add(ficha2, 8, 8);
    }    

    @Override
    public void initialize() {
    }
   
   private Circle crearFicha(Color color) {
    Circle ficha = new Circle(14);
    ficha.setFill(color);

    ficha.setOnMouseClicked(event -> {

        //valDados; No esta al 100 esta funcion aun hay que trabajarla 
        int posInicial=0;
        int pos =0;
            pos+=valTotal;
        int resto=0;
        
         if (pos <=8) {
            fila = 8;
            columna = 8 - pos;
        } else if (pos >8 || pos <= 17) {
            fila = 8 - valTotal;
            columna = 0;
        } else if (pos > 17 || pos <= 25) {
            fila = 0;
            columna = 0 + valDados;
        } else if (pos > 25 || pos <= 32) {
            fila = 0 + valDados;
            columna = 8;
        } 
      
        txfJugador2.setText(String.valueOf(resto));
    
        gridPaneTablero.setColumnIndex(ficha, columna);
        gridPaneTablero.setRowIndex(ficha, fila);
 
        
    });

    return ficha;
}
    
}
