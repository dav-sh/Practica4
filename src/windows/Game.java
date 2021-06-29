package src.windows;

import javax.swing.*;
import src.panels.*;
import src.player.Player;
import java.util.*;




public class Game extends JFrame{
    private int[] players_Id; //here save id players in game
    PanelGDice diceP; //
    PanelGCells cellsP; //
    //Scanner scanner = new Scanner(System.in);
    Player[] players;



    public Game(Player[] players){
        this.players = players;
        start();
    }

    public void createJFGame(){
        cellsP = new PanelGCells(players_Id);
        diceP = new PanelGDice(cellsP,players_Id);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //not visible
        this.getContentPane().add(diceP,"West");
        this.getContentPane().add(cellsP,"Center");

        setTitle("Snakes and Ladders"); //title of game
        setBounds(500, 200, 700, 550); //size and position of JFrame
        setVisible(true);
    }



    public void start(){
        System.out.println("c_p"+ players.length);
        try{ 

            if(players.length>0){ //verify players
                int numberOfPlayers=0;
                
                //players[0].setName("Cambie name"); //solo es test

                try {
                    numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog( "Enter the number of players (Max: 6).. (A: "+players.length+")"));
                    if(numberOfPlayers>0 && numberOfPlayers<=6 && numberOfPlayers<=players.length){ //only 6 players
                        players_Id = new int[numberOfPlayers]; //inicia el array
                        if(addID(numberOfPlayers)){
                            System.out.println("Estoy bien");
                            createJFGame();
                            System.out.println("se creo");

                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "Number of players not valid");

                    } 
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Number of players not valid, please enter a valid number");

                }
            }else{
                JOptionPane.showMessageDialog(null, "Please add more players");

            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please add more players");

        }     

    }


    
    private boolean idexists(int id){
        boolean op = false;
        for (int i = 0; i < players.length; i++){
            if(players[i].getId()==id){
                op = true;
                break;

            }
        }
        return op;
    }

    public boolean addID(int numberOfPlayers){
        int contador =0;
        while(contador<numberOfPlayers){
            try {
                int idtmp = Integer.parseInt(JOptionPane.showInputDialog( "Enter Player # "+(contador+1)));
                if(idexists(idtmp) && idRepeat(idtmp)){
                    players_Id[contador] = idtmp;
                    System.out.println("Si se agrego");
                    contador++;
                }else{
                    JOptionPane.showMessageDialog(null, "Id Player doesn't exist or Repeated Id");

                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Id not valid");
            }
        }
        return true;
        
    }

    private boolean idRepeat(int idtmp){
        boolean continuear = true;
        for(int i = 0; i<players_Id.length; i++){
            if(players_Id[i]==idtmp){
                continuear = false;
            }
        }
        return continuear;
    }



    
    
}
