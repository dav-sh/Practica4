package src.cell;
import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {
    public Cell(String name){
        setText(name);
        setHorizontalAlignment(0); 
        setVerticalAlignment(0);
        setBackground(Color.BLUE); //change color of background
        setOpaque(true); //see the background color
        setSize(100, 100);
        setForeground(Color.WHITE); //change color of text
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        //setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
    }
    
}
