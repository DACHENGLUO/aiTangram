package tangram;

public class Data {

	public int[][] target2= {{23,27,23,27},
			                 {27,23,27,23},
			                 {23,27,23,27},
			                 {27,23,27,23}};
	
	public  int[][] initalState2 = new int[4][4];
	
	public  int[][] LT = {{0,14,11,0},
			      {14,23,27,11}};
	
	public  int[][] MT = {{0,14},
			      {14,23}};	
	
	public  int[][] ST = {{14,11}};
	
	public  int[][] SQ = {{14,11},
		              {12,13}};

	public  int[][] PA = {{14,23,13}};
	
}
