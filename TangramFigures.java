package tangram;
import java.awt.*;
import javax.swing.*;

public class TangramFigures extends JPanel{
	private Polygon[] polygonFigures = new Polygon[7];
	
	public TangramFigures(Tangrams[] tangrams) {
		super();
		for(int i =0;i<7;i++) {
			polygonFigures[i]= new Polygon();
			int pointCount = tangrams[i].pointX.size();
			for(int j =0;j<pointCount;j++) {
				
				polygonFigures[i].addPoint(tangrams[i].pointX.get(j), tangrams[i].pointY.get(j));
			}
			
		}
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		g.setColor(Color.RED);
		g.fillPolygon(polygonFigures[0]);
		
		g.setColor(Color.PINK);
		g.fillPolygon(polygonFigures[1]);
		
		g.setColor(Color.GREEN);
		g.fillPolygon(polygonFigures[2]);
		
		g.setColor(Color.BLUE);
		g.fillPolygon(polygonFigures[3]);
		
		
		g.setColor(Color.CYAN);
		g.fillPolygon(polygonFigures[4]);
		
		g.setColor(Color.GRAY);
		g.fillPolygon(polygonFigures[5]);
		
		g.setColor(Color.YELLOW);
		g.fillPolygon(polygonFigures[6]);
		
	}
}
