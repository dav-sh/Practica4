package src.window;

import javax.swing.*;


public class MainWindow extends JFrame{
    public MainWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("HolaMundo");
        setBounds(500, 200, 700, 550);
        getContentPane().add(new PanelCell());
        setVisible(true);
        
        
    }
}
