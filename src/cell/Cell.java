package src.cell;
import javax.swing.*;
import java.awt.*;

public abstract class Cell extends JLabel {

    public Cell(String name, Color color, String pos){
        setText(name+pos);
        setHorizontalAlignment(0); 
        setVerticalAlignment(0);
        setBackground(color); //change color of background
        setOpaque(true); //see the background color
        setSize(100, 100); //set dimensions of JLabel
        setForeground(Color.WHITE); //change color of text
        setBorder(BorderFactory.createLineBorder(new Color(110,119,97), 3)); //create a new border and define color and thickness (grosor)
        
    }

    public abstract String getInfo();
    public abstract int[] getPositions();


    

    
}
