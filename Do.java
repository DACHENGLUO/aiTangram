package tangram;

public class Do {

	private Data data1 = new Data();
	private int[][][] states  = new int[8][4][4];
	private int Yshift[] = new int[7];
	private int Xshift[] = new int[7];
	private int[][] currentTarget = data1.target2;
	private Tangrams[] tangrams = new Tangrams[7];

	
	private int statesCount=0;
	public Do() {
		tangrams[0] = new Tangrams(data1.LT);
		tangrams[1] = new Tangrams(data1.LT);
		tangrams[2] = new Tangrams(data1.MT);
		tangrams[3] = new Tangrams(data1.ST);
		tangrams[4] = new Tangrams(data1.ST);
		tangrams[5] = new Tangrams(data1.SQ);
		tangrams[6] = new Tangrams(data1.PA);
	}
	
	public void DFS() {
		while(!equal(states[statesCount],currentTarget,4,4)) {//not go to target state
			if(putATangram()) {          //put a tangram with a new way.
				//put a tangram success.
			}
			else {
				
				if((statesCount--)>0) {
					
					//take away a tangram(back to before state)
				}
				else {                  //take fail(no state can back)
					System.out.println("sorry,can not get this graphic!");
					break;
				}
			}
			printGraphics();
		}
	}
	private boolean putATangram() {
		boolean putsuccess =false;
		
		label1:
			for(int i =0;i<=states[statesCount].length-tangrams[statesCount].rotateContent0.length;i++) {
				for(int j =0;j<=states[statesCount][0].length-tangrams[statesCount].rotateContent0[0].length;j++) {
					if(match(states[statesCount],tangrams[statesCount].rotateContent0,j,i)) {
						Yshift[statesCount]=i;
						Xshift[statesCount]=j;
						adder(tangrams[statesCount].rotateContent0);
						
						putsuccess = true;
						break label1;
					}
					
				}
			}
		
		if(putsuccess ==false) {
			label2:
				for(int i =0;i<=states[statesCount].length-tangrams[statesCount].rotateContent1.length;i++) {
					for(int j =0;j<=states[statesCount][0].length-tangrams[statesCount].rotateContent1[0].length;j++) {
						if(match(states[statesCount],tangrams[statesCount].rotateContent1,j,i)) {
							Yshift[statesCount]=i;
							Xshift[statesCount]=j;
							adder(tangrams[statesCount].rotateContent1);
							System.out.println("statesCount: "+statesCount);
							
							putsuccess = true;
							break label2;
						}
						
					}
				}
		}
		
		if(putsuccess ==false) {
		label3:
			for(int i =0;i<=states[statesCount].length-tangrams[statesCount].rotateContent2.length;i++) {
				for(int j =0;j<=states[statesCount][0].length-tangrams[statesCount].rotateContent2[0].length;j++) {
					if(match(states[statesCount],tangrams[statesCount].rotateContent2,j,i)) {
						Yshift[statesCount]=i;
						Xshift[statesCount]=j;
						adder(tangrams[statesCount].rotateContent2);
						System.out.println("statesCount: "+statesCount);
						
						putsuccess = true;
						break label3;
					}
					
				}
			}
		}
		if(putsuccess == false) {
			label4:
				for(int i =0;i<=states[statesCount].length-tangrams[statesCount].rotateContent3.length;i++) {
					for(int j =0;j<=states[statesCount][0].length-tangrams[statesCount].rotateContent3[0].length;j++) {
						if(match(states[statesCount],tangrams[statesCount].rotateContent3,j,i)) {
							Yshift[statesCount]=i;
							Xshift[statesCount]=j;
							adder(tangrams[statesCount].rotateContent3);
							System.out.println("statesCount: "+statesCount);
						
							putsuccess = true;
							break label4;
						}
						
					}
				}
		}
		return putsuccess;
		
	}
	
	private boolean match(int[][] currentState,int[][] pieces,int x,int y) {
		int tempPixel ;
		for(int i =0;i<pieces.length;i++) {
			for(int j =0;j<pieces[0].length;j++) {
				tempPixel = currentState[i+y][j+x]+pieces[i][j];
				if(currentTarget[i+y][j+x] != tempPixel&&!(ispart(currentTarget[i+y][j+x],tempPixel))) {
					return false;
				}
			}
		}
		return true;
	}
	private boolean ispart(int i,int j) {
		if(i==23&&(j==11||j==12||j==0)) return true;
		if(i==27&&(j==13||j==14||j==0)) return true;
		return false;
	}
	private void adder(int[][] pieces) {
		states[statesCount+1] = states[statesCount];
		for(int i =0;i<pieces.length;i++) {
			for(int j =0;j<pieces[0].length;j++) {
				states[statesCount+1][i+Yshift[statesCount]][j+Xshift[statesCount]] += pieces[i][j];
			}
		}
		statesCount++;
	}
	
	private void printGraphics() {
		System.out.println("statesCount: "+statesCount);
		for(int i =0;i<states[statesCount].length;i++) {
			for(int j =0;j<states[statesCount][0].length;j++) {
				System.out.print(states[statesCount][i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	private boolean equal(int[][] a,int[][] b,int x,int y) {
		boolean temp = true;
		label1:
		for(int i = 0;i<y;i++) {
			for(int j=0;j<x;j++) {
				if(a[i][j] != b[i][j]) {
					temp = false;
					break label1;
				}
			}
		}
		return temp;
	}
}
