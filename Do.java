package tangram;

public class Do {

	private Data data1 = new Data();
	private int[][][] states  = new int[8][4][4];
	private int Yshift[] = new int[7];
	private int Xshift[] = new int[7];
	private int[][] currentTarget = data1.target2;
	private int[][] pieces = data1.LT;
	
	private int statesCount=0;
	
	public void DFS() {
		while(states[statesCount]!= currentTarget) {//not go to target state
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
			
		}
	}
	private boolean putATangram() {
		boolean putsuccess =false;
		label1:
		for(int i =0;i<=states[statesCount].length-pieces.length;i++) {
			for(int j =0;j<=states[statesCount][0].length-pieces[0].length;j++) {
				if(match(states[statesCount],pieces,j,i)) {
					Yshift[statesCount]=i;
					Xshift[statesCount]=j;
					adder();
					System.out.println("statesCount: "+statesCount);
					printGraphics();
					putsuccess = true;
					break label1;
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
	private void adder() {
		states[statesCount+1] = states[statesCount];
		for(int i =0;i<pieces.length;i++) {
			for(int j =0;j<pieces[0].length;j++) {
				states[statesCount+1][i+Yshift[statesCount]][j+Xshift[statesCount]] += pieces[i][j];
			}
		}
		statesCount++;
	}
	
	private void printGraphics() {
		for(int i =0;i<states[statesCount].length;i++) {
			for(int j =0;j<states[statesCount][0].length;j++) {
				System.out.print(states[statesCount][i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
}
