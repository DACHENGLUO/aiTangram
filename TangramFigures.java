package tangram;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TangramFigures extends JPanel{
	private List<Polygon> polygonFigures = new ArrayList<>();
	private int GroupCount =0;
	public void setTangrams(Tangrams[] tangrams) {
		
		for(int i =0;i<7;i++) {
			Polygon tempPolygon= new Polygon();
			int pointCount = tangrams[i].pointX.size();
			for(int j =0;j<pointCount;j++) {
				
				tempPolygon.addPoint(tangrams[i].pointX.get(j)+GroupCount*200, tangrams[i].pointY.get(j));
			}
			polygonFigures.add(tempPolygon);
		}
		GroupCount++;
		
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.RED);
		for(int i=0;i<GroupCount;i++) {
			g.fillPolygon(polygonFigures.get(0+7*i));
		}
			g.setColor(Color.MAGENTA);
			for(int i=0;i<GroupCount;i++) {
				g.fillPolygon(polygonFigures.get(1+7*i));
			}
			
			g.setColor(Color.GREEN);
			for(int i=0;i<GroupCount;i++) {
				g.fillPolygon(polygonFigures.get(2+7*i));
			}
			g.setColor(Color.GRAY);
			for(int i=0;i<GroupCount;i++) {
				g.fillPolygon(polygonFigures.get(3+7*i));
			}
			
			g.setColor(Color.YELLOW);
			for(int i=0;i<GroupCount;i++) {
				g.fillPolygon(polygonFigures.get(4+7*i));
			}
			g.setColor(Color.BLUE);
			for(int i=0;i<GroupCount;i++) {
				g.fillPolygon(polygonFigures.get(5+7*i));
			}
			
			g.setColor(Color.CYAN);
			for(int i=0;i<GroupCount;i++) {
				g.fillPolygon(polygonFigures.get(6+7*i));
			}
		
		
		
	}
}
