package src.player;

import java.io.Serializable;

public class Player implements Serializable{
    private String name;
    private String lastName;
    private int id;
    private int wins;
    private int losses;
    private int jugadas;

    public Player(String name, String lastName, int id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.wins =0;
        this.losses =0;
        this.jugadas =0; 
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getWins(){
        return wins;
    }
    public void setWins(int wins){
        this.wins = wins;
    }
    public int getLosses(){
        return losses;
    }
    public void setLosses(int losses){
        this.losses = losses;
    }
    public int getJugadas(){
        return jugadas;
    }
    public void setJugadas(int jugadas){
        this.jugadas = jugadas;
    }
}