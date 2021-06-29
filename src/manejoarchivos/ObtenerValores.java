package src.manejoarchivos;

public class ObtenerValores {
    public ObtenerValores() {

    }
    public int[] seeValues(String linea){
        
        int c1 = linea.indexOf("(")+1;
        int c2 = linea.indexOf(")");
        String c = linea.substring(c1,c2);
        String []srt = c.split(",");
        int[]position = new int[srt.length];
        try {
            
            for(int i=0;i<srt.length; i++){
                System.out.println(srt[i]);
                position[i] = Integer.valueOf(srt[i]);
            }



        } catch (Exception e) {
            //TODO: handle exception
        }
        return position;
        




        //System.out.println(" " + c1 + " " + c2 + " "+c);
        
    }




}
