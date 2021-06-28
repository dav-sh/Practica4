package src.windows;

import javax.swing.*;

import src.panels.PanelGDice;
import src.panels.PanelGCells;

public class Game extends JFrame{
    private int[] players_Id; //here save id players in game
    public Game(){

        createJFGame();
    }

    public void createJFGame(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //not visible
        setTitle("Snakes and Ladders"); //title of game
        setBounds(500, 200, 700, 550); //size and position of JFrame
        getContentPane().add(new PanelGCells(),"Center"); //add PanelCells
        getContentPane().add(new PanelGDice(),"West"); //add PanelButton
        setVisible(true);
    }



    
    
}
