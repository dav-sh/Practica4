package src.cell;
import java.awt.*;

public class Retrocede extends Cell {
    int cantidadPos;
    public Retrocede(int cantidadPos, String pos){
        super("Retrocede", new Color(110,134,97), pos);
        this.cantidadPos = cantidadPos;
    }
    @Override
	public String getInfo() {
        return "<html><body>Te toca <br> Retroceder <br> "+this.cantidadPos+" </body></html>";
		// TODO Auto-generated method stub
		
	}
    @Override
	public int[] getPositions() {
		// TODO Auto-generated method stub
        int[] positions = new int[1];
        positions[0] = this.cantidadPos;
		return positions;
	}
    
    
}
