package src.windows;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import src.panels.PanelMenu;


public class MainMenu extends JFrame{
    public MainMenu(){
    

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //not visible
        setTitle("Menu"); //title of game
        setBounds(500, 200, 700, 550); //size and position of JFrame
        getContentPane().add(new PanelMenu(),"Center"); //add PanelCells
        setVisible(true);
    }
    
}
