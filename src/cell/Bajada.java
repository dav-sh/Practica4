package src.cell;
import javax.swing.*;
import java.awt.*;

public class Bajada extends JLabel {
    boolean penitencia;
    public Bajada(String name){
        this.penitencia = false;
        setText(name);
        setHorizontalAlignment(0); 
        setVerticalAlignment(0);
        setBackground(Color.BLUE); //change color of background
        setOpaque(true); //see the background color
        setSize(100, 100); //set dimensions of JLabel
        setForeground(Color.WHITE); //change color of text
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5)); //create a new border and define color and thickness (grosor)
        
    }
    public boolean getPenitencia(){
        return penitencia;
    }

    

    
}
