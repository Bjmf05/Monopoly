/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import cr.ac.una.monopoly.model.CartasSuerte;
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
import cr.ac.una.monopoly.model.Position;
import cr.ac.una.monopoly.model.BancoGame;
import cr.ac.una.monopoly.model.Game;
import cr.ac.una.monopoly.model.GameDto;
import cr.ac.una.monopoly.model.GuardarPropiedad;
import cr.ac.una.monopoly.model.PositionControl;
import cr.ac.una.monopoly.model.PropiedadDto;
import cr.ac.una.monopoly.service.GameService;
import cr.ac.una.monopoly.service.PropiedadService;
import cr.ac.una.monopoly.util.Respuesta;
import cr.ac.una.unaplanilla.util.BindingUtils;
import java.time.LocalDate;

import java.util.ArrayList;
//import cr.ac.una.monopoly.controller.BancoViewController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
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
    private JFXButton btnGuardar;
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
    private boolean monopoly1Creado = false;
    private boolean monopoly2Creado = false;
    private boolean monopoly3Creado = false;
    private boolean monopoly4Creado = false;
    private boolean monopoly5Creado = false;
    private boolean monopoly6Creado = false;
    private ImageView carta = new ImageView();
    private int valDados = 0;
    private int valTotal = 0;
    private int sumaTotal1 = 0;
    private int sumaTotal2 = 0;
    private int comodin;
    private int valorUtilidades = 10;
    @FXML
    private ImageView imvEmojiJ1;
    @FXML
    private ImageView imvEmojiJ2;
    @FXML
    private JFXButton btnConstruir;

    public double getCuentaJugador1() {
        return cuentaJugador1;
    }

    public void setCuentaJugador1(double cuentaJugador1) {
        this.cuentaJugador1 = cuentaJugador1;
    }

    public double getCuentaJugador2() {
        return cuentaJugador2;
    }

    public void setCuentaJugador2(double cuentaJugador2) {
        this.cuentaJugador2 = cuentaJugador2;
    }
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
    int venta = 0;
    int contadorJ1;
    int contadorJ2;
    private int myVariable;
    @FXML
    private Label lblJCuentaPasos;
    @FXML
    private Label lblJugadorEnTurno;
    List<Object> listaJ1 = new ArrayList<>();

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    void montarCarta() {
        gridPaneTablero.getChildren().remove(carta);
        mostrarImagenSuerte(carta);
        int startColumn = 3; 
        int endColumn = 6;    
        int startRow = 3;     
        int endRow = 6;       
        GridPane.setConstraints(carta, startColumn, startRow, endColumn - startColumn + 1, endRow - startRow + 1);

        gridPaneTablero.getChildren().add(carta);

    }

    void mostrarImagenSuerte(ImageView imageView) {
        int numeroSuerte = (int) (Math.random() * 16) + 1;
        CartasSuerte suerte = new CartasSuerte();
        suerte.cartasSuertes(imageView, numeroSuerte);
        accionesSuerte(numeroSuerte);
    }

    void accionesSuerte(int numeroSuerte) {
        switch (numeroSuerte) {
            case 1:
                carcel();
                break;
            case 2:
                //ve a GO
                valTotal = 0;
                actualizarSumaTotal(valTotal);

                break;
            case 3:
                if (jugadorActual == 1) {
                    cuentaJugador1 += 600;
                } else {
                    cuentaJugador2 += 600;
                }
                break;
            case 4:
                if (jugadorActual == 1) {
                    cuentaJugador1 -= 20;
                } else {
                    cuentaJugador2 -= 200;
                }
                break;
            case 5:
                valTotal -= 2;
                actualizarSumaTotal(valTotal);
                break;
            case 6:
                if (jugadorActual == 1) {
                    cuentaJugador1 += 400;
                } else {
                    cuentaJugador2 += 400;
                }
                break;
            case 7:
                if (jugadorActual == 1) {
                    cuentaJugador1 -= 500;
                } else {
                    cuentaJugador2 -= 500;
                }
                break;
            case 8:
                if (jugadorActual == 1) {
                    cuentaJugador1 -= 50;
                    cuentaJugador2 += 50;
                } else {
                    cuentaJugador2 -= 50;
                    cuentaJugador1 += 50;
                }
                break;
            case 9:
                if (jugadorActual == 1) {
                    cuentaJugador1 -= 20;
                } else {
                    cuentaJugador2 -= 20;
                }
                break;
            case 10:
                if (jugadorActual == 1) {
                    cuentaJugador1 += 100;
                } else {
                    cuentaJugador2 += 100;
                }
                break;
            case 11:

                break;
            case 12:
                if (jugadorActual == 1) {
                    cuentaJugador1 += 50;
                } else {
                    cuentaJugador2 += 50;
                }
                break;
            case 13:
                //paseo a zona franca
                valTotal = 12;
                actualizarSumaTotal(valTotal);
                break;
            case 14:
            case 15:
                if (jugadorActual == 1) {
                    cuentaJugador1 -= 100;
                } else {
                    cuentaJugador2 -= 100;
                }
                break;
            case 16:
                if (jugadorActual == 1) {
                    cuentaJugador1 += 50;
                } else {
                    cuentaJugador2 += 50;
                }
                break;
        }
    }

    @FXML
    void onActionBtnTerminarTurno(ActionEvent event) {

        imgDado1.setImage(new Image("/cr/ac/una/monopoly/resources/fondoDado.png"));
        imgDado2.setImage(new Image("/cr/ac/una/monopoly/resources/fondoDado.png"));
        btnLanzarDados.setDisable(false);
        btnComprar.setDisable(false);

        jugadorActual = (jugadorActual == 1) ? 2 : 1;
        if (!fichaJugador2Creada) {
            Circle ficha2 = crearFicha(Color.BLUE, imageJ2);
            fichaJugador2Creada = true;
        }
        lblJugadorEnTurno.setText(" ");
        lblJCuentaPasos.setText("0");
        cargarValores();
        gridPaneTablero.getChildren().remove(carta);
        btnTerminarTurno.setDisable(true);

    }

    public void nombreJugadores(String nombre1, String nombre2) {
        lblName1.setText(nombre1);
        lblName2.setText(nombre2);
    }

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
        revizar();
        btnLanzarDados.setDisable(true);
        btnTerminarTurno.setDisable(false);

    }

    int lanzarDado() {
        return (int) (Math.random() * 6) + 1;
    }

    void mostrarResultado(int total) {
        lblresul.setText(String.valueOf(total));
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
        }
    }

    void actualizarValores(int total) {
        Datos datos = (Datos) AppContext.getInstance().get("Llave");
        if (jugadorActual == 1) {
            valTotal = total + sumaTotal1;
            contarVueltas1(valTotal, 1);
            lblJugadorEnTurno.setText(datos.getJugador1());

            VentaJ2();
            VentaJ1();
        } else if (jugadorActual == 2) {
            valTotal = total + sumaTotal2;
            contarVueltas2(valTotal, 2);
            lblJugadorEnTurno.setText(datos.getJugador2());

            VentaJ1();
            VentaJ2();
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
        lblJCuentaPasos.setText(String.valueOf(valTotal));
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
        String rutaJ1 = "/cr/ac/una/monopoly/resources/circuloVerde.png";
        String rutaJ2 = "/cr/ac/una/monopoly/resources/circuloAzul.png";
        creaListaPropiedadesLibres();
        creaListaPropiedadesCompradas();

        Datos datos = (Datos) AppContext.getInstance().get("Llave");
        lblName1.setText(datos.getJugador1());
        lblName2.setText(datos.getJugador2());
        Datos rut = (Datos) AppContext.getInstance().get("Ruta");

        if (rut != null) {
            if (rut.getRuta1() != null) {
                rutaJ1 = rut.getRuta1();
                rutaJ2 = rut.getRuta2();

            }
        }

        imageJ1 = new Image(rutaJ1);
        ImVJugador1.setImage(imageJ1);
        imageJ2 = new Image(rutaJ2);
        ImVJugador2.setImage(imageJ2);

        Circle ficha1 = crearFicha(Color.GREEN, imageJ1);
        bonoInicial();

        List<Object> listaPreestablecida = (List<Object>) AppContext.getInstance().get("Vacia");
        if (listaPreestablecida == null) {
            listaPreestablecida = new ArrayList<>();
        }
        List<Object> nombres = new ArrayList<>();
        nombres.add(Integer.valueOf(0));
        nombres.add("No hay aras");
        nombres.add(Double.valueOf(0));
        nombres.add(Double.valueOf(0));
        nombres.add(Double.valueOf(0));
        nombres.add("Vacio");
        nombres.add(Boolean.valueOf(false));
        listaPreestablecida.add(nombres);
        AppContext.getInstance().set("Vacia", listaPreestablecida);
        btnTerminarTurno.setDisable(true);

    }

    public void venderPropiedad(int recivirVenta) {
        System.out.println(" Propiedad" + recivirVenta + "!");

        if (recivirVenta != 0) {
            Position position = this.positionControl.getPositionMap().get(recivirVenta);
            System.out.println(" Propiedad" + position.getNumPosition() + "Dueño" + position.getOwnedBy() + "!");
            position.setOwnedBy(2);
            System.out.println(" Propiedad" + position.getNumPosition() + "Dueño" + position.getOwnedBy() + "!");
        }

    }

    @FXML
    void onActionBtnComprar(ActionEvent event) {

        Position position = this.positionControl.getPositionMap().get(valTotal);

       
        List<String> propiedadesLibres = (List<String>) AppContext.getInstance().get("propiedadesLibres");
        List<String> propiedadesOcupadas = (List<String>) AppContext.getInstance().get("propiedadesOcupadas");
        int estado = 1;
        if (propiedadesLibres.contains(position.getName())) { 
            estado = 1;
        } else {
            estado = 0;
        }

        System.out.println("Comprar " + position.getOwnedBy());
        
        Mensaje mensaje = new Mensaje();
        
        if (position != null && position.getOwnedBy() == 0 && position.getPrice() != 0) {
            position.setOwnedBy(jugadorActual);

             if (estado == 1) {//Esto lo que hace es que compara si la propiedad es libre o no
                propiedadesLibres.remove(position.getName());  // Elimina el dato de propiedadesLibres
                propiedadesOcupadas.add(position.getName());   // Agrega el dato a propiedadesOcupadas
                AppContext.getInstance().set("propiedadesLibres", propiedadesLibres);
                AppContext.getInstance().set("propiedadesOcupadas", propiedadesOcupadas);
            }

            
            Position position1 = this.positionControl.getPositionMap().get(valTotal);
            System.out.println(position1.getOwnedBy());
            List<Object> datos1 = (List<Object>) AppContext.getInstance().get("J1");
            List<Object> datos2 = (List<Object>) AppContext.getInstance().get("J2");
            Datos datos = (Datos) AppContext.getInstance().get("Llave");
            if (jugadorActual == 1) {
              cuentaJugador1 -= position.getPrice();
                System.out.println("Comprar " + position.getOwnedBy());
                String nombre = position.getName();
                if (datos1 == null) {
                    datos1 = new ArrayList<>();
                }
                List<Object> nombres = new ArrayList<>();
                nombres.add(Integer.valueOf(position.getNumPosition()));
                nombres.add(position.getName());
                nombres.add(Double.valueOf(position.getPrice()));
                nombres.add(Double.valueOf(position.getPrice() * 0.75));
                nombres.add(Double.valueOf(position.getPrice()));
                nombres.add(datos.getJugador1());
                nombres.add(Integer.valueOf(position.getOwnedBy()));
                nombres.add(Double.valueOf(position.getPrice()));
                System.out.println("Propiedad Comprada: " + nombre);
                datos1.add(nombres);
                AppContext.getInstance().set("J1", datos1);

            } else {
                  cuentaJugador2 -= position.getPrice();

                String nombre = position.getName();
                if (datos2 == null) {
                    datos2 = new ArrayList<>();
                }
                List<Object> nombres = new ArrayList<>();
                nombres.add(Integer.valueOf(position.getNumPosition()));
                nombres.add(position.getName());
                nombres.add(Double.valueOf(position.getPrice()));
                nombres.add(Double.valueOf(position.getPrice() * 0.75));
                nombres.add(Double.valueOf(position.getPrice()));
                nombres.add(datos.getJugador2());
                nombres.add(Boolean.valueOf(position.isOwned()));
                System.out.println("Propiedad Comprada: " + nombre);
                datos2.add(nombres);
                AppContext.getInstance().set("J2", datos2);
            }
            String mensajeTexto = "¡Has comprado la Propiedad " + position.getName() + "!";
            mensaje.showConfirmation("Confirmación de compra", gridPaneTablero.getScene().getWindow(), mensajeTexto);
        } else {
            String mensajeTexto = "La Propiedad " + position.getName() + " no está disponible para comprar.";
            mensaje.showConfirmation("Error", gridPaneTablero.getScene().getWindow(), mensajeTexto);
        }
        cargarValores();
        monopolio();
        btnComprar.setDisable(true);
    }

    @FXML
    void onActionBtnPropiedades1(ActionEvent event) {

        FlowController.getInstance().goViewInWindow("Jugador1PropiedadesView");

    }

    @FXML
    void onActionBtnPropiedades2(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("Jugador2PropiedadesView");
    }

    void revizar() {
        cobroRenta();
        Position position = this.positionControl.getPositionMap().get(valTotal);
        String characteristic = position.getCharacteristic();
        switch (characteristic) {
            case "Ve a carcel":
                carcel();
                break;
            case "Suerte":
                montarCarta();
                break;
            default:
                break;

        }

        desHabilitarBotones();
        mostrarPropiedad();
        limpiarCarta();
    }

    void desHabilitarBotones() {
        Position position = this.positionControl.getPositionMap().get(valTotal);
        String characteristic = position.getCharacteristic();
        btnComprar.setDisable(characteristic.equals("Suerte") || characteristic.equals("Ve a carcel")
                || characteristic.equals("Carcel") || characteristic.equals("Go")
                || characteristic.equals("Libre"));
        btnConstruir.setDisable(characteristic.equals("Suerte") || characteristic.equals("Ve a carcel")
                || characteristic.equals("Carcel") || characteristic.equals("Go")
                || characteristic.equals("Libre") || characteristic.equals("Tren") || characteristic.equals("Utilidad"));
    }

    void mostrarPropiedad() {
        Position propiedad = new Position();
        gridPaneTablero.getChildren().remove(carta);
        propiedad.showPosition(carta, valTotal);
        int startColumn = 3;  
        int endColumn = 6;    
        int startRow = 3;    
        int endRow = 6;      
        GridPane.setConstraints(carta, startColumn, startRow, endColumn - startColumn + 1, endRow - startRow + 1);
        gridPaneTablero.getChildren().add(carta);
    }

    @Override
    public void initialize() {

    }

    public PositionControl positionControl = new PositionControl();

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
                Position actualPosition = this.positionControl.getPositionMap().get(valTotal);
                if (positionControl != null) {
                    columna = actualPosition.getColumn();
                    fila = actualPosition.getRow();
                }
                gridPaneTablero.setColumnIndex(ficha, columna);
                gridPaneTablero.setRowIndex(ficha, fila);
                gridPaneTablero.setColumnIndex(fichaImageView, columna);
                gridPaneTablero.setRowIndex(fichaImageView, fila);
            }
        });

        return ficha;
    }

    private void metodoReceptor() {

        BancoGame BonoInicial = (BancoGame) AppContext.getInstance().get("BonoInicial");
        cuentaJugador1 += BonoInicial.getCuentaJ1();
        cuentaJugador2 += BonoInicial.getCuentaJ2();
        cargarValores();

    }

    public double VentaJ1() {
        VentasJ1 venta = (VentasJ1) AppContext.getInstance().get("VentaJ1");
        if (venta != null) {
            cuentaJugador1 += venta.getVentaJ1();
            cargarValores();
            venta.setVentaJ1(0);

        }

        return cuentaJugador1;

    }

    private double VentaJ2() {
        VentasJ2 venta = (VentasJ2) AppContext.getInstance().get("VentaJ2");

        if (venta != null) {
            cuentaJugador2 += venta.getVentaJ2();
            cargarValores();
            venta.setVentaJ2(0);

        }

        return cuentaJugador2;

    }

    private void cargarValores() {
        lblSaldoJugador1.setText("$" + String.valueOf(cuentaJugador1));
        lblSaldoJugador2.setText("$" + String.valueOf(cuentaJugador2));

        String Juga1 = "/cr/ac/una/monopoly/resources/muybueno.png";
        String Juga2 = "/cr/ac/una/monopoly/resources/muybueno.png";
        if (jugadorActual == 1) {

            if (cuentaJugador1 <= 0) {
                Juga1 = "/cr/ac/una/monopoly/resources/malo.png";
            } else if (cuentaJugador1 > 0 && cuentaJugador1 < 1500) {
                Juga1 = "/cr/ac/una/monopoly/resources/regular.png";
            } else if (cuentaJugador1 >= 1500 && cuentaJugador1 <= 5000) {
                Juga1 = "/cr/ac/una/monopoly/resources/muybueno.png";
            } else {
                Juga1 = "/cr/ac/una/monopoly/resources/excelente.png";
            }
            imvEmojiJ1.setImage(new Image(Juga1));
        }

        if (jugadorActual == 2) {

            if (cuentaJugador2 <= 0) {
                Juga2 = "/cr/ac/una/monopoly/resources/malo.png";
            } else if (cuentaJugador2 > 0 && cuentaJugador2 < 1500) {
                Juga2 = "/cr/ac/una/monopoly/resources/regular.png";
            } else if (cuentaJugador2 >= 1500 && cuentaJugador2 <= 5000) {
                Juga2 = "/cr/ac/una/monopoly/resources/muybueno.png";
            } else {
                Juga2 = "/cr/ac/una/monopoly/resources/excelente.png";
            }
            imvEmojiJ2.setImage(new Image(Juga2));
        }

    }

    public void bonoInicial() {
        BancoGame bancoGame = new BancoGame();
        bancoGame.pagarBonoInicial();
        metodoReceptor();
    }

    public void pagoGo(String Jugador, double cantidad) {
        BancoGame bancoGame = new BancoGame();
        bancoGame.pagarBonoGO(Jugador, cantidad);
        metodoReceptor();
    }

    private void carcel() {
        valTotal = 8;
        actualizarSumaTotal(valTotal);
        Position position = this.positionControl.getPositionMap().get(valTotal);
        double multa = (int) (Math.random() * 301) + 20;

        String saldo;

        double residuo = 0;
        if (jugadorActual == 1) {
            residuo = cuentaJugador1;
            residuo -= multa;
            if (residuo <= 0) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Venta o hipoteca de activos", getStage(), "Es necesario vender o hipotecar sus propiedades para cancelar la multa. Cuyo valor es de $" + multa);
                FlowController.getInstance().goViewInWindow("Jugador1PropiedadesView");
                System.out.println(multa);
            } else if (residuo > 0) {
                cuentaJugador1 -= multa;

                System.out.println(multa);
            }
        } else if (jugadorActual == 2) {
            residuo = cuentaJugador2;
            residuo -= multa;
            if (residuo <= 0) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Venta o hipoteca de activos", getStage(), "Es necesario vender o hipotecar sus propiedades para cancelar la multa. Cuyo valor es de $" + multa);
                FlowController.getInstance().goViewInWindow("Jugador2PropiedadesView");
       
            } else if (residuo > 0) {
                cuentaJugador2 -= multa;

                System.out.println(multa);
            }
        }

        System.out.println(multa);
        cargarValores();
    }

    private void cobroRenta() {
        Position position = this.positionControl.getPositionMap().get(valTotal);
        double rent = position.getRent();

        if (position.isOwned() && jugadorActual != position.getOwnedBy()) {

            if (jugadorActual == 1) {
                if (valTotal == 2 || valTotal == 18) {
                    rent = rentaAguaOLuz() * valorUtilidades;
                }
                cuentaJugador1 -= rent;
                cuentaJugador2 += rent;
            } else {
                if (valTotal == 2 || valTotal == 18) {
                    rent = rentaAguaOLuz() * valorUtilidades;
                }
                cuentaJugador2 -= rent;
                cuentaJugador1 += rent;
            }
        }

        if (valTotal == 9 || valTotal == 23) {
            if (jugadorActual == 1) {
                cuentaJugador1 -= rent;
            } else {
                cuentaJugador2 -= rent;
            }
        }

    }

    void monopolio() {
        Mensaje mensaje = new Mensaje();

        // Monopolio 1
        Position position4 = this.positionControl.getPositionMap().get(4);
        Position position6 = this.positionControl.getPositionMap().get(6);
        Position position7 = this.positionControl.getPositionMap().get(7);

        if (jugadorActual == position4.getOwnedBy() && jugadorActual == position6.getOwnedBy() && jugadorActual == position7.getOwnedBy()) {
            if (!monopoly1Creado) {
                String nombre = (jugadorActual == 1) ? lblName1.getText() : lblName2.getText();
                String mensajeTexto = "! " + nombre + " ha conseguido un Monopolio!";
                mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);

                position4.setRent(position4.getRent() * 2);
                position6.setRent(position6.getRent() * 2);
                position7.setRent(position7.getRent() * 2);
                monopoly1Creado = true;
            }
        }

        // Monopolio 2
        Position position12 = this.positionControl.getPositionMap().get(12);
        Position position14 = this.positionControl.getPositionMap().get(14);
        Position position15 = this.positionControl.getPositionMap().get(15);

        if (jugadorActual == position12.getOwnedBy() && jugadorActual == position14.getOwnedBy() && jugadorActual == position15.getOwnedBy()) {
            if (!monopoly2Creado) {
                String nombre = (jugadorActual == 1) ? lblName1.getText() : lblName2.getText();
                String mensajeTexto = "! " + nombre + " ha conseguido un Monopolio!";
                mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);

                position12.setRent(position12.getRent() * 2);
                position14.setRent(position14.getRent() * 2);
                position15.setRent(position15.getRent() * 2);
                monopoly2Creado = true;
            }
        }

        // Monopolio 3
        Position position17 = this.positionControl.getPositionMap().get(17);
        Position position19 = this.positionControl.getPositionMap().get(19);
        Position position20 = this.positionControl.getPositionMap().get(20);

        if (jugadorActual == position17.getOwnedBy() && jugadorActual == position19.getOwnedBy() && jugadorActual == position20.getOwnedBy()) {
            if (!monopoly3Creado) {
                String nombre = (jugadorActual == 1) ? lblName1.getText() : lblName2.getText();
                String mensajeTexto = "! " + nombre + " ha conseguido un Monopolio!";
                mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);

                position17.setRent(position17.getRent() * 2);
                position19.setRent(position19.getRent() * 2);
                position20.setRent(position20.getRent() * 2);
                monopoly3Creado = true;
            }
        }

        // Monopolio 4
        Position position25 = this.positionControl.getPositionMap().get(26);
        Position position26 = this.positionControl.getPositionMap().get(25);
        Position position28 = this.positionControl.getPositionMap().get(28);

        if (jugadorActual == position25.getOwnedBy() && jugadorActual == position26.getOwnedBy() && jugadorActual == position28.getOwnedBy()) {
            if (!monopoly4Creado) {
                String nombre = (jugadorActual == 1) ? lblName1.getText() : lblName2.getText();
                String mensajeTexto = "! " + nombre + " ha conseguido un Monopolio!";
                mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);

                position25.setRent(position25.getRent() * 2);
                position26.setRent(position26.getRent() * 2);
                position28.setRent(position28.getRent() * 2);
                monopoly4Creado = true;
            }
        }

        // Monopolio 5
        Position position2 = this.positionControl.getPositionMap().get(2);
        Position position18 = this.positionControl.getPositionMap().get(18);

        if (jugadorActual == position2.getOwnedBy() && jugadorActual == position18.getOwnedBy()) {
            if (!monopoly5Creado) {
                String nombre = (jugadorActual == 1) ? lblName1.getText() : lblName2.getText();
                String mensajeTexto = "! " + nombre + " ha conseguido un Monopolio!";
                mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);
                valorUtilidades = 20;

                monopoly5Creado = true;
            }
        }

        // Monopolio 6
        Position position5 = this.positionControl.getPositionMap().get(5);
        Position position11 = this.positionControl.getPositionMap().get(11);
        Position position22 = this.positionControl.getPositionMap().get(22);
        Position position30 = this.positionControl.getPositionMap().get(30);

        if (jugadorActual == position5.getOwnedBy() && jugadorActual == position11.getOwnedBy() && jugadorActual == position22.getOwnedBy() && jugadorActual == position30.getOwnedBy()) {
            if (!monopoly6Creado) {
                String nombre = (jugadorActual == 1) ? lblName1.getText() : lblName2.getText();
                String mensajeTexto = "! " + nombre + " ha conseguido un Monopolio!";
                mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);
                position5.setRent(450);
                position11.setRent(450);
                position22.setRent(450);
                position30.setRent(450);
                monopoly6Creado = true;
            }
        }

        // Trenes
        if (jugadorActual == position11.getOwnedBy() && jugadorActual == position22.getOwnedBy() && jugadorActual == position30.getOwnedBy()) {
            position30.setRent(315);
            position11.setRent(315);
            position22.setRent(315);
        } else {
            if (jugadorActual == position5.getOwnedBy()) {
                if (jugadorActual == position11.getOwnedBy()) {
                    position5.setRent(315);
                    position11.setRent(315);
                } else if (jugadorActual == position22.getOwnedBy()) {
                    position5.setRent(315);
                    position22.setRent(315);
                } else if (jugadorActual == position30.getOwnedBy()) {
                    position5.setRent(315);
                    position30.setRent(315);
                }
            }
            if (jugadorActual == position11.getOwnedBy() && jugadorActual == position22.getOwnedBy()) {
                position11.setRent(206);
                position22.setRent(206);
            } else if (jugadorActual == position11.getOwnedBy() && jugadorActual == position30.getOwnedBy()) {
                position11.setRent(206);
                position30.setRent(206);
            } else if (jugadorActual == position22.getOwnedBy() && jugadorActual == position30.getOwnedBy()) {
                position22.setRent(206);
                position30.setRent(206);
            }
        }
    }

    private int rentaAguaOLuz() {
        lblresul.setText(null);
        gridPaneTablero.getChildren().remove(carta);
        int dado1 = lanzarDado();
        int dado2 = lanzarDado();
        int total = dado1 + dado2;

        mostrarImagenDado(dado1, imgDado1);
        mostrarImagenDado(dado2, imgDado2);
        lblresul.setText(String.valueOf(total));
        return total;
    }

    void limpiarCarta() {
        if (valTotal == 0 || valTotal == 24 || valTotal == 16 || valTotal == 8 || valTotal == 9 || valTotal == 23) {
            gridPaneTablero.getChildren().remove(carta);
        }
    }

    void construirCasa() {
        int maximoCasas = 4;
        Position position = this.positionControl.getPositionMap().get(valTotal);
        Mensaje mensaje = new Mensaje();

        if (jugadorActual == position.getOwnedBy()) {
            if (position.getNumHouse() < maximoCasas) {

                if (valTotal == 4 || valTotal == 6 || valTotal == 7 && monopoly1Creado) {
                    int numeroCasas;
                    if (jugadorActual == 1) {
                        cuentaJugador1 -= position.getHousePrice();
                    } else {
                        cuentaJugador2 -= position.getHousePrice();
                    }
                    numeroCasas = position.getNumHouse() + 1;
                    position.setNumHouse(numeroCasas);
                    double aumentoRenta = 40 * position.getNumHouse();
                    aumentoRenta += position.getRent();
                    position.setRent(aumentoRenta);
                    String mensajeTexto = "¡Felicidades ha construido su casa número " + numeroCasas + " !";
                    mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);

                }

                if (valTotal == 12 || valTotal == 14 || valTotal == 15 && monopoly2Creado) {
                    int numeroCasas;
                    if (jugadorActual == 1) {
                        cuentaJugador1 -= position.getHousePrice();
                    } else {
                        cuentaJugador2 -= position.getHousePrice();
                    }
                    numeroCasas = position.getNumHouse() + 1;
                    position.setNumHouse(numeroCasas);
                    double aumentoRenta = 40 * position.getNumHouse();
                    aumentoRenta += position.getRent();
                    position.setRent(aumentoRenta);
                    String mensajeTexto = "¡Felicidades ha construido su casa número " + numeroCasas + " !";
                    mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);

                }

                if (valTotal == 17 || valTotal == 19 || valTotal == 20 && monopoly3Creado) {
                    int numeroCasas;
                    if (jugadorActual == 1) {
                        cuentaJugador1 -= position.getHousePrice();
                    } else {
                        cuentaJugador2 -= position.getHousePrice();
                    }
                    numeroCasas = position.getNumHouse() + 1;
                    position.setNumHouse(numeroCasas);
                    double aumentoRenta = 40 * position.getNumHouse();
                    aumentoRenta += position.getRent();
                    position.setRent(aumentoRenta);
                    String mensajeTexto = "¡Felicidades ha construido su casa número " + numeroCasas + " !";
                    mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);

                }

                if (valTotal == 26 || valTotal == 25 || valTotal == 28 && monopoly4Creado) {
                    int numeroCasas;
                    if (jugadorActual == 1) {
                        cuentaJugador1 -= position.getHousePrice();
                    } else {
                        cuentaJugador2 -= position.getHousePrice();
                    }
                    numeroCasas = position.getNumHouse() + 1;
                    position.setNumHouse(numeroCasas);
                    double aumentoRenta = 40 * position.getNumHouse();
                    aumentoRenta += position.getRent();
                    position.setRent(aumentoRenta);
                    String mensajeTexto = "¡Felicidades ha construido su casa número " + numeroCasas + " !";
                    mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);

                }
            }

        } else {
            String mensajeTexto = "¡No eres dueño de esta propiedad!";
            mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);
        }
    }

    void construirHotel() {
        Position position = this.positionControl.getPositionMap().get(valTotal);
        Mensaje mensaje = new Mensaje();
        if (position.getNumHouse() == 4 && position.getNumHotel() == 0) {
            double hotelPrecio = position.getHotelPrice();
            if (jugadorActual == 1) {
                cuentaJugador1 -= hotelPrecio;
            } else {
                cuentaJugador2 -= hotelPrecio;
            }
            double aumentoRenta = 100;
            aumentoRenta += position.getRent();
            position.setRent(aumentoRenta);
            String mensajeTexto = "¡Felicidades ha construido su Hotel!";
            mensaje.showConfirmation("Confirmación", gridPaneTablero.getScene().getWindow(), mensajeTexto);

        }

    }

    @FXML
    private void onActionBtnConstruir(ActionEvent event) {
        construirHotel();
        construirCasa();

    }

   private void creaListaPropiedadesLibres() {

        List<String> propiedadesLibres = new ArrayList<>();
        propiedadesLibres.add("Agua");
        propiedadesLibres.add("Avenida Lopez");
        propiedadesLibres.add("Tren Sur");
        propiedadesLibres.add("Avenida Toros");
        propiedadesLibres.add("Avenida Camaano");
        propiedadesLibres.add("Carcel pos");
        propiedadesLibres.add("Tren Oeste");
        propiedadesLibres.add("Zona Franca");
        propiedadesLibres.add("Finca Miramar");
        propiedadesLibres.add("Mirador");
        propiedadesLibres.add("Avenida Perez");
        propiedadesLibres.add("Luz");
        propiedadesLibres.add("Avenida Central");
        propiedadesLibres.add("Heredia Media Calle");
        propiedadesLibres.add("Tren Norte");
        propiedadesLibres.add("Lagunilla Escuela");
        propiedadesLibres.add("Calle Los Perdidos");
        propiedadesLibres.add("Calle Soledad");
        propiedadesLibres.add("Tren Este");

        // Guardar la lista en AppContext
        AppContext.getInstance().set("propiedadesLibres", propiedadesLibres);
    }

    private void creaListaPropiedadesCompradas() {
        List<String> propiedadesOcupadas = new ArrayList<>();

        AppContext.getInstance().set("propiedadesOcupadas", propiedadesOcupadas);
    }
    @FXML
    void onActionBtnGuardar(ActionEvent event) {
        guardarPartida();
           
    }
    void guardarPartida(){
        GameService gameService = new GameService();
        GameDto gameDto = new GameDto();
        gameDto.setFecha(LocalDate.now());
        gameDto.setNomJugador1(lblName1.getText());
        gameDto.setNomJugador2(lblName2.getText());
        gameDto.setCuentaJugador1(cuentaJugador1);
        gameDto.setCuentaJugador2(cuentaJugador2);
        gameDto.setPosiFicha1(sumaTotal1);
        gameDto.setPosiFicha2(sumaTotal2);
         Respuesta respuesta = gameService.guardarPartida(gameDto);
      Long gameId = ((GameDto) respuesta.getResultado("gameDto")).getId();
       // guardar(gameService, gameId);
    }
 
public void guardar(GameService gameService, Long gameId) {
    Game game = gameService.obtenerJuegoPorId(gameId);
    boolean propiedadesGuardadas = false;

    if (game != null) {
        int[] positionIndices = {2, 4, 5, 6, 7, 11, 12, 14, 15, 17, 18, 19, 20, 22, 25, 26, 28, 30};
        PropiedadService propiedadService = new PropiedadService();

        for (int positionIndex : positionIndices) {
            Position position = this.positionControl.getPositionMap().get(positionIndex);

            if (position.getOwnedBy() != 0) {
                PropiedadDto propiedadDto = new PropiedadDto();
                propiedadDto.setPropiId(Long.valueOf(position.getNumPosition()));
                propiedadDto.setPropiPropietario(position.getOwnedBy());
                propiedadDto.setPropiAlquiler(position.getRent());
             propiedadDto.setGameId(game);

                propiedadService.guardarPropiedad(propiedadDto);
                propiedadesGuardadas = true;
            }
        }
    }

    if (!propiedadesGuardadas) {
        System.out.println("No se guardaron propiedades");
    }
}
}
