package src.windows;

import java.util.*;
import src.player.Player;

public class MPlayers {
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
        String name = " "+count_Id;
        String lastName = " ";
        count_Id++;
        players.add(new Player(name, lastName, count_Id));
    }
}
