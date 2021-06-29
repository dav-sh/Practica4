package src.windows;

import javax.swing.*;

import src.panels.*;
import src.player.Player;

import java.util.*;

public class Game extends JFrame{
    private int[] players_Id; //here save id players in game
    PanelGDice diceP; //
    PanelGCells cellsP; //
    Scanner scanner = new Scanner(System.in);
    Player[] players;
    public Game(Player[] players){
        this.players = players;
        start();
        createJFGame();
    }

    public void createJFGame(){
        cellsP = new PanelGCells();
        diceP = new PanelGDice(cellsP,players_Id);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //not visible
        this.getContentPane().add(diceP,"West");
        this.getContentPane().add(cellsP,"Center");

        setTitle("Snakes and Ladders"); //title of game
        setBounds(500, 200, 700, 550); //size and position of JFrame
        //getContentPane().add(new PanelGCells(),"Center"); //add PanelCells
        //getContentPane().add(new PanelGDice(),"West"); //add PanelButton
        setVisible(true);
    }
    public void start(){
        if(verificationPlayers(players)){
            System.out.println("Si existen "+""+"Players");    
        }else{
            System.out.println("No existen");
        }
        System.out.println("Ingresa la cantidad de jugadores...");
        int numP = scanner.nextInt();  
        players_Id = new int[numP];
        for(int i=0; i<numP;i++){
            System.out.println("P: "+i);
            int tmp = scanner.nextInt();
            players_Id[i] = tmp;
        }
        System.out.println("Finalizado ... creando Game");
        //players[0].setName("Cambie name"); si estamos apuntando al mismo espacio en memoria :D

    }

    public boolean verificationPlayers(Player[] players){
        boolean result = false;
        for(int i=0; i<players.length; i++){
            System.out.println("Name: "+ players[i].getName());
            result = true; 
        }
        return result;
    }

    
    
}
