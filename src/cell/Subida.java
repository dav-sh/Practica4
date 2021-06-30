package src.cell;
import java.awt.*;

public class Subida extends Cell {
    int row;
    int column;
    public Subida(int row, int column){
        super("Subida", new Color(110,207,97));
        this.row = row;
        this.column = column;
    }
    @Override
	public String getInfo() {
        return "<html><body>Te toca <br> subir <br>a "+this.row+ ","+this.column+ "</body></html>";
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
