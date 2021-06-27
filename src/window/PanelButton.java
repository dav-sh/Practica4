package src.window;

import java.awt.*;
import javax.swing.*;

public class PanelButton extends JPanel{

    public PanelButton(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0,100)));
        addLabel("###");
        add(Box.createRigidArea(new Dimension(0,20)));
        add(addButton("Tirar DADO"));
        setBackground(new Color(0,75,255));
    }

    private JButton addButton(String name){
        JButton btn = new JButton(name);
        btn.setAlignmentX(JButton.CENTER_ALIGNMENT);
        btn.setFocusable(false);
        return btn;
    }
    private void addLabel(String name){
        JLabel label = new JLabel(name, JLabel.CENTER);
        add(label, BorderLayout.NORTH);
    }
}