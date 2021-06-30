package src.cell;
import java.awt.*;

public class Avanza extends Cell {
    int positions;
    public Avanza(int positions){
        super("Avanza", new Color(110,207,97));
        this.positions = positions;
    }
    @Override
	public String getInfo() {
        return "<html><body>Te toca <br> Avanzar <br>"+this.positions+" posiciones </body></html>";
		// TODO Auto-generated method stub
		
	}
	@Override
	public int[] getPositions() {
		// TODO Auto-generated method stub
        int[] positions = new int[1];
        positions[0] = this.positions;
		return positions;
	}
    

    

    
}
