package tangram;
import javax.swing.*;
public class DrawTangrams {

	public static void main(String[] args) {
		Do do1 = new Do();
		do1.DFS(1,true);
		JScrollPane jsp = new JScrollPane(do1.tangramsFigures);
		jsp.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		JFrame frame = new JFrame("A Pattern Matching and Recognition System");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(jsp);
		frame.setSize(400,600);
		frame.setVisible(true);
	}
	
}
