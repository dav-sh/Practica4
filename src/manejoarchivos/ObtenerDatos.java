package src.manejoarchivos;

public class ObtenerDatos {
    String[] datos;
    public ObtenerDatos(String[] texto) {
        datos = texto;
    }



    
    public String getDatos(String nameData){
        String result = "";
        int ind;
        for(int i=0; i<datos.length; i++){
            if((ind = datos[i].indexOf(nameData))!=-1){
                //if(datos[i].startsWith(nameData)){
                System.out.println("Encontrado en "+ ind);
                result = datos[i];
            }//else{
            //     System.out.println("No existe datos");
            // }
        }
        return result;

    }

}
