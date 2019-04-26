package tangram;

public class Tangrams {

	private int locationX;
	private int locationY;
	private int[][] rotateContent0;
	private int[][] rotateContent1;
	private int[][] rotateContent2;
	private int[][] rotateContent3;
	private int rotateDegree;
	public Tangrams(int[][] rotateContent0) {
		this.locationX = 0;
		this.locationY = 0;
		this.rotateDegree = 0;
		this.rotateContent0 = rotateContent0;
		this.rotateContent1 = new int[rotateContent0[0].length][rotateContent0.length];
		this.rotateContent2 = new int[rotateContent0.length][rotateContent0[0].length];
		this.rotateContent3 = new int[rotateContent0[0].length][rotateContent0.length];
		
		
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
		
		
	}
	
	
	public void prointRotateContent() {
		for(int i =0;i<rotateContent0.length;i++) {
			for(int j =0;j<rotateContent0[0].length;j++) {
				System.out.print(rotateContent0[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
		
		for(int i =0;i<rotateContent1.length;i++) {
			for(int j =0;j<rotateContent1[0].length;j++) {
				System.out.print(rotateContent1[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
		
		for(int i =0;i<rotateContent2.length;i++) {
			for(int j =0;j<rotateContent2[0].length;j++) {
				System.out.print(rotateContent2[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
		
		for(int i =0;i<rotateContent3.length;i++) {
			for(int j =0;j<rotateContent3[0].length;j++) {
				System.out.print(rotateContent3[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
	}

}
