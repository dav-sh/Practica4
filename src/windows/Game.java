package src.windows;

import javax.swing.*;

import src.panels.*;
import src.player.Player;

import java.util.*;

public class Game extends JFrame{
    private int[] players_Id; //here save id players in game
    private int[] availableIds; //
    PanelGDice diceP; //
    PanelGCells cellsP; //
    Scanner scanner = new Scanner(System.in);
    Player[] players;
    public Game(Player[] players){
        this.players = players;
        start();
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
        System.out.println(players.length);
        try{ 

            if(players.length>0){ //verify players
                availableIds = new int[players.length];
                //players[0].setName("Cambie name"); //solo es test
                int numberOfPlayers=0;
                System.out.println("Si existen Players");  
                System.out.println("Ingresa la cantidad de jugadores...");
                JOptionPane.showMessageDialog(null, "Number of players available: " + players.length);
                try {
                    numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog( "Enter the number of players .. (A: "+players.length+")"));
                    
                } catch (Exception e) {
                    //TODO: handle exception
                    JOptionPane.showMessageDialog(null, "Incorrect Data");
                }
                if(numberOfPlayers<=0 || numberOfPlayers>players.length){
                    JOptionPane.showMessageDialog(null, "number of players not valid");
    
                }else{
                    players_Id = new int[numberOfPlayers];
                    int idtmp;
                    for(int i=0; i<players_Id.length; i++){
                        try {
                            idtmp = Integer.parseInt(JOptionPane.showInputDialog( "Enter Player # "+(i+1)));
                            for(int j = 0; j<players.length; j++){ //aqui me quede, tratando de hacer un metodo para validar el id
                                if(players[j].getId()==idtmp){
                                    players_Id[i] = idtmp;
                                    System.out.println("agregado: "+idtmp);

                                }else{
                                    System.out.println("No estaba");
                                }
                            }
                            
                        } catch (Exception e) {
                            //TODO: handle exception
                            JOptionPane.showMessageDialog(null, "Incorrect Id... Try again");
                            JOptionPane.showMessageDialog(null, "Return Main Menu ....");
                            break;
                        }
                    }
                    System.out.println("Finalizado ... creando Game");
                    createJFGame();

                }

            }
            else{
                JOptionPane.showMessageDialog(null, "Please add players");

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please add more players");

        }


    }


    
}
