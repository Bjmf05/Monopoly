/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.model;

/**
 *
 * @author Servidor
 */
import cr.ac.una.monopoly.util.AppContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Position {

    HashMap<Integer, Position> positionMap = new HashMap<>();
    private int row;
    private int column;
    private double price;
    private int ownedBy;
    private String name;
    private String characteristic;
    private double rent;
    private double mortgage;
    private int numHouse;
    private int numHotel;
    private double housePrice;
    private double hotelPrice;
    private int numPosition;

    public int getNumPosition() {
        return numPosition;
    }

    public void setNumPosition(int numPosition) {
        this.numPosition = numPosition;
    }

    public Position() {
        initPositionMap();
    }

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.ownedBy = 0;

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public int getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(int player) {
        this.ownedBy = player;
    }

    public boolean isOwned() {
        return ownedBy != 0;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getMortgage() {
        return mortgage;
    }

    public void setMortgage(double mortgage) {
        this.mortgage = mortgage;
    }

    public int getNumHouse() {
        return numHouse;
    }

    public void setNumHouse(int numHouse) {
        this.numHouse = numHouse;
    }

    public int getNumHotel() {
        return numHotel;
    }

    public void setNumHotel(int numHotel) {
        this.numHotel = numHotel;
    }

    public double getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(double housePrice) {
        this.housePrice = housePrice;
    }

    public double getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(double hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public Map<Integer, Position> getPositionMap() {
        return positionMap;
    }

// Método de inicialización para crear el mapeo de posiciones
    public void initPositionMap() {

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

        setPropertyInfo();
        setPositionName();
        setPositionCharacteristic();
        setPositionRent();
        setPositionMortgage();
        numberPosition();
        fillHousePrice();
        fillHotelPrice();
        fillNumHotel();
        fillNumHouse();
       /// creaListaPropiedadesLibres();
      ///  creaListaPropiedadesCompradas();
    }

    public void setPositionCharacteristic() {
        positionMap.get(0).setCharacteristic("Go");
        positionMap.get(1).setCharacteristic("Suerte");
        positionMap.get(2).setCharacteristic("Utilidad");
        positionMap.get(3).setCharacteristic("Suerte");
        positionMap.get(4).setCharacteristic("Celeste");
        positionMap.get(5).setCharacteristic("Tren");
        positionMap.get(6).setCharacteristic("Celeste");
        positionMap.get(7).setCharacteristic("Celeste");
        positionMap.get(8).setCharacteristic("Carcel");
        positionMap.get(9).setCharacteristic("Impuesto");
        positionMap.get(10).setCharacteristic("Suerte");
        positionMap.get(11).setCharacteristic("Tren");
        positionMap.get(12).setCharacteristic("Amarillo");
        positionMap.get(13).setCharacteristic("Suerte");
        positionMap.get(14).setCharacteristic("Amarillo");
        positionMap.get(15).setCharacteristic("Amarillo");
        positionMap.get(16).setCharacteristic("Libre");
        positionMap.get(17).setCharacteristic("Rojo");
        positionMap.get(18).setCharacteristic("Utilidad");
        positionMap.get(19).setCharacteristic("Rojo");
        positionMap.get(20).setCharacteristic("Rojo");
        positionMap.get(21).setCharacteristic("Suerte");
        positionMap.get(22).setCharacteristic("Tren");
        positionMap.get(23).setCharacteristic("Impuesto");
        positionMap.get(24).setCharacteristic("Ve a carcel");
        positionMap.get(25).setCharacteristic("Verde");
        positionMap.get(26).setCharacteristic("Verde");
        positionMap.get(27).setCharacteristic("Suerte");
        positionMap.get(28).setCharacteristic("Verde");
        positionMap.get(29).setCharacteristic("Suerte");
        positionMap.get(30).setCharacteristic("Tren");
        positionMap.get(31).setCharacteristic("Suerte");

    }

    public void numberPosition() {
        positionMap.get(2).setNumPosition(2);
        positionMap.get(4).setNumPosition(4);
        positionMap.get(5).setNumPosition(5);
        positionMap.get(6).setNumPosition(6);
        positionMap.get(7).setNumPosition(7);
        positionMap.get(11).setNumPosition(11);
        positionMap.get(12).setNumPosition(12);
        positionMap.get(14).setNumPosition(14);
        positionMap.get(15).setNumPosition(15);
        positionMap.get(17).setNumPosition(17);
        positionMap.get(18).setNumPosition(18);
        positionMap.get(19).setNumPosition(19);
        positionMap.get(20).setNumPosition(20);
        positionMap.get(22).setNumPosition(22);
        positionMap.get(25).setNumPosition(25);
        positionMap.get(26).setNumPosition(26);
        positionMap.get(28).setNumPosition(28);
        positionMap.get(30).setNumPosition(200);

    }

    public void setPositionName() {
        positionMap.get(0).setName("Go");
        positionMap.get(1).setName("Suerte");
        positionMap.get(2).setName("Agua");
        positionMap.get(3).setName("Suerte");
        positionMap.get(4).setName("Avenida Lopez");
        positionMap.get(5).setName("Tren Sur");
        positionMap.get(6).setName("Avenida Toros");
        positionMap.get(7).setName("Avenida Camaano");
        positionMap.get(8).setName("Carcel pos");
        positionMap.get(9).setName("Impuesto");
        positionMap.get(10).setName("Suerte");
        positionMap.get(11).setName("Tren Oeste");
        positionMap.get(12).setName("Zona Franca");
        positionMap.get(13).setName("Suerte");
        positionMap.get(14).setName("Finca Miramar");
        positionMap.get(15).setName("Mirador");
        positionMap.get(16).setName("Libre");
        positionMap.get(17).setName("Avenida Perez");
        positionMap.get(18).setName("Luz");
        positionMap.get(19).setName("Avenida Central");
        positionMap.get(20).setName("Heredia Media Calle");
        positionMap.get(21).setName("Suerte");
        positionMap.get(22).setName("Tren Norte");
        positionMap.get(23).setName("Impuesto");
        positionMap.get(24).setName("Ve a carcel");
        positionMap.get(25).setName("Lagunilla Escuela");
        positionMap.get(26).setName("Calle Los Perdidos");
        positionMap.get(27).setName("Suerte");
        positionMap.get(28).setName("Calle Soledad");
        positionMap.get(29).setName("Suerte");
        positionMap.get(30).setName("Tren Este");
        positionMap.get(31).setName("Suerte");

    }

    private void setPropertyInfo() {
        positionMap.get(2).setPrice(230);
        positionMap.get(4).setPrice(230);
        positionMap.get(5).setPrice(200);
        positionMap.get(6).setPrice(100);
        positionMap.get(7).setPrice(540);
        positionMap.get(11).setPrice(200);
        positionMap.get(12).setPrice(285);
        positionMap.get(14).setPrice(300);
        positionMap.get(15).setPrice(300);
        positionMap.get(17).setPrice(200);
        positionMap.get(18).setPrice(225);
        positionMap.get(19).setPrice(250);
        positionMap.get(20).setPrice(450);
        positionMap.get(22).setPrice(200);
        positionMap.get(25).setPrice(400);
        positionMap.get(26).setPrice(230);
        positionMap.get(28).setPrice(280);
        positionMap.get(30).setPrice(200);

        positionMap.get(0).setPrice(0); // Suerte
        positionMap.get(1).setPrice(0); // Suerte
        positionMap.get(3).setPrice(0); // Suerte
        positionMap.get(9).setPrice(0); // Impuesto
        positionMap.get(10).setPrice(0); // Suerte
        positionMap.get(13).setPrice(0); // Suerte
        positionMap.get(16).setPrice(0); // Libre
        positionMap.get(21).setPrice(0); // Suerte
        positionMap.get(23).setPrice(0); // Impuesto
        positionMap.get(24).setPrice(0); // Ve a cárcel
        positionMap.get(27).setPrice(0); // Suerte
        positionMap.get(29).setPrice(0); // Suerte
        positionMap.get(31).setPrice(0); // Suerte
    }

    private void setPositionMortgage() {
        positionMap.get(2).setMortgage(250);
        positionMap.get(4).setMortgage(180);
        positionMap.get(5).setMortgage(250);
        positionMap.get(6).setMortgage(100);
        positionMap.get(7).setMortgage(500);
        positionMap.get(11).setMortgage(250);
        positionMap.get(12).setMortgage(200);
        positionMap.get(14).setMortgage(230);
        positionMap.get(15).setMortgage(230);
        positionMap.get(17).setMortgage(180);
        positionMap.get(18).setMortgage(250);
        positionMap.get(19).setMortgage(200);
        positionMap.get(20).setMortgage(380);
        positionMap.get(22).setMortgage(250);
        positionMap.get(25).setMortgage(350);
        positionMap.get(26).setMortgage(180);
        positionMap.get(28).setMortgage(150);
        positionMap.get(30).setMortgage(250);
    }

    private void setPositionRent() {
        positionMap.get(2).setRent(250);//agua
        positionMap.get(4).setRent(50);
        positionMap.get(5).setRent(100);//tren
        positionMap.get(6).setRent(30);
        positionMap.get(7).setRent(90);
        positionMap.get(9).setRent(190);//impuesto
        positionMap.get(11).setRent(100);//tren
        positionMap.get(12).setRent(60);
        positionMap.get(14).setRent(65);
        positionMap.get(15).setRent(65);
        positionMap.get(17).setRent(45);
        positionMap.get(18).setRent(250);//luz
        positionMap.get(19).setRent(55);
        positionMap.get(20).setRent(85);
        positionMap.get(22).setRent(100);//tren
        positionMap.get(23).setRent(160);//impuesto
        positionMap.get(25).setRent(75);
        positionMap.get(26).setRent(50);
        positionMap.get(28).setRent(45);
        positionMap.get(30).setRent(100);//tren
    }

    public void fillNumHouse() {
        positionMap.get(4).setNumHouse(0);
        positionMap.get(6).setNumHouse(0);
        positionMap.get(7).setNumHouse(0);
        positionMap.get(12).setNumHouse(0);
        positionMap.get(14).setNumHouse(0);
        positionMap.get(15).setNumHouse(0);
        positionMap.get(17).setNumHouse(0);
        positionMap.get(19).setNumHouse(0);
        positionMap.get(20).setNumHouse(0);
        positionMap.get(25).setNumHouse(0);
        positionMap.get(26).setNumHouse(0);
        positionMap.get(28).setNumHouse(0);
    }

    public void fillNumHotel() {
        positionMap.get(4).setNumHotel(0);
        positionMap.get(6).setNumHotel(0);
        positionMap.get(7).setNumHotel(0);
        positionMap.get(12).setNumHotel(0);
        positionMap.get(14).setNumHotel(0);
        positionMap.get(15).setNumHotel(0);
        positionMap.get(17).setNumHotel(0);
        positionMap.get(19).setNumHotel(0);
        positionMap.get(20).setNumHotel(0);
        positionMap.get(25).setNumHotel(0);
        positionMap.get(26).setNumHotel(0);
        positionMap.get(28).setNumHotel(0);
    }

    public void fillHousePrice() {
        positionMap.get(4).setHousePrice(80);
        positionMap.get(6).setHousePrice(80);
        positionMap.get(7).setHousePrice(150);
        positionMap.get(12).setHousePrice(90);
        positionMap.get(14).setHousePrice(90);
        positionMap.get(15).setHousePrice(90);
        positionMap.get(17).setHousePrice(80);
        positionMap.get(19).setHousePrice(70);
        positionMap.get(20).setHousePrice(150);
        positionMap.get(25).setHousePrice(120);
        positionMap.get(26).setHousePrice(100);
        positionMap.get(28).setHousePrice(100);
    }

    public void fillHotelPrice() {
        positionMap.get(4).setHotelPrice(350);
        positionMap.get(6).setHotelPrice(320);
        positionMap.get(7).setHotelPrice(500);
        positionMap.get(12).setHotelPrice(300);
        positionMap.get(14).setHotelPrice(300);
        positionMap.get(15).setHotelPrice(300);
        positionMap.get(17).setHotelPrice(320);
        positionMap.get(19).setHotelPrice(350);
        positionMap.get(20).setHotelPrice(450);
        positionMap.get(25).setHotelPrice(350);
        positionMap.get(26).setHotelPrice(250);
        positionMap.get(28).setHotelPrice(250);
    }

    public void showPosition(ImageView imageView, int posicion) {
        Image agua = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Agua.png"));
        Image luz = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Luz.png"));
        Image avenidaCamaano = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Avenida Camaano.png"));
        Image avenidaLopez = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Avenida Lopez.png"));
        Image avenidaToros = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Avenida Toros.png"));
        Image fincaMiramar = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Finca Miramar.png"));
        Image avenidaPerez = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Avenida Central.png"));
        Image avenidaCentral = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Avenida Perez.png"));
        Image heredia = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Heredia Media Calle.png"));
        Image mirador = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Mirador.png"));
        Image zonaFranca = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Zona Franca.png"));
        Image callePerdidos = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Calle Los Perdidos.png"));
        Image calleSoledad = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Calle Soledad.png"));
        Image lagunillaEscuela = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Lagunilla Escuela.png"));
        Image trenSur = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Tren Sur.png"));
        Image trenNorte = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Tren Norte.png"));
        Image trenEste = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Tren Este.png"));
        Image trenOeste = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/propiedades/Tren Oeste.png"));

        switch (posicion) {
            case 2:
                imageView.setImage(agua);
                break;
            case 4:
                imageView.setImage(avenidaLopez);
                break;
            case 5:
                imageView.setImage(trenSur);
                break;
            case 6:
                imageView.setImage(avenidaToros);
                break;
            case 7:
                imageView.setImage(avenidaCamaano);
                break;
            case 11:
                imageView.setImage(trenOeste);
                break;
            case 12:
                imageView.setImage(zonaFranca);
                break;
            case 14:
                imageView.setImage(fincaMiramar);
                break;
            case 15:
                imageView.setImage(mirador);
                break;
            case 17:
                imageView.setImage(avenidaCentral);
                break;
            case 18:
                imageView.setImage(luz);
                break;
            case 19:
                imageView.setImage(avenidaPerez);
                break;
            case 20:
                imageView.setImage(heredia);
                break;
            case 22:
                imageView.setImage(trenNorte);
                break;
            case 25:
                imageView.setImage(lagunillaEscuela);
                break;
            case 26:
                imageView.setImage(callePerdidos);
                break;
            case 28:
                imageView.setImage(calleSoledad);
                break;
            case 30:
                imageView.setImage(trenEste);
                break;
            default:
                break;
        }
    }
    
   
}
