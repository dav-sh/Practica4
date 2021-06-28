package src.window;

import javax.swing.*;
import java.awt.*;
import src.cell.Cell; 

public class PanelCell extends JPanel {
    JLabel label;
    int rows = 10;
    int columns = 10;
    Cell[][]celdas= new Cell[rows][columns];
    public PanelCell(){
        setSize(690,550);
        fillArray();
        celdas[2][1].setBackground(Color.RED);
    }
    

    
    public void fillArray(){
        setLayout(new GridLayout(rows,columns));
        for(int i=0;i<rows;i++){ //rows
            for(int j=0;j<columns;j++){ //columns
                celdas[i][j] = new Cell(" "+i+","+j); //add
                this.add(celdas[i][j]);
            }
        }

    }

}
