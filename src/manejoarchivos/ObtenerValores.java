package src.manejoarchivos;

public class ObtenerValores {
    public ObtenerValores() {

    }
    public void seeValues(String linea, String nameData){
        int c1 = linea.indexOf("(")+1;
        int c2 = linea.indexOf(")");
        String c = linea.substring(c1,c2);
        System.out.println(" " + c1 + " " + c2 + " "+c);
        
    }

}
