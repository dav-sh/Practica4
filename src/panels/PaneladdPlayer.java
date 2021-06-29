package src.panels;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PaneladdPlayer extends JPanel implements ActionListener{
    JTextField tf1,tf2;
    JLabel label;
    JButton btn;
    private String name,lastName;
    
    public PaneladdPlayer(){
        setLayout(new GridLayout(3,3));
        addLabel("Name");
        tf1=addText("Name");
        add(tf1);

        addLabel("Last Name");
        tf2=addText("Last Name");
        add(tf2);

        btn=addButton("Verificar");
        add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        name = tf1.getText();
        lastName = tf2.getText();
        System.out.println(name + " " + lastName);


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
        this.label.setFont(new Font("BOLD", Font.BOLD, 25));
        add(this.label, BorderLayout.CENTER);
    }

    private JTextField addText(String name){
        return new JTextField(name);  
    }

    public String getNames(){
        return this.name;
    }
    public String getLastName(){
        return this.lastName;
    }
    
}
