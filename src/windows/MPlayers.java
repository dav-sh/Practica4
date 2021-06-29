package src.windows;

import java.awt.*;
import javax.swing.*;
import src.panels.PaneladdPlayer;
import src.player.Player;


public class MPlayers extends JFrame{
    
    PaneladdPlayer p = new PaneladdPlayer();
    Player [] players= null;

    
    //ArrayList<Player> players = new ArrayList<Player>();
    public MPlayers(){
        
    }


    public void seePlayers(){
        DefaultListModel<String> listP = new DefaultListModel<>();
        players = p.getPlayers();
        String str;
        if(players.length>0){
            str = String.format("%-2s   %-30s    %-30s","id","name","Last Name");
            listP.addElement(str);
            //listP.addElement("id    -      name       -       lastName      ");

            for(int i = 0; i<players.length; i++){
                System.out.println(players[i].getName()+ " " + players[i].getId());
                str = String.format("%-2d    %-30s    %-30s",players[i].getId(),players[i].getName(),players[i].getLastName());
                listP.addElement(str);
                //listP.addElement(players[i].getId()+ ".   " + players[i].getName()+ "   " + players[i].getLastName());
            }
            JList<String> list = new JList<>(listP);
            JFrame jadd = new JFrame();
            jadd.setBackground(new Color(0,0,20));
            jadd.setTitle("See Players"); //title of game
            jadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jadd.setBounds(500, 200, 300, 550); //size and position of JFrame
            jadd.add(list,"Center");
            jadd.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null, "There are no players");
        }


        // for(int i=0; i<players.size();i++){
        //     System.out.println(players.get(i).getId() + " " + players.get(i).getName()+ " " + players.get(i).getLastName());
        // }
    }
    public void addPlayer(){
        JFrame jadd = new JFrame();
        jadd.setTitle("Add New Player"); //title of game
        jadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jadd.setBounds(500, 200, 350, 150); //size and position of JFrame
        jadd.getContentPane().add(p,"Center");
        jadd.setVisible(true);
        
        
        
    }
    public Player[] getPlayer(){
        return players;
    }
    public void statistics(){
        DefaultListModel<String> listP = new DefaultListModel<>();
        String str;
        players = p.getPlayers();
        if(players.length>0){
            str = String.format("%-2s   %-30s    %-30s   %-5s   %-5s   %-5s" ,"id","name","Last Name","Matches","Wins","losses");
            listP.addElement(str);
            //listP.addElement("id          name          lastName         matches            wins            losses");
            for(int i = 0; i<players.length; i++){
                System.out.println(players[i].getName()+ " " + players[i].getId());
                str = String.format("%-2d   %-30s    %-30s   %-5d   %-5d   %-5d",players[i].getId(),players[i].getName(),players[i].getLastName(),players[i].getJugadas(),players[i].getWins(),players[i].getLosses());
                //listP.addElement(players[i].getId()+ ".   " + players[i].getName()+ "   " + players[i].getLastName()+ " "+ players[i].getJugadas() + " "+ players[i].getWins()+ " "+players[i].getLosses());
                listP.addElement(str);
                
            }

            JList<String> list = new JList<>(listP);
            JFrame jadd = new JFrame();
            jadd.setBackground(new Color(0,0,20));
            jadd.setTitle("See Players"); //title of game
            jadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jadd.setBounds(500, 200, 500, 550); //size and position of JFrame
            jadd.add(list,"Center");
            jadd.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null, "There are no players");
        }


        // for(int i=0; i<players.size();i++){
        //     System.out.println(players.get(i).getId() + " " + players.get(i).getName()+ " " + players.get(i).getLastName());
        // }
    }



}
