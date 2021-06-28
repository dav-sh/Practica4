package src.window;

import javax.swing.*;
import java.awt.*;
import src.cell.Cell; 
import java.util.*;

public class PanelCell extends JPanel {
    JLabel label;
    ArrayList<Cell> cells = new ArrayList<Cell>();
    Random random = new Random();
    Cell[][]celdas= new Cell[3][2];
    public PanelCell(){
        setSize(690,550);
        fillArray();
        celdas[2][1].setBackground(Color.RED);
        //cells.get(3).setBackground(Color.RED); //prueba
    }
    public int generaRandom() {
        return random.nextInt(3);
    }

    /* fill the panel with format*/
    /*
    public void fillArray(){
        setLayout(new GridLayout(3,2));
        for(int i=0;i<12;i++){
            cells.add(new Cell(" "+i)); //add cell to array
            this.add(cells.get(i)); //add element of the array
        }
    }*/
    public void fillArray(){
        setLayout(new GridLayout(3,2));
        // celdas = new Cell[3][2];
        for(int i=0;i<3;i++){ //rows
            for(int j=0;j<2;j++){ //columns
                celdas[i][j] = new Cell(" "+i+","+j); //add
                this.add(celdas[i][j]);
            }
        }

    }

}
