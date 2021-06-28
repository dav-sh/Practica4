package src.windows;

import javax.swing.*;

import src.panels.PanelButton;
import src.panels.PanelCells;

public class Game extends JFrame{
    private int[] players_Id; //here save id players in game
    public Game(){

        createJFGame();
    }

    public void createJFGame(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //not visible
        setTitle("Snakes and Ladders"); //title of game
        setBounds(500, 200, 700, 550); //size and position of JFrame
        getContentPane().add(new PanelCells(),"Center"); //add PanelCells
        getContentPane().add(new PanelButton(),"West"); //add PanelButton
        setVisible(true);
    }



    
    
}
