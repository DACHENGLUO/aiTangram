package tangram;

import java.util.ArrayList;
import java.util.List;

public class Tangrams {

	public List<Integer> pointX = new ArrayList<>();
	public List<Integer> pointY = new ArrayList<>();
	public int shape; 
	public int locationX;
	public int locationY;
	public List<int[][]> rotateContent;
	public int rotateDegree;
	public Tangrams(int[][] rotateContent0) {
		
		this.locationX = 0;
		this.locationY = 0;
		this.rotateDegree = 0;
		rotateContent = new ArrayList<>();
		
		int[][] rotateContent1 = new int[rotateContent0[0].length][rotateContent0.length];
		int[][] rotateContent2 = new int[rotateContent0.length][rotateContent0[0].length];
		int[][] rotateContent3 = new int[rotateContent0[0].length][rotateContent0.length];
		

		
		
		for(int i =0;i<rotateContent0.length;i++) {
			for(int j =0;j<rotateContent0[0].length;j++) {
				if(rotateContent0[i][j]==23||rotateContent0[i][j]==27) {
					rotateContent1[j][rotateContent0.length-1-i] = 50 - rotateContent0[i][j];
				}
				else if(rotateContent0[i][j]==0) {
					rotateContent1[j][rotateContent0.length-1-i] = 0;
				}
				else if(rotateContent0[i][j]==14) {
					rotateContent1[j][rotateContent0.length-1-i] = 11;
				}
				else if(rotateContent0[i][j]==11) {
					rotateContent1[j][rotateContent0.length-1-i] = 13;
				}
				else if(rotateContent0[i][j]==12) {
					rotateContent1[j][rotateContent0.length-1-i] = 14;
				}
				else if(rotateContent0[i][j]==13) {
					rotateContent1[j][rotateContent0.length-1-i] = 12;
				}
			}
		}
		
		
		for(int i =0;i<rotateContent0.length;i++) {
			for(int j =0;j<rotateContent0[0].length;j++) {
				if(rotateContent0[i][j]==23||rotateContent0[i][j]==27) {
					rotateContent2[rotateContent0.length-1-i][rotateContent0[0].length-1-j] = rotateContent0[i][j];
				}
				else if(rotateContent0[i][j]==0) {
					rotateContent2[rotateContent0.length-1-i][rotateContent0[0].length-1-j] = 0;
				}
				else if(rotateContent0[i][j]==14) {
					rotateContent2[rotateContent0.length-1-i][rotateContent0[0].length-1-j] = 13;
				}
				else if(rotateContent0[i][j]==11) {
					rotateContent2[rotateContent0.length-1-i][rotateContent0[0].length-1-j] = 12;
				}
				else if(rotateContent0[i][j]==12) {
					rotateContent2[rotateContent0.length-1-i][rotateContent0[0].length-1-j] = 11;
				}
				else if(rotateContent0[i][j]==13) {
					rotateContent2[rotateContent0.length-1-i][rotateContent0[0].length-1-j] = 14;
				}
			}
		}
		
		
		for(int i =0;i<rotateContent0.length;i++) {
			for(int j =0;j<rotateContent0[0].length;j++) {
				if(rotateContent0[i][j]==23||rotateContent0[i][j]==27) {
					rotateContent3[rotateContent0[0].length-1-j][i] =50 - rotateContent0[i][j];
				}
				else if(rotateContent0[i][j]==0) {
					rotateContent3[rotateContent0[0].length-1-j][i] = 0;
				}
				else if(rotateContent0[i][j]==14) {
					rotateContent3[rotateContent0[0].length-1-j][i] = 12;
				}
				else if(rotateContent0[i][j]==11) {
					rotateContent3[rotateContent0[0].length-1-j][i] = 14;
				}
				else if(rotateContent0[i][j]==12) {
					rotateContent3[rotateContent0[0].length-1-j][i] = 13;
				}
				else if(rotateContent0[i][j]==13) {
					rotateContent3[rotateContent0[0].length-1-j][i] = 11;
				}
			}
		}
		
		rotateContent.add(rotateContent0);
		rotateContent.add(rotateContent1);
		rotateContent.add(rotateContent2);
		rotateContent.add(rotateContent3);
	}
	
	public void setXY() {
		if(shape == 1&&rotateDegree == 0) {
			pointX.add(locationX*50 + 50);
			pointX.add(locationX*50 + 150);
			pointX.add(locationX*50 + 250);
			pointY.add(locationY*50 + 150);
			pointY.add(locationY*50 + 50);
			pointY.add(locationY*50 + 150);
		}
		else if(shape == 1&&rotateDegree == 1) {
			pointX.add(locationX*50 + 50);
			pointX.add(locationX*50 + 50);
			pointX.add(locationX*50 + 150);
			pointY.add(locationY*50 + 50);
			pointY.add(locationY*50 + 250);
			pointY.add(locationY*50 + 150);
		}
		else if(shape == 1&&rotateDegree == 2) {
			pointX.add(locationX*50 + 50);
			pointX.add(locationX*50 + 150);
			pointX.add(locationX*50 + 250);
			pointY.add(locationY*50 + 50);
			pointY.add(locationY*50 + 150);
			pointY.add(locationY*50 + 50);
		}
		else if(shape == 1&&rotateDegree == 3) {
			pointX.add(locationX*50 + 50);
			pointX.add(locationX*50 + 150);
			pointX.add(locationX*50 + 150);
			pointY.add(locationY*50 + 150);
			pointY.add(locationY*50 + 50);
			pointY.add(locationY*50 + 250);
		}
		else if(shape == 2&&rotateDegree == 0) {
	        	pointX.add(locationX*50 + 150);
	        	pointX.add(locationX*50 + 50);
	        	pointX.add(locationX*50 + 150);
	        	pointY.add(locationY*50 + 50);
	        	pointY.add(locationY*50 + 150);
	        	pointY.add(locationY*50 + 150);
		}
		else if(shape == 2&&rotateDegree == 1) {
	        	pointX.add(locationX*50 + 50);
	        	pointX.add(locationX*50 + 50);
	        	pointX.add(locationX*50 + 150);
	        	pointY.add(locationY*50 + 50);
	        	pointY.add(locationY*50 + 150);
	        	pointY.add(locationY*50 + 150);
		}
		else if(shape == 2&&rotateDegree == 2) {
	       		pointX.add(locationX*50 + 50);
	        	pointX.add(locationX*50 + 150);
	        	pointX.add(locationX*50 + 50);
	        	pointY.add(locationY*50 + 50);
	        	pointY.add(locationY*50 + 50);
	        	pointY.add(locationY*50 + 150);
		}
		else if(shape == 2&&rotateDegree == 3) {
	        	pointX.add(locationX*50 + 50);
	       		pointX.add(locationX*50 + 150);
	        	pointX.add(locationX*50 + 150);
	        	pointY.add(locationY*50 + 50);
	        	pointY.add(locationY*50 + 50);
	        	pointY.add(locationY*50 + 150);
		}

		else if(shape == 3&&rotateDegree == 0) {
	        	pointX.add(locationX*50 + 50);
	        	pointX.add(locationX*50 + 100);
	        	pointX.add(locationX*50 + 150);
	        	pointY.add(locationY*50 + 100);
	        	pointY.add(locationY*50 + 50);
	        	pointY.add(locationY*50 + 100);
		}
		else if(shape == 3&&rotateDegree == 1) {
	        	pointX.add(locationX*50 + 50);
	        	pointX.add(locationX*50 + 100);
	        	pointX.add(locationX*50 + 50);
	        	pointY.add(locationY*50 + 50);
	       		pointY.add(locationY*50 + 100);
	        	pointY.add(locationY*50 + 150);
		}
		else if(shape == 3&&rotateDegree == 2) {
	        	pointX.add(locationX*50 + 50);
	        	pointX.add(locationX*50 + 100);
	       	 	pointX.add(locationX*50 + 150);
	        	pointY.add(locationY*50 + 50);
	        	pointY.add(locationY*50 + 100);
	        	pointY.add(locationY*50 + 50);
		}
		else if(shape == 3&&rotateDegree == 3) {
	        	pointX.add(locationX*50 + 50);
	        	pointX.add(locationX*50 + 100);
	        	pointX.add(locationX*50 + 100);
	        	pointY.add(locationY*50 + 100);
	        	pointY.add(locationY*50 + 50);
	        	pointY.add(locationY*50 + 150);
		}
		else if(shape == 4&&rotateDegree == 0) {
	        	pointX.add(locationX*50 + 100);
	        	pointX.add(locationX*50 + 50);
	        	pointX.add(locationX*50 + 100);
	        	pointX.add(locationX*50 + 150);
	        	pointY.add(locationY*50 + 50);
	        	pointY.add(locationY*50 + 100);
	        	pointY.add(locationY*50 + 150);
	        	pointY.add(locationY*50 + 100);
		}
		else if(shape == 5&&rotateDegree == 0) {
	        pointX.add(locationX*50 + 50);
	        pointX.add(locationX*50 + 100);
	        pointX.add(locationX*50 + 200);
	        pointX.add(locationX*50 + 150);
	        pointY.add(locationY*50 + 100);
	        pointY.add(locationY*50 + 50);
	        pointY.add(locationY*50 + 50);
	        pointY.add(locationY*50 + 100);
		}
		else if(shape == 5&&rotateDegree == 1) {
	        pointX.add(locationX*50 + 50);
	        pointX.add(locationX*50 + 50);
	        pointX.add(locationX*50 + 100);
	        pointX.add(locationX*50 + 100);
	        pointY.add(locationY*50 + 50);
	        pointY.add(locationY*50 + 150);
	        pointY.add(locationY*50 + 200);
	        pointY.add(locationY*50 + 100);
		}
		else if(shape == 5&&rotateDegree == 2) {
	        pointX.add(locationX*50 + 50);
	        pointX.add(locationX*50 + 150);
	        pointX.add(locationX*50 + 200);
	        pointX.add(locationX*50 + 100);
	        pointY.add(locationY*50 + 50);
	        pointY.add(locationY*50 + 50);
	        pointY.add(locationY*50 + 100);
	        pointY.add(locationY*50 + 100);
		}
		else if(shape == 5&&rotateDegree == 3) {
	        pointX.add(locationX*50 + 100);
	        pointX.add(locationX*50 + 100);
	        pointX.add(locationX*50 + 50);
	        pointX.add(locationX*50 + 50);
	        pointY.add(locationY*50 + 50);
	        pointY.add(locationY*50 + 150);
	        pointY.add(locationY*50 + 200);
	        pointY.add(locationY*50 + 100);
		}
		else {
			//error
		}
	}
	

}
