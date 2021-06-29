package src.panels;

import javax.swing.*;
import java.awt.*;
import src.cell.Cell; 


//lecuta de archivos
import src.manejoarchivos.LecturaA;
import src.manejoarchivos.ObtenerDatos;
import src.manejoarchivos.ObtenerValores;


public class PanelGCells extends JPanel {
    JLabel label;
    int rows=0;
    int columns=0;
    Cell[][]celdas;//new Cell[6][8];
    int [] players_Id;
    int numberPlayers;
    int [] posX;
    int [] posY;
    final private String path = "d:/Desktop/sinErrores.txt";





    public PanelGCells(int[] players_Id){
        iniciatablero();
        celdas = new Cell[rows][columns];
        this.players_Id = players_Id;
        this.numberPlayers = players_Id.length;
        this.posX = new int[numberPlayers];
        this.posY = new int[numberPlayers];
        setSize(690,550);
        fillArray();
        manejaPenitencias();
    }
    

    
    public void fillArray(){
        try {
            
            
            System.out.println("filass"+this.rows+" c"+this.columns);
            setLayout(new GridLayout(rows,columns));
            for(int i=0;i<rows;i++){ //rows
                for(int j=0;j<columns;j++){ //columns
                    celdas[i][j] = new Cell(" "+i+","+j); //add
                    this.add(celdas[i][j]);
                }
            }
            celdas[0][0].setBackground(Color.WHITE);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("No se creo el tablero");
        }

    }






    public int[] position(int random, int row, int column){ // 0 , 9
        int[] position = new int[2];
        // int rows =10;
        // int columns = 10;
        int residuoColumn=0;
        // System.out.println("random "+random);
        // System.out.println("row "+row + "column "+column);
        if((column+random) >= columns && row < rows){ //si la suma del numero random mas la posicion actual de columna es mayor al numero de columnas se calcula nueva fila siempre y cuando la fila sea menor al numero de filas
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
            if((row + 1) >= rows){
                position[0]=row; //row
                position[1]=column;
                System.out.println("No puedes avanzar mas");
            }else{
                position[0]=row+1;  //row
                position[1]=residuoColumn-1; //a y le sumamos 1   column

            }

            
        }else if(  (column+random) < columns && row < rows  ){ //si la suma del random y la columan es menor a las columnas y la fila es menor que las filas
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







    public void manejaPenitencias(){
        LecturaA lectura = new LecturaA();
        String[] texto = lectura.getLines(path); //array de lineas con todo el texto
        //obtengo una linea especifica para posteriormente manipularla
        String [] penitencias = {"pierdeturno","tiradados","avanza","retrocede","subida","bajada"};
        for(int i = 0; i<penitencias.length; i++){
            try {
                String nameData = penitencias[i];

                String result = "";
                    //separo el nombre y los valores de la linea anterior
                int ind;
                for(int j = 0; j<texto.length; j++){

                    if((ind = texto[j].indexOf(nameData))!=-1){
                        //if(datos[i].startsWith(nameData)){
                        System.out.println("Encontrado en "+ ind);
                        result = texto[j];
                        String linea = result;
                        ObtenerValores obtengo = new ObtenerValores();
                        int[] valores = obtengo.seeValues(linea);

                        if(nameData.equals("pierdeturno")){
                            celdas[valores[0]][valores[1]].setBackground(Color.BLACK);
                        }else if(nameData.equals("tiradados")){
                            celdas[valores[0]][valores[1]].setBackground(new Color(20,2,15));
                        }else if(nameData.equals("avanza")){
                            celdas[valores[0]][valores[1]].setBackground(new Color(13,160,0));
                        }else if(nameData.equals("retrocede")){
                            celdas[valores[0]][valores[1]].setBackground(new Color(20,60,65));
                        }else if(nameData.equals("subida")){
                            celdas[valores[0]][valores[1]].setBackground(new Color(1,16,30));
                        }else if(nameData.equals("bajada")){
                            celdas[valores[0]][valores[1]].setBackground(new Color(56,100,3));
                        }

                    }



                }
                    
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Algo salio mal");
            }
            

        }
    }

    public void iniciatablero(){
        LecturaA lectura = new LecturaA();
        String[] texto = lectura.getLines(path); //array de lineas con todo el texto
        //obtengo una linea especifica para posteriormente manipularla
        String [] penitencias = {"tablero"};
        for(int i = 0; i<penitencias.length; i++){
            try {
                String nameData = penitencias[i];
                ObtenerDatos datos = new ObtenerDatos(texto);
                String linea = datos.getDatos(nameData);
                //System.out.println(linea);
                //separo el nombre y los valores de la linea anterior
                ObtenerValores obtengo = new ObtenerValores();
                int[] valores = obtengo.seeValues(linea);
                if(nameData.equals("tablero")){
                    this.rows = valores[0];
                    this.columns = valores[1];
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Algo salio mal");
            }
        }

    }





}
