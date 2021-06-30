package src.cell;
import java.awt.*;

public class Bajada extends Cell {
    int row;
    int column;
    public Bajada(int row, int column){
        super("Bajada", new Color(110,134,97));
        this.row = row;
        this.column = column;
    }

	@Override
	public String getInfo() {
        return "<html><body>Te toca <br> Bajar <br>a "+this.row+ ","+this.column+ "</body></html>";
		// TODO Auto-generated method stub
		
	}
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    

    
}
