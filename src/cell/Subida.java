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
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

    
}
