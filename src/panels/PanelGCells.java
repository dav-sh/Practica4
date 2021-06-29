package src.panels;

import javax.swing.*;
import java.awt.*;
import src.cell.Cell; 

public class PanelGCells extends JPanel {
    JLabel label;
    int rows = 10;
    int columns = 10;
    Cell[][]celdas= new Cell[rows][columns];
    int [] players_Id;
    int numberPlayers;
    int [] posX;
    int [] posY;
    public PanelGCells(int[] players_Id){
        this.players_Id = players_Id;
        this.numberPlayers = players_Id.length;
        this.posX = new int[numberPlayers];
        this.posY = new int[numberPlayers];
        setSize(690,550);
        fillArray();
    }
    

    
    public void fillArray(){
        setLayout(new GridLayout(rows,columns));
        for(int i=0;i<rows;i++){ //rows
            for(int j=0;j<columns;j++){ //columns
                celdas[i][j] = new Cell(" "+i+","+j); //add
                this.add(celdas[i][j]);
            }
        }
        celdas[0][0].setBackground(Color.WHITE);

    }
    public int[] position(int random, int row, int column){ // 0 , 9
        int[] position = new int[2];
        // int rows =10;
        // int columns = 10;
        int residuoColumn=0;
        // System.out.println("random "+random);
        // System.out.println("row "+row + "column "+column);
        if((column+random) >= columns && row < rows){ //si la suma del numero random, mas la posicion actual de columna es mayor al numero de columnas se calcula nueva fila siempre y cuando la fila sea menor al numero de filas
            // System.out.println("Entre..");
            while((column+random)>=columns){
                random--;
                residuoColumn++;
                // System.out.println("rnd: "+ random + "residuo: "+residuoColumn);
            }
            // System.out.println("Final....");
            // System.out.println("random "+random);
            // System.out.println("residuo "+residuoColumn);
            // System.out.println("row "+row);
            position[0]=row+1;  //row
            position[1]=residuoColumn-1; //a y le sumamos 1   column

            
        }else{ //
            position[0]=row; //row
            position[1]=column+random; //column
        }
        return position;
    }
    


    public void paintCell(int turnoP, int Random){
        int [] pos = position(Random, posX[turnoP], posY[turnoP]); //avanza, actual x, actual y
        if(turnoP==0){
            celdas[posX[turnoP]][posY[turnoP]].setBackground(Color.RED);
            celdas[pos[0]][pos[1]].setBackground(Color.RED);
        }else if(turnoP == 1){
            celdas[posX[turnoP]][posY[turnoP]].setBackground(Color.LIGHT_GRAY);

            celdas[pos[0]][pos[1]].setBackground(Color.LIGHT_GRAY);

        }else if(turnoP==2){
            celdas[posX[turnoP]][posY[turnoP]].setBackground(Color.YELLOW);

            celdas[pos[0]][pos[1]].setBackground(Color.YELLOW);

        }else if(turnoP==3){
            celdas[pos[0]][pos[1]].setBackground(Color.CYAN);

        }else if(turnoP==4){
            celdas[pos[0]][pos[1]].setBackground(Color.MAGENTA);

        }else if(turnoP==5){
            celdas[pos[0]][pos[1]].setBackground(Color.ORANGE);

        }
        celdas[posX[turnoP]][posY[turnoP]].setBackground(Color.BLUE);
        celdas[0][0].setBackground(Color.WHITE);
        posX[turnoP]=pos[0];
        posY[turnoP]=pos[1];
    }



}
