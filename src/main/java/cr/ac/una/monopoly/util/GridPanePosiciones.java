/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopoly.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.swing.text.Position;

/**
 *
 * @author Servidor
 * */public class GridPanePosiciones {
   private GridPane gridPane;
    private Map<String, Integer> positionMap;


    public GridPanePosiciones(GridPane gridPane) {
         this.gridPane = gridPane;
        positionMap = new HashMap<>();
    }

    public void addPosition(String name, int row, int column) {
        positionMap.put(name, row * gridPane.getRowCount() + column);
    }

   public Node getNode(String name) {
        Integer positionIndex = positionMap.get(name);
        if (positionIndex != null) {
            return gridPane.getChildren().get(positionIndex);
        }
        return null;
    }
    public static class Position {
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
}