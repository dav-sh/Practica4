package src.window;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PanelButton extends JPanel implements ActionListener{
    Random rand = new Random();
    JLabel label;
    public PanelButton(){
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
        label.setText(" "+getRandom());
        
        
    }

    private int getRandom(){
        return rand.nextInt(6)+1;
    }
}