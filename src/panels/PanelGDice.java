package src.panels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PanelGDice extends JPanel implements ActionListener{
    Random rand = new Random();
    int random = 0;
    JLabel label;
    int turno =1;
    PanelGCells cellsP;
    public PanelGDice(PanelGCells cellsP){
        this.cellsP = cellsP;
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
        System.out.println("Turno Jugador: "+ turno);
        pintaCell(turno);
        this.random = getRandom();
        label.setText(" "+this.random);
        turno++;

        
        
    }
    public void pintaCell(int turno){
        cellsP.celdas[turno][turno].setBackground(Color.RED);
        cellsP.paintCell(turno+1);
    }




    private int getRandom(){
        return rand.nextInt(6)+1;
    }
}