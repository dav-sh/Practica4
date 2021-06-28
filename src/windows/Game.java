package src.windows;

import javax.swing.*;

import src.panels.PanelGDice;
import src.panels.PanelGCells;
import java.util.*;

public class Game extends JFrame{
    private int[] players_Id; //here save id players in game
    PanelGDice diceP; //
    PanelGCells cellsP; //
    Scanner scanner = new Scanner(System.in);
    public Game(){
        start();
        createJFGame();
    }

    public void createJFGame(){
        cellsP = new PanelGCells();
        diceP = new PanelGDice(cellsP);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //not visible
        this.getContentPane().add(diceP,"West");
        this.getContentPane().add(cellsP,"Center");

        setTitle("Snakes and Ladders"); //title of game
        setBounds(500, 200, 700, 550); //size and position of JFrame
        //getContentPane().add(new PanelGCells(),"Center"); //add PanelCells
        //getContentPane().add(new PanelGDice(),"West"); //add PanelButton
        setVisible(true);
    }
    public int[] start(){
        System.out.println("Ingresa la cantidad de jugadores...");
        int numP = scanner.nextInt();  
        players_Id = new int[numP];
        for(int i=0; i<numP;i++){
            System.out.println("P: "+i);
            int tmp = scanner.nextInt();
            players_Id[i] = tmp;

        }
        return players_Id;
    }

    
    
}
