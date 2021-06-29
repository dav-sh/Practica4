package src.manejoarchivos;


import java.util.*;


import java.io.*;

public class LecturaA {
    ArrayList <String> list;
    File dir= null;
    FileReader reader=null;
    BufferedReader buff = null;
    public LecturaA(){
        
    }

    public String[] getLines(String pathArchive) {
        String lista[]=null;
        list = new ArrayList<String>();
        dir = new File(pathArchive);
        if(dir.exists()){
            try {
                reader = new FileReader(dir);
                buff = new BufferedReader(reader);
                String linea;
                while((linea = buff.readLine()) != null){
                    //System.out.println(linea);
                    list.add(linea);
                }
                lista = list.toArray(new String[list.size()]);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("No se pudo abrir el archivo");
            }catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
    
            }
            

        }else{
            System.out.println("Archivo no encontrado");
        }
        return lista;
    }
    
}
