package src.panels;
import java.awt.*;
import javax.swing.*;

import src.ficherosbin.FicheroBinario;
import src.windows.*;

import java.awt.event.*;


public class PanelMenu extends JPanel implements ActionListener{
    MPlayers mplayers = new MPlayers();
    
    private String[] buttons = {"See Players","Add New Player","Start Game","Statistics","Save Data","Read Data"};


    public PanelMenu(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0,100)));
        setBackground(new Color(0,75,0));
        addLabel("Main Menu");
        drawButtons();
    }
    private void drawButtons(){
        for(int i = 0; i <buttons.length;i++){
            add(Box.createRigidArea(new Dimension(0,20)));
            add(addButton(buttons[i]));
        }
    }
 
    

    private JButton addButton(String name){
        JButton btn = new JButton(name);
        btn.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btn.addActionListener(this);
        btn.setFocusable(false);
        btn.setPreferredSize(new Dimension(80,40));
        return btn;
    }
    private void addLabel(String name){
        JLabel label = new JLabel(name,JLabel.CENTER);
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Serif", Font.PLAIN, 25));
        add(label, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String actionCommand = e.getActionCommand();
        switch(actionCommand){
            case "See Players":
                System.out.println("Hola soy see players");
                mplayers.seePlayers();
                break;  
            case "Add New Player":
                System.out.println("Hola soy Add New Player");
                mplayers.addPlayer();
                break;
            case "Start Game":
                System.out.println("Hola soy Start Game");
                new Game(mplayers.getPlayer());  //Game game = 
                break;
            case "Statistics":
                System.out.println("Hola soy Statistics");
                mplayers.statistics();
                break;
            case "Save Data":
                System.out.println("Hola soy save data");
                FicheroBinario fichero = new FicheroBinario(mplayers.getPlayer());
                fichero.escribirBin();
                break;
            case "Read Data":
                System.out.println("Hola soy read data");
                FicheroBinario fichero2 = new FicheroBinario(mplayers.getPlayer());
                fichero2.leerBin();
                break;
            default:

        }
    }
}