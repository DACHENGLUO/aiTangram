package tangram;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class TangramsAllFigures extends JPanel{
	private Data data1 = new Data();
	private List<Polygon> polygonFigures = new ArrayList<>();
	private Tangrams[] t = new Tangrams[4];
	
    public void setTangrams() {
		
    	for(int i =0;i<4;i++) {
    		t[i] = new Tangrams(data1.LT);
			t[i].shape=5;
			t[i].locationX=i;
			t[i].locationY=0;
			t[i].rotateDegree=i;
			t[i].setXY();
		}
		for(int i =0;i<4;i++) {
			Polygon tempPolygon= new Polygon();
			int pointCount = t[i].pointX.size();
			for(int j =0;j<pointCount;j++) {
				
				tempPolygon.addPoint(t[i].pointX.get(j)+i*300,t[i].pointY.get(j));
			}
			polygonFigures.add(tempPolygon);
		}
		
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i =0;i<4;i++) {
			g.fillPolygon(polygonFigures.get(i));
		}
	}
}