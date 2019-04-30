package tangram;
import java.awt.*;
import javax.swing.*;

public class TangramsAllFigures extends JPanel{
	private Polygon[] demos = new Polygon[20];
	private Tangrams[] t = new Tangrams[20];
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		demos[0]= new Polygon();
		demos[0].addPoint(100, 100);
		demos[0].addPoint(100, 200);
		demos[0].addPoint(200, 200);
	    //demos[0].translate(40,0);
		g.fillPolygon(demos[0]);
		
		//g.setColor(Color.RED);
		g.drawString("12", 230, 80);
		demos[1]= new Polygon();
		demos[1].addPoint(250, 100);
		demos[1].addPoint(350, 100);
		demos[1].addPoint(350, 200);
		g.fillPolygon(demos[1]);
		
		g.drawString("13", 80, 230);
		demos[2]= new Polygon();
		demos[2].addPoint(100, 350);
		demos[2].addPoint(100, 250);
		demos[2].addPoint(200, 250);
		g.fillPolygon(demos[2]);
		
		g.drawString("14", 230, 230);
		demos[3]= new Polygon();
		demos[3].addPoint(250, 350);
		demos[3].addPoint(350, 250);
		demos[3].addPoint(350, 350);
		g.fillPolygon(demos[3]);
	}
}