package src.cell;
import java.awt.*;

public class Retrocede extends Cell {
    int cantidadPos;
    public Retrocede(int cantidadPos){
        super("Retrocede", new Color(110,134,97));
        this.cantidadPos = cantidadPos;
    }
    @Override
	public String getInfo() {
        return "<html><body>Te toca <br> Retroceder <br> "+this.cantidadPos+" </body></html>";
		// TODO Auto-generated method stub
		
	}
    public int getCantidadPos() {
        return cantidadPos;
    }

    
}
