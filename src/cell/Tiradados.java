package src.cell;
import java.awt.*;

public class Tiradados extends Cell {

    public Tiradados(String pos){
        super("Tiradados", new Color(110,207,97), pos);
    }

    @Override
	public String getInfo() {
        return "<html><body>Linea 1 <br> Tira <br>linea 3 </body></html>";
		// TODO Auto-generated method stub
		
	}

    @Override
	public int[] getPositions() {
		// TODO Auto-generated method stub
        int[] positions = new int[2];
		return positions;
	}
}
