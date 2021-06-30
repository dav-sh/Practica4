package src.panels;

import javax.swing.*;
import java.awt.*;
import src.cell.*; 


//lecuta de archivos
import src.manejoarchivos.LecturaA;
import src.manejoarchivos.ObtenerDatos;
import src.manejoarchivos.ObtenerValores;
import src.player.Player;


public class PanelGCells extends JPanel {
    JLabel label;
    int rows=0;
    int columns=0;
    Cell[][]celdas;//new Cell[6][8];
    int [] players_Id;
    int numberPlayers;
    int [] posX;
    int [] posY;
    Player[]players;
    final private String path = "d:/Desktop/sinErrores.txt";





    public PanelGCells(int[] players_Id, Player[] players){
        this.players = players;
        iniciatablero();
        celdas = new Cell[rows][columns];
        this.players_Id = players_Id;
        this.numberPlayers = players_Id.length;
        this.posX = new int[numberPlayers];
        this.posY = new int[numberPlayers];
        setSize(690,550);
        fillArray();
        
    }
    

    
    public void fillArray(){
        try {
            
            
            //System.out.println("filass"+this.rows+" c"+this.columns);
            setLayout(new GridLayout(rows,columns));
            for(int i=0;i<rows;i++){ //rows
                for(int j=0;j<columns;j++){ //columns
                    manejaPenitencias(i,j);
                    // celdas[i][j] = new Vacia();
                    //celdas[i][j] = new Cell(" "+i+","+j); //add
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
                position[0]=row+1;  
                position[1]=residuoColumn-1; 

            }

            
        }else if(  (column+random) < columns && row < rows  ){ //si la suma del random y la columan es menor a las columnas y la fila es menor que las filas
            position[0]=row; //row
            position[1]=column+random; //column
            
        }
        return position;
    }
    
    






    public void paintCell(int turnoP, int Random, JLabel label3){
        celdas[0][0].setBackground(Color.WHITE);
        int [] pos = position(Random, posX[turnoP], posY[turnoP]); //avanza, actual x, actual y --> nueva posicion
        if(pos[0]!=rows-1 && pos[1]!=columns-1){ //
        
            if(evaluaCell(celdas[pos[0]][pos[1]], label3)){ //verifica si caera en una celda especial y si es asi, recalcula la posicion
                //aqui tengo q volver a pintar la celda para dar la ilusion que avance
                imprimeActual(turnoP, pos);
                pos = reposicion(celdas[pos[0]][pos[1]],pos[0], pos[1]);
                //System.out.println("Ojo, me reposicione");
            }
            imprimeActual(turnoP, pos);
            resetColor(celdas[posX[turnoP]][posY[turnoP]], posX[turnoP], posY[turnoP]);
            celdas[0][0].setBackground(Color.WHITE);
            posX[turnoP]=pos[0];
            posY[turnoP]=pos[1];
        
        
        }
        else{
            JOptionPane.showMessageDialog(null, "Jugador con id: " + players_Id[turnoP] + " Gano");
            for(int i = 0; i<players_Id.length; i++){
                System.out.println("id"+ players_Id[i]);
                if(players_Id[turnoP]==players[players_Id[i]-1].getId()){
                    System.out.println("id win " + players_Id[turnoP]+ "id p " + players[players_Id[i]-1].getId());
                    players[players_Id[i]-1].setWins(players[players_Id[i]-1].getWins()+1);
                    players[players_Id[i]-1].setJugadas(players[players_Id[i]-1].getJugadas()+1);
                }else{
                    System.out.println("id Lo " + players_Id[turnoP]+ "id p " + players[players_Id[i]-1].getId());
                    players[players_Id[i]-1].setLosses(players[players_Id[i]-1].getLosses()+1);
                    players[players_Id[i]-1].setJugadas(players[players_Id[i]-1].getJugadas()+1);
                }
            }
            
        }
    }

    public void resetColor(Cell cell, int x, int y){
        if(cell instanceof Avanza){
            celdas[x][y].setBackground(new Color(110,207,97));

        }else if(cell instanceof Bajada){
            celdas[x][y].setBackground(new Color(110,134,97));

        }else if(cell instanceof PierdeTurno){
            celdas[x][y].setBackground(new Color(110,134,97));

        }else if(cell instanceof Retrocede){
            celdas[x][y].setBackground(new Color(110,134,97));;

        }else if(cell instanceof Subida){
            celdas[x][y].setBackground(new Color(110,207,97));

        }else if(cell instanceof Tiradados){
            celdas[x][y].setBackground(new Color(110,207,97));

        }else if(cell instanceof Vacia){
            celdas[x][y].setBackground(new Color(110,164,97));

        }
    }





    public void manejaPenitencias(int posicionx, int posiciony){
        LecturaA lectura = new LecturaA();
        String[] texto = lectura.getLines(path); //array de lineas con todo el texto
        //obtengo una linea especifica para posteriormente manipularla
        String [] penitencias = {"pierdeturno","tiradados","avanza","retrocede","subida","bajada"};
        for(int i = 0; i<penitencias.length; i++){
            try {
                String nameData = penitencias[i];

                String linea = "";
                    //separo el nombre y los valores de la linea anterior

                for(int j = 0; j<texto.length;j++){

                    // if((texto[j].indexOf(nameData))!=-1){
                    if(texto[j].startsWith(nameData)){
                        linea = texto[j];
                        ObtenerValores obtengo = new ObtenerValores();
                        int[] valores = obtengo.seeValues(linea);
                        if(valores[0]==posicionx && valores[1]==posiciony){
                            
                            switch (nameData){
                                case "pierdeturno":
                                    celdas[posicionx][posiciony]=new PierdeTurno(" "+posicionx+","+posiciony);
                                    break;
                                case "tiradados":
                                    celdas[posicionx][posiciony]=new Tiradados(" "+posicionx+","+posiciony);
                                    break;
                                case "avanza":
                                    celdas[posicionx][posiciony]=new Avanza(valores[2]," "+posicionx+","+posiciony);
                                    break;
                                case "retrocede":
                                    celdas[posicionx][posiciony]=new Retrocede(valores[2]," "+posicionx+","+posiciony);
                                    break;
                                case "subida":
                                    celdas[posicionx][posiciony]=new Subida(valores[2],valores[3]," "+posicionx+","+posiciony);
                                    break;
                                case "bajada":
                                    celdas[posicionx][posiciony]=new Bajada(valores[2],valores[3]," "+posicionx+","+posiciony);
                                    break;
                                default:
                            }


                        }

                    }

                }
                //System.out.println("Sali"); 
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("No se pudo pintar");
            }
            

        }
        if(celdas[posicionx][posiciony]==null){
            celdas[posicionx][posiciony] = new Vacia(" "+posicionx+","+posiciony);
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


    private  boolean evaluaCell(Cell cell, JLabel label3){
        boolean modifify = true;
        if(cell instanceof Avanza){
            label3.setText(cell.getInfo());
        }else if(cell instanceof Bajada){
            label3.setText(cell.getInfo());
        }else if(cell instanceof PierdeTurno){
            label3.setText(cell.getInfo());

        }else if(cell instanceof Retrocede){
            label3.setText(cell.getInfo());

        }else if(cell instanceof Subida){
            label3.setText(cell.getInfo());

        }else if(cell instanceof Tiradados){
            label3.setText(cell.getInfo());

        }else if(cell instanceof Vacia){
            label3.setText(cell.getInfo());
            modifify = false;
        }
        return modifify;
    }

    private int[] reposicion(Cell cell, int pRow, int pCol){
        int[] valores = new int[2];
        int [] vals = cell.getPositions();
        if(cell instanceof Avanza){
            JOptionPane.showMessageDialog(null, "Avanzaste"+ vals[0]);

            valores = position(vals[0], pRow, pCol);
        }else if(cell instanceof Bajada){
            JOptionPane.showMessageDialog(null, "Bajaste a"+ vals[0] +","+vals[1]);

            valores[0] = vals[0];
            valores[1] = vals[1];
        }else if(cell instanceof PierdeTurno){
            JOptionPane.showMessageDialog(null, "Perdiste turno");

            valores[0] = pRow;
            valores[1] = pCol;
        }else if(cell instanceof Retrocede){
            JOptionPane.showMessageDialog(null, "Retrocediste"+ vals[0]);

            valores = positionR(vals[0], pRow, pCol);

        }else if(cell instanceof Subida){
            JOptionPane.showMessageDialog(null, "Subiste a"+ vals[0] +","+vals[1]);
            
            valores[0] = vals[0];
            valores[1] = vals[1];
        }else if(cell instanceof Tiradados){
            JOptionPane.showMessageDialog(null, "Turno extra");

            valores[0] = pRow;
            valores[1] = pCol;
        }
        resetColor(cell, pRow, pCol);
        return valores;
    }


    public int[] positionR(int random, int row, int column){ // 0 , 9 //se supone que va en reversa
        int[] position = new int[2];

        int residuoColumn=0;

        if((column-random) <0 && row >= 0){ //si la resta del numero random y la posicion actual de columna es menor a cero se calcula nueva fila siempre y cuando la fila  sea >= 0
            while((column-random)<0){
                random--;
                residuoColumn++;

            }
            System.out.println(row+""+column+":"+random+":"+residuoColumn);
            if((row - 1) <0){
                position[0]=row; //row
                position[1]=column;
                System.out.println("No puedes retroceder mas");
            }else{
                System.out.println("Salto de fila hacia atras");
                position[0]=row-1;  
                position[1]=columns-residuoColumn; 

            }

            
        }else if(  (column-random) >=0 && row >= 0  ){ //si la suma del random y la columan es menor a las columnas y la fila es menor que las filas
            position[0]=row; //row
            position[1]=column-random; //column
            
        }
        return position;
    }

    public void imprimeActual(int turnoP, int[] pos){
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
        //celdas[posX[turnoP]][posY[turnoP]].setBackground(Color.BLUE);
    }


}
