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
import cr.ac.una.monopoly.util.Mensaje;
import cr.ac.una.monopoly.util.Position;
import cr.ac.una.monopoly.controller.Banco;
//import cr.ac.una.monopoly.controller.BancoViewController;
import java.util.HashMap;
import java.util.Map;
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
    @FXML
    private ImageView ImVJugador1;
    @FXML
    private ImageView ImVJugador2;
    @FXML
    private Label lblSaldoJugador1;
    @FXML
    private Label lblSaldoJugador2;
    @FXML
    private JFXTextField Vuelta1;
    @FXML
    private JFXTextField Vuelta2;  
    @FXML
    private JFXButton btnFinalizarJuego;
    @FXML
    private JFXButton btnLanzarDados;
    @FXML
    private JFXButton btnComprar;
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
    private ImageView carta = new ImageView();  
    private int valDados= 0;
    private int valTotal=0;
    private int sumaTotal1=0;
    private int sumaTotal2=0;
    private int comodin;
    private double cuentaJugador1 = 0;
    private double cuentaJugador2 = 0;
private boolean fichaJugador2Creada = false;
    private int jugadorActual = 1;
    private int fila;
    private int columna;
    private int c;
    private int f;
    private Image imageJ1;
    private Image imageJ2;
    double saldoJ1 = 0;
    double saldoJ2 = 0;
    int contadorJ1;
    int contadorJ2;
    private int myVariable;
   
void montarCarta(){

mostrarImagenSuerte(carta);
int startColumn = 3;  // Columna inicial
int endColumn = 6;    // Columna final
int startRow = 3;     // Fila inicial
int endRow = 6;       // Fila final
GridPane.setConstraints(carta, startColumn, startRow, endColumn - startColumn + 1, endRow - startRow + 1);
gridPaneTablero.getChildren().add(carta);

}

void mostrarImagenSuerte(ImageView imageView){
    int numeroSuerte = (int)(Math.random()*16) +1;
      Image uno = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte1.png"));
      Image dos = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte2.png"));
    Image tres = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte3.png"));
    Image cuatro = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte4.png"));
    Image cinco = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte5.png"));
    Image seis = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte6.png"));
  Image siete = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte7.png"));
    Image ocho = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte8.png"));
    Image nueve = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte9.png"));
    Image diez = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte10.png"));
    Image once = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte11.png"));
    Image doce = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte12.png"));
    Image trece = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte13.png"));
    Image catorce = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte14.png"));
    Image quince = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte15.png"));
    Image dieciseis = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte16.png"));

    switch (numeroSuerte) {
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
        case 7:
            imageView.setImage(siete);
            break;
        case 8:
            imageView.setImage(ocho);
            break;
        case 9:
            imageView.setImage(nueve);
            break;
        case 10:
            imageView.setImage(diez);
            break;
        case 11:
            imageView.setImage(once);
            break;
        case 12:
            imageView.setImage(doce);
            break;
        case 13:
            imageView.setImage(trece);
            break;
        case 14:
            imageView.setImage(catorce);
            break;
        case 15:
            imageView.setImage(quince);
            break;
        case 16:
            imageView.setImage(dieciseis);
            break;
    }
}

    @FXML
    void onActionBtnTerminarTurno(ActionEvent event) {
        imgDado1.setImage(new Image("/cr/ac/una/monopoly/resources/fondoDado.png"));
        imgDado2.setImage(new Image("/cr/ac/una/monopoly/resources/fondoDado.png"));
        btnLanzarDados.setDisable(false);
        btnComprar.setDisable(false);
        carta.setImage(null);
        jugadorActual = (jugadorActual == 1) ? 2 : 1;
        if (!fichaJugador2Creada) {
            Circle ficha2 = crearFicha(Color.BLUE, imageJ2);
            fichaJugador2Creada = true;
        }
    }

    public void nombreJugadores(String nombre1, String nombre2) {
        lblName1.setText(nombre1);
        lblName2.setText(nombre2);
    }

    @FXML
    void onActionBtnFinalizarJuego(ActionEvent event) {
       // FlowController.getInstance().salir();
       cuentaJugador1+=100;
       cargarValores();
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
    revizar();
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
    }}

    void actualizarValores(int total) {
        if (jugadorActual == 1) {
            valTotal = total + sumaTotal1;
            contarVueltas1(valTotal, 1);
        }else if (jugadorActual == 2) {
            valTotal = total + sumaTotal2;
            contarVueltas2(valTotal,2);
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
    
    void contarVueltas1(int valor, int id) {
        if (valor > 32) {
            int prueba = (31 - valor) * -1;
            valor = 0;
            if (valor == 0) {
                contadorJ1++;
                pagoGo("J1", 200);
                 Vuelta1.setText("Vuelta: " + String.valueOf(contadorJ1));
                
            }
        }
    }
    
     void contarVueltas2(int valor, int id) {
        if (valor > 32) {
            int prueba = (31 - valor) * -1;
            valor = 0;
            if (valor == 0) {
                contadorJ2++;
                 pagoGo("J2", 200);
                 Vuelta2.setText("Vuelta: " + String.valueOf(contadorJ2));
            }
        }
    }
  @Override
    public void initialize(URL url, ResourceBundle rb) {
       String rutaJ1 = "/cr/ac/una/monopoly/resources/circuloAzul.png";
        String rutaJ2 = "/cr/ac/una/monopoly/resources/circuloVerde.png";

        Datos datos = (Datos) AppContext.getInstance().get("Llave");
        lblName1.setText(datos.getJugador1());
        lblName2.setText(datos.getJugador2());
        Datos rut = (Datos) AppContext.getInstance().get("Ruta");

        if (rut != null) {
            if (rut.getRuta1() != null) {
                System.out.println("Esta es la ruta1 que jala: " + rut.getRuta1());
                System.out.println("Esta es la ruta2 que jala: " + rut.getRuta2());
                rutaJ1 = rut.getRuta1();
                rutaJ2 = rut.getRuta2();

            }
        }

     imageJ1 = new Image(rutaJ1);
        ImVJugador1.setImage(imageJ1);
      imageJ2= new Image(rutaJ2);
        ImVJugador2.setImage(imageJ2);

        Circle ficha1 = crearFicha(Color.GREEN, imageJ1);
        bonoInicial();
    } 
    @FXML
    void onActionBtnComprar(ActionEvent event) {
    Position position = this.position.getPositionMap().get(valTotal);
    
Mensaje mensaje = new Mensaje();
    if (position != null && !position.isOwned()&& position.getPrice() != 0 ) {
        position.setOwnedBy(jugadorActual);
        double total=0;
            
            if(jugadorActual==1){

        total = cuentaJugador1-position.getPrice();
    cuentaJugador1=total;}
            else{
      
        total = cuentaJugador2-position.getPrice();
           cuentaJugador2=total;  }
            
        // Realizar las acciones necesarias al comprar la posición
        // Por ejemplo, actualizar el estado de la posición en la GUI, ajustar el saldo del jugador, etc.
        // Mostrar un mensaje de confirmación
       String mensajeTexto = "¡Has comprado la Propiedad " + position.getName() + "!";
        mensaje.showConfirmation("Confirmación de compra", gridPaneTablero.getScene().getWindow(), mensajeTexto);
     } else {
       String mensajeTexto = "La Propiedad " + position.getName() + " no está disponible para comprar.";
        mensaje.showConfirmation("Error", gridPaneTablero.getScene().getWindow(), mensajeTexto);
      }
    cargarValores();
    btnComprar.setDisable(true);
    }
    
    void onActionBtnPagarHipoteca(ActionEvent event) {
       pagoGo("J1", 200);


    }

    @FXML
    void onActionBtnPropiedades1(ActionEvent event) {

    }

    @FXML
    void onActionBtnPropiedades2(ActionEvent event) {

    }
void revizar() {
    Position position = this.position.getPositionMap().get(valTotal);
    String characteristic = position.getCharacteristic();
    
    carta.setImage(null); // Vaciar la imagen por defecto
    
    switch (characteristic) {
        case "Suerte":
            montarCarta();
            break;
        case "Ve a carcel":
        case "Carcel":
        case "Go":
        case "Libre":
            // No se requiere acción adicional
            break;
        default:
            break;
    }
    
    btnComprar.setDisable(characteristic.equals("Suerte") || characteristic.equals("Ve a carcel") ||
                          characteristic.equals("Carcel") || characteristic.equals("Go") ||
                          characteristic.equals("Libre"));
}

 
    
    @Override
    public void initialize() {
        
    }
    
private Position position = new Position();
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
            Position actualPosition = this.position.getPositionMap().get(valTotal);
            if (position != null) {
                columna = actualPosition.getColumn();
                fila = actualPosition.getRow();
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


    private void metodoReceptor() {
        Banco BonoInicial = (Banco) AppContext.getInstance().get("BonoInicial");
        cuentaJugador1 += BonoInicial.getCuentaJ1();
        cuentaJugador2 += BonoInicial.getCuentaJ2();
        cargarValores();
       
    }
    
    
    private void cargarValores() {
        lblSaldoJugador1.setText("$" + String.valueOf(cuentaJugador1));
        lblSaldoJugador2.setText("$" + String.valueOf(cuentaJugador2));

    }
 
    public void bonoInicial() {
        BancoViewController bancoViewController = new BancoViewController();
        bancoViewController.pagarBonoInicial();
        metodoReceptor();
    }
    
    public void pagoGo(String Jugador, double cantidad) {
        BancoViewController bancoViewController = new BancoViewController();
        bancoViewController.pagarBonoGO(Jugador,cantidad);
        metodoReceptor();
    }
 
}
