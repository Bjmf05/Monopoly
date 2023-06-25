/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.model;

/**
 *
 * @author Servidor
 */
import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Position {

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

    public Position() {
    }

    public int getNumPosition() {
        return numPosition;
    }

    public void setNumPosition(int numPosition) {
        this.numPosition = numPosition;
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

// Método de inicialización para crear el mapeo de posiciones
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
