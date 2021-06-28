package src.panels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PanelGDice extends JPanel implements ActionListener{
    Random rand = new Random();
    int random = 0;
    JLabel label;
    int turno =0;
    PanelGCells cellsP;
    int [] players_Id;
    public PanelGDice(PanelGCells cellsP, int[] players_Id){
        this.cellsP = cellsP;
        this.players_Id = players_Id;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0,100)));
        addLabel("-");
        add(Box.createRigidArea(new Dimension(0,20)));
        add(addButton("Tirar DADO"));
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
        label = new JLabel(name, JLabel.CENTER);
        add(label, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        cambiaTurno();
        this.random = getRandom();
        cellsP.paintCell(this.turno, this.random);
        label.setText(" "+this.random);
        this.turno++;

        
        
    }


    public void cambiaTurno(){
        if(this.turno<players_Id.length){
            System.out.println("Turno Jugador: "+ players_Id[this.turno]);
        }else{
            this.turno =0;
            System.out.println("reset ....");
            System.out.println("Turno Jugador: "+ players_Id[this.turno]);
        }
    }




    private int getRandom(){
        return rand.nextInt(6)+1;
    }
}