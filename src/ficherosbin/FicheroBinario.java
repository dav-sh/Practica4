package src.ficherosbin;

import java.io.*;
import javax.swing.*;
import java.awt.*;



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
        
        file= new File("Players.bin");
        try {
            fileoutput = new FileOutputStream(file);
            objectoutput = new ObjectOutputStream(fileoutput);
            System.out.println(players.length+" ");
            for(int i = 0; i<players.length; i++){
                System.out.println( players[i].getName() );
                objectoutput.writeObject(players[i]);

            }
            JOptionPane.showMessageDialog(null, "Players.bin created!!!");

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

        file= new File("Players.bin");
        try {
            fileinput = new FileInputStream(file);
            objectinput = new ObjectInputStream(fileinput);
            Object data = objectinput.readObject();
            Player arrayP = (Player)data;
            int numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog( "Enter the number of players to see"));
            int count =0;
            DefaultListModel<String> listP = new DefaultListModel<>();
            String str;
            while(count<numberOfPlayers) {
                System.out.println("*************");
                System.out.println("Name: " +arrayP.getName());
                str = "id: "+ arrayP.getId() +"name: "+ arrayP.getName();
                listP.addElement(str);
                count++;
    
                
            }
            JList<String> list = new JList<>(listP);
            JFrame jadd = new JFrame();
            jadd.setBackground(new Color(0,0,20));
            jadd.setTitle("Data Saved"); //title of game
            jadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jadd.setBounds(500, 200, 300, 550); //size and position of JFrame
            jadd.add(list,"Center");
            jadd.setVisible(true);

        }catch (Exception e) {
            System.out.println("Algo salio mal!");
            JOptionPane.showMessageDialog(null, "There are no players");

        }

    }




}
