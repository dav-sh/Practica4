package src.cell;
import java.awt.*;

public class Vacia extends Cell {

    public Vacia(){
        super("Vacia", new Color(110,164,97));
    }
    @Override
	public String getInfo() {
        return "<html><body>Linea 1 <br> Vacio <br>linea 3 </body></html>";
		// TODO Auto-generated method stub
		
	}
    @Override
	public int[] getPositions() {
		// TODO Auto-generated method stub
        int[] positions = new int[2];
		return positions;
	}

    

    
}
