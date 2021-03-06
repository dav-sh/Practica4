package src.panels;

import java.awt.*;
import javax.swing.*;

import src.player.Player;

import java.awt.event.*;
import java.util.*;


public class PaneladdPlayer extends JPanel implements ActionListener{
    private JTextField tf1,tf2;
    private JLabel label;
    private JButton btn;
    private int count_Id=1;
    private String name,lastName;
    private ArrayList<Player> players = new ArrayList<Player>();

    
    public PaneladdPlayer(){
        setLayout(new GridLayout(3,3));
        addLabel("Name");
        tf1=addText("");
        add(tf1);
        addLabel("Last Name");
        tf2=addText("");
        add(tf2);
        btn=addButton("Verify");
        add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(tf1.getText().isEmpty() || tf2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Empty fields");
        }else{
            this.name = tf1.getText();
            this.lastName = tf2.getText();
            System.out.println(this.name + " " + this.lastName+"Dentro de action");
            players.add(new Player(this.name, this.lastName, this.count_Id));
            JOptionPane.showMessageDialog(null, "Successful");
            count_Id++;
            tf2.setText("");
            tf1.setText("");
            
        }
        // TODO Auto-generated method stub
        
    }

    private JButton addButton(String name){
        btn = new JButton(name);
        btn.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btn.addActionListener(this);
        btn.setFocusable(false);
        return btn;
    }
    private void addLabel(String name){
        this.label = new JLabel(name, JLabel.CENTER);
        this.label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.label.setFont(new Font("BOLD", Font.BOLD, 20));
        add(this.label, BorderLayout.CENTER);
    }

    private JTextField addText(String name){
        return new JTextField(name);  
    }

    public Player[] getPlayers(){
        return players.toArray(new Player[players.size()]);
    }

}
