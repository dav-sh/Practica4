package src.panels;
import java.awt.*;
import javax.swing.*;

import src.windows.*;

import java.awt.event.*;


public class PanelMenu extends JPanel implements ActionListener{
    MPlayers mplayers = new MPlayers();
    private String[] buttons = {"See Players","Add New Player","Start Game","Statistics"};
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
                mplayers.seePlayers();
                System.out.println("Hola soy see players");
                break;  
            case "Add New Player":
                mplayers.addPlayer();
                System.out.println("Hola soy Add New Player");
                break;
            case "Start Game":
                System.out.println("Hola soy Start Game");
                new Game();  //Game game = 
                break;
            case "Statistics":
                System.out.println("Hola soy Statistics");
                break;
            default:

        }
        
        
    }


}