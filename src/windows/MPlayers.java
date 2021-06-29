package src.windows;

import java.util.*;

import javax.swing.JFrame;
import src.panels.PaneladdPlayer;
import src.player.Player;


public class MPlayers extends JFrame{
    private int count_Id;
    
    ArrayList<Player> players = new ArrayList<Player>();
    public MPlayers(){

    }


    public void seePlayers(){
        for(int i=0; i<players.size();i++){
            System.out.println(players.get(i));
        }
    }
    public void addPlayer(){
        PaneladdPlayer p = new PaneladdPlayer();
        JFrame jadd = new JFrame();
        jadd.setTitle("Add New Player"); //title of game
        jadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jadd.setBounds(500, 200, 700, 550); //size and position of JFrame
        jadd.getContentPane().add(p,"Center");
        jadd.setVisible(true);
        
        
        
        String name = p.getNames();
        String lastName = p.getLastName();
        count_Id++;
        players.add(new Player(name, lastName, count_Id));
    }
}
