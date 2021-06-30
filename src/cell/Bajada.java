package src.cell;
import java.awt.*;

public class Bajada extends Cell {
    int row;
    int column;
    public Bajada(int row, int column, String pos){
        super("Bajada", new Color(110,134,97), pos);
        this.row = row;
        this.column = column;
    }

	@Override
	public String getInfo() {
        return "<html><body>Te toca <br> Bajar <br>a "+this.row+ ","+this.column+ "</body></html>";
		// TODO Auto-generated method stub
		
	}
    @Override
	public int[] getPositions() {
		// TODO Auto-generated method stub
        int[] positions = new int[2];
        positions[0] = this.row;
        positions[1] = this.column;
		return positions;
	}
    

    
}
