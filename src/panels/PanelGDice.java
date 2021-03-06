package src.panels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PanelGDice extends JPanel implements ActionListener{
    Random rand = new Random();
    int random = 0;
    JLabel label;
    JLabel label2, label3;
    int turno =0;
    PanelGCells cellsP;
    int [] players_Id;
    public PanelGDice(PanelGCells cellsP, int[] players_Id){
        this.cellsP = cellsP;
        this.players_Id = players_Id;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0,100)));
        addLabel("##");
        add(Box.createRigidArea(new Dimension(0,20)));
        add(addButton("Tirar DADO"));
        add(Box.createRigidArea(new Dimension(0,20)));
        addLabel2("Turno Jugador: 1");
        add(Box.createRigidArea(new Dimension(0,20)));
        addLabel3("Info");
        setBackground(new Color(0,75,255));
    }

    private JButton addButton(String name){
        JButton btn = new JButton(name);
        btn.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btn.addActionListener(this);
        btn.setFocusable(false);
        return btn;
    }
    private void addLabel(String name){
        this.label = new JLabel(name, JLabel.CENTER);
        this.label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.label.setFont(new Font("BOLD", Font.BOLD, 25));
        add(this.label, BorderLayout.CENTER);
    }
    private void addLabel2(String name){
        this.label2 = new JLabel(name, JLabel.CENTER);
        this.label2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.label2.setFont(new Font("BOLD", Font.ITALIC, 10));
        this.add(this.label2, BorderLayout.CENTER);
    }
    private void addLabel3(String name){
        this.label3 = new JLabel(name, JLabel.CENTER);
        this.label3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.label3.setFont(new Font("BOLD", Font.ITALIC, 10));
        this.add(this.label3, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("turno actual " + this.turno);
        this.random = getRandom();
        this.label.setText(" "+this.random);
        //this.label3.setText(cellsP.getInfo());
        cellsP.paintCell(this.turno, this.random, label3);
        this.turno++;
        cambiaTurno();
        System.out.println("Nuevo turno " + this.turno);
        
        

        
        
    }


    public void cambiaTurno(){
        if(this.turno<=(players_Id.length-1)){
            this.label2.setText("Turno Jugador: "+ " "+(this.turno+1));  //players_Id[this.turno] +
            //System.out.println("Turno Jugador: "+ players_Id[this.turno]);
        }else{
            this.turno =0;
            System.out.println("reset ....");
            this.label2.setText("Turno Jugador: "+ " "+(this.turno+1));//players_Id[this.turno]);
            //System.out.println("Turno Jugador: "+ players_Id[this.turno]);
        }
    }






    private int getRandom(){
        return rand.nextInt(6)+1;
    }
}