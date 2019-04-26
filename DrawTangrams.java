package tangram;
import javax.swing.*;
public class DrawTangrams {

	public static void main(String[] args) {
		/*Do do1 = new Do();
		do1.DFS();*/
		Data data1 = new Data();
		Tangrams t = new Tangrams(data1.LT);
		t.prointRotateContent();
		JFrame frame = new JFrame("Drawing Tangrams");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tangram tangrams = new Tangram();
		frame.add(tangrams);
		frame.setSize(400,600);
		frame.setVisible(true);
	}
	
}
