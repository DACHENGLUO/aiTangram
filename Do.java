package tangram;

public class Do {

	private Data data1 = new Data();
	private int[][][] states  = new int[8][4][4];
	private int Yshift[] = new int[7];
	private int Xshift[] = new int[7];
	private int putType[] = new int[7];
	private int[][] currentTarget = data1.target2;
	private Tangrams[] tangrams = new Tangrams[7];
	private int totalCount =0;

	
	private int statesCount=0;
	public Do() {
		tangrams[0] = new Tangrams(data1.LT);
		tangrams[1] = new Tangrams(data1.LT);
		tangrams[2] = new Tangrams(data1.MT);
		tangrams[3] = new Tangrams(data1.ST);
		tangrams[4] = new Tangrams(data1.ST);
		tangrams[5] = new Tangrams(data1.SQ);
		tangrams[6] = new Tangrams(data1.PA);
		for(int i=0;i<Xshift.length;i++) {
			Xshift[i] = -1;
		}
	}
	
	public void DFS() {
		while(!equal(states[statesCount],currentTarget,4,4)) {//not go to target state
			if(putATangram()) {          //put a tangram with a new way.
				//put a tangram success.
				statesCount++;
			}
			else {
				Xshift[statesCount] = -1;
				Yshift[statesCount] = 0;
				putType[statesCount] = 0;
				statesCount--;
				if(statesCount>=0) {
					
					//take away a tangram(back to before state)
				}
				else {                  //take fail(no state can back)
					System.out.println("sorry,can not get this graphic!");
					break;
				}
			}
			totalCount++;
			printGraphics();
		}
		printLocationAndOrientation();
	}
	private boolean putATangram() {
		boolean putSuccess =false;
		while(putType[statesCount]<4){
			if(putOneOrientation()) {
				putSuccess = true;
				break;
			}
			else {
				putType[statesCount]++;
				Xshift[statesCount] = -1;
				Yshift[statesCount] = 0;
			}
		}
		return putSuccess;
		
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
		for(int i=0;i<states[statesCount].length;i++) {
			for(int j=0;j<states[statesCount][0].length;j++) {
				states[statesCount+1][i][j] = states[statesCount][i][j];
			}
		}
		for(int i =0;i<pieces.length;i++) {
			for(int j =0;j<pieces[0].length;j++) {
				states[statesCount+1][i+Yshift[statesCount]][j+Xshift[statesCount]] += pieces[i][j];
			}
		}
		
	}
	
	private void printLocationAndOrientation() {
		
		for(int i =0 ;i<7;i++) {
			System.out.println("\n\ntangram number: "+i+"    location X: " + Xshift[i]+"    location Y: "+Yshift[i]+"    Orientation: "+putType[i]+"\n");
		}
	}
	private void printGraphics() {
		System.out.println("statesCount: "+statesCount);
		System.out.println("totalCount: "+totalCount);
		if(statesCount==0) {
			System.out.println("------------------------------------------------------------");
		}
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
	private boolean putOneOrientation() {
		boolean success =false;
		int orientation = putType[statesCount];
		int[][] temp = tangrams[statesCount].rotateContent.get(orientation);
		label1:
			for(int i =Yshift[statesCount];i<=states[statesCount].length-temp.length;i++) {
				for(int j =Xshift[statesCount]+1;j<=states[statesCount][0].length-temp[0].length;j++) {
					if(match(states[statesCount],temp,j,i)) {
						Yshift[statesCount]=i;
						Xshift[statesCount]=j;
						adder(temp);
						
						success = true;
						break label1;
					}
					
				}
			}
		
		return success;
	}
}
