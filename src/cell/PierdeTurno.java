package src.cell;
import java.awt.*;

public class PierdeTurno extends Cell {

    public PierdeTurno(){
        super("Pierde",new Color(110,134,97));

        
    }
    @Override
	public String getInfo() {
        return "<html><body>Linea 1 <br> Pierte T <br>linea 3 </body></html>";
		// TODO Auto-generated method stub
		
	}
    @Override
	public int[] getPositions() {
		// TODO Auto-generated method stub
        int[] positions = new int[1];
		return positions;
	}
    

    

    
}
