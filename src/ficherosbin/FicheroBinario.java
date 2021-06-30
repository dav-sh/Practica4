package src.ficherosbin;

import java.io.*;

import src.player.Player;


public class FicheroBinario {
    Player[] players;
    public FicheroBinario(Player[] players) {
        this.players = players;

    }

    public void escribirBin(){
        FileOutputStream fileoutput;
        File file; 
        ObjectOutputStream objectoutput;
        
        file= new File("d:/desktop/ArrayPlayers.bin");
        try {
            fileoutput = new FileOutputStream(file);
            objectoutput = new ObjectOutputStream(fileoutput);
            System.out.println(players.length+" ");
            for(int i = 0; i<players.length; i++){
                System.out.println( players[i].getName() );
                objectoutput.writeObject(players[i]);

            }
            System.out.println("Logrado");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Algo paso :c");
        }
    }

    public void leerBin(){
        File file;
        FileInputStream fileinput;
        ObjectInputStream objectinput;

        file= new File("d:/desktop/ArrayPlayers.bin");
        try {
            fileinput = new FileInputStream(file);
            objectinput = new ObjectInputStream(fileinput);
            Object data = objectinput.readObject();
            Player arrayP = (Player)data;
            int count =0;
            while(count<10) {
                System.out.println("*************");
                System.out.println("Name: " +arrayP.getName());
                count++;
    
                
            }
        }catch (Exception e) {
            System.out.println("Algo salio mal!");
        }

    }
}
