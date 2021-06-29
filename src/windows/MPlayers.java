package src.windows;

import java.util.*;

import javax.swing.JFrame;
import src.panels.PaneladdPlayer;
import src.player.Player;


public class MPlayers extends JFrame{
    
    PaneladdPlayer p = new PaneladdPlayer();
    Player [] players= null;

    
    //ArrayList<Player> players = new ArrayList<Player>();
    public MPlayers(){
        
    }


    public void seePlayers(){
        players = p.getPlayers();
        for(int i = 0; i<players.length; i++){
            System.out.println(players[i].getName()+ " " + players[i].getId());
        }


        // for(int i=0; i<players.size();i++){
        //     System.out.println(players.get(i).getId() + " " + players.get(i).getName()+ " " + players.get(i).getLastName());
        // }
    }
    public void addPlayer(){
        JFrame jadd = new JFrame();
        jadd.setTitle("Add New Player"); //title of game
        jadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jadd.setBounds(500, 200, 700, 550); //size and position of JFrame
        jadd.getContentPane().add(p,"Center");
        jadd.setVisible(true);
        
        
        
    }
    public Player[] getPlayer(){
        return players;
    }
}
