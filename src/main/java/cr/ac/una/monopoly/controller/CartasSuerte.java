/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Servidor
 */
public class CartasSuerte {

    public CartasSuerte() {
    }
    public void cartasSuertes(ImageView imageView, int numeroSuerte){
        Image uno = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte1.png"));
        Image dos = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte2.png"));
        Image tres = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte3.png"));
        Image cuatro = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte4.png"));
        Image cinco = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte5.png"));
        Image seis = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte6.png"));
        Image siete = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte7.png"));
        Image ocho = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte8.png"));
        Image nueve = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte9.png"));
        Image diez = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte10.png"));
        Image once = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte11.png"));
        Image doce = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte12.png"));
        Image trece = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte13.png"));
        Image catorce = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte14.png"));
        Image quince = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte15.png"));
        Image dieciseis = new Image(getClass().getResourceAsStream("/cr/ac/una/monopoly/resources/Suerte/Suerte16.png"));
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
    
}
