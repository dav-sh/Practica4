package src.window;

import javax.swing.*;
import java.awt.*;
import src.cell.Cell; 
import java.util.*;

public class PanelCell extends JPanel {
    JLabel label;
    Random random = new Random();
    public PanelCell(){
        setSize(690,550);
        fillArray();
    }
    public int generaRandom() {
        return random.nextInt(3);
    }

    /* fill the panel with format*/
    public void fillArray(){
        setLayout(new GridLayout(3,2));
        for(int i=0;i<12;i++){
            this.add(new Cell(" "+i));
        }
    }
}
