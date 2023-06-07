/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.util;

/**
 *
 * @author Servidor
 */
import java.util.HashMap;
import java.util.Map;

public class Position {
     HashMap<Integer, Position> positionMap = new HashMap<>();
     private int row;
    private int column;
    private int price;
    private int ownedBy;
    private String name;
    private String characteristic;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
}
public void setPositionCharacteristic(){
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
public void setPositionName(){
   positionMap.get(0).setName("Go");
    positionMap.get(1).setName("Suerte");
    positionMap.get(2).setName("Agua");
    positionMap.get(3).setName("Suerte");
    positionMap.get(4).setName("Avenida Lopez");
    positionMap.get(5).setName("Tren");
    positionMap.get(6).setName("Avenida Toros");
    positionMap.get(7).setName("Avenida Camaano");
    positionMap.get(8).setName("Carcel pos");
    positionMap.get(9).setName("Impuesto");
    positionMap.get(10).setName("Suerte");
    positionMap.get(11).setName("Tren");
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
    positionMap.get(22).setName("Tren");
    positionMap.get(23).setName("Impuesto");
    positionMap.get(24).setName("Ve a carcel");
    positionMap.get(25).setName("Lagunilla Escuela");
    positionMap.get(26).setName("Calle Los Perdidos");
    positionMap.get(27).setName("Suerte");
    positionMap.get(28).setName("Calle Soledad");
    positionMap.get(29).setName("Suerte");
    positionMap.get(30).setName("Tren");
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

}
