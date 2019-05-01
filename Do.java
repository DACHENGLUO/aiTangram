package tangram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Do {

	private Data data1 = new Data();
	
	private List<int[][]> states;
	private int[][] currentTarget;
	
	private int statesSizeX;
	private int statesSizeY;
	private int totalStatesCount =0;                 // states data
	
	
	
	public Tangrams[] tangrams = new Tangrams[7];
	
	private int Yshift[] = new int[7];
	private int Xshift[] = new int[7];
	private int putType[] = new int[7];
	private int tangramsCount=0;                    // tangrams data
	
	TangramFigures tangramsFigures ;
	
	public Do() {
		tangrams[0] = new Tangrams(data1.LT);
		tangrams[1] = new Tangrams(data1.LT);
		tangrams[2] = new Tangrams(data1.MT);
		
		tangrams[3] = new Tangrams(data1.SQ);
		tangrams[4] = new Tangrams(data1.PA);
		tangrams[5] = new Tangrams(data1.ST);
		tangrams[6] = new Tangrams(data1.ST);
		
		tangrams[0].shape = 1;
		tangrams[1].shape = 1;
		tangrams[2].shape = 2;
		tangrams[3].shape = 4;
		tangrams[4].shape = 5;
		tangrams[5].shape = 3;
		tangrams[6].shape = 3;
		states  = new ArrayList<>();
	}
	
	public void DFSFindingAllWays(int targetNumber) {
		
	}
	public void DFS(int targetNumber, boolean multiply) {
		statesSizeX = data1.sizeX[targetNumber];
		statesSizeY = data1.sizeY[targetNumber];
		currentTarget = data1.targetList.get(targetNumber);
		states.add(new int[statesSizeY][statesSizeX]);
		tangramsFigures = new TangramFigures();
		if(multiply) {
			DFSForAllfigures();
		}
		else {
			DFSForOnefigure();
		}
	}
	
	private void DFSForAllfigures() {
		 
		
		while(totalStatesCount<500) {//not go to target state
			
			if(putATangram()) {          //put a tangram .
				//put a tangram success.
				tangramsCount++;
				
			}
			else {
				states.remove(tangramsCount);
				Xshift[tangramsCount] = 0;
				Yshift[tangramsCount] = 0;
				putType[tangramsCount] = 0;
				tangramsCount--;
				if(tangramsCount>=0) {
					Xshift[tangramsCount]++;
					//take away a tangram(back to before state)
				}
				else {                  //take fail(no state can back)
					System.out.println("sorry,can not get more graphic!");
					break;
				}
			}
			if(equal(states.get(tangramsCount),currentTarget)) {
				totalStatesCount++;
				printGraphics();
				
				setTangramsLocation();
				printLocationAndOrentation();
				for(int i=0;i<7;i++) {
					tangrams[i].pointX.clear();
					tangrams[i].pointY.clear();
				}
				for(int i=0;i<7;i++) {
					tangrams[i].setXY();
				}
				tangramsFigures.setTangrams(tangrams);
				
				states.remove(tangramsCount);
				tangramsCount--;
				
				states.remove(tangramsCount);
				Xshift[tangramsCount] = 0;
				Yshift[tangramsCount] = 0;
				putType[tangramsCount] = 0;
				tangramsCount--;

				
				if(tangramsCount>=0) {
					Xshift[tangramsCount]++;
					//take away a tangram(back to before state)
				}
				else {                  //take fail(no state can back)
					System.out.println("sorry,can not get more graphic!");
					break;
				}
			}
			else {
				totalStatesCount++;
				printGraphics();
			}
		}
	
	}
	
	
	
	 private void DFSForOnefigure() {
		while(!equal(states.get(tangramsCount),currentTarget)) {//not go to target state
			
			if(putATangram()) {          //put a tangram .
				//put a tangram success.
				tangramsCount++;
			}
			else {
				states.remove(tangramsCount);
				Xshift[tangramsCount] = 0;
				Yshift[tangramsCount] = 0;
				putType[tangramsCount] = 0;
				tangramsCount--;
				if(tangramsCount>=0) {
					Xshift[tangramsCount]++;
					//take away a tangram(back to before state)
				}
				else {                  //take fail(no state can back)
					System.out.println("sorry,can not get more graphic!");
					break;
				}
			}
			totalStatesCount++;
			printGraphics();
		}
		setTangramsLocation();
		printLocationAndOrentation();
		for(int i=0;i<7;i++) {
			tangrams[i].setXY();
		}
		tangramsFigures.setTangrams(tangrams);
	
	}
	 
	 
	 
	private boolean putATangram() {
		boolean putSuccess =false;
		while(putType[tangramsCount]<4){
			if(putOneOrentation()) {
				putSuccess = true;
				break;
			}
			else {
				putType[tangramsCount]++;
				Xshift[tangramsCount] = 0;
				Yshift[tangramsCount] = 0;
			}
		}
		return putSuccess;
		
	}
	
	private boolean putOneOrentation() {
		boolean success =false;
		int orentation = putType[tangramsCount];
		int[][] tempTangram = tangrams[tangramsCount].rotateContent.get(orentation);
		int tangramSizeY = tangrams[tangramsCount].rotateContent.get(orentation).length;
		int tangramSizeX = tangrams[tangramsCount].rotateContent.get(orentation)[0].length;
		label1:
			for(int i =Yshift[tangramsCount];i<=statesSizeY-tangramSizeY;i++) {
				for(int j =0;j<=statesSizeY-tangramSizeX;j++) {
					if(i>Yshift[tangramsCount]||j>=Xshift[tangramsCount]) {
						if(match(states.get(tangramsCount),tempTangram,j,i)) {
							Yshift[tangramsCount]=i;
							Xshift[tangramsCount]=j;
							adder(tempTangram);
							success = true;
							break label1;
						}
					}
					
				}
			}
		
		return success;
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
		int[][] tempState = new int[statesSizeY][statesSizeX];
		for(int i=0;i<statesSizeY;i++) {
			for(int j=0;j<statesSizeX;j++) {
				tempState[i][j] = states.get(tangramsCount)[i][j];
			}
		}
		for(int i =0;i<pieces.length;i++) {
			for(int j =0;j<pieces[0].length;j++) {
				tempState[i+Yshift[tangramsCount]][j+Xshift[tangramsCount]] += pieces[i][j];
			}
		}
		states.add(tempState);
	}
	private void setTangramsLocation() {
		for(int i =0 ;i<7;i++) {
			tangrams[i].locationX = Xshift[i];
			tangrams[i].locationY = Yshift[i];
			tangrams[i].rotateDegree =putType[i];
		}
	}
	private void printLocationAndOrentation() {
		
		for(int i =0 ;i<7;i++) {
			System.out.println("\n\ntangram number: "+i+"    location X: " + tangrams[i].locationX+"    location Y: "+tangrams[i].locationY+"    Orentation: "+tangrams[i].rotateDegree+"\n");
		}
	}
	private void printGraphics() {
		System.out.println("tangramsCount: "+tangramsCount);
		System.out.println("totalCount: "+totalStatesCount);
		for(int i =0;i<statesSizeY;i++) {
			for(int j =0;j<statesSizeX;j++) {
				System.out.print(states.get(tangramsCount)[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	private boolean equal(int[][] a,int[][] b) {
		boolean temp = true;
		label1:
		for(int i = 0;i<statesSizeY;i++) {
			for(int j=0;j<statesSizeX;j++) {
				if(a[i][j] != b[i][j]) {
					temp = false;
					break label1;
				}
			}
		}
		return temp;
	}
	
}
