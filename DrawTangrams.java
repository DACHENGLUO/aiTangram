package tangram;
import javax.swing.*;
public class DrawTangrams {

	public static void main(String[] args) {
		Do do1 = new Do();
		do1.DFSAllGraphices(0);
		
		JFrame frame = new JFrame("A Pattern Matching and Recognition System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TangramFigures tangrams = new TangramFigures(do1.tangrams);
		frame.add(tangrams);
		frame.setSize(400,600);
		frame.setVisible(true);
	}
	
}
