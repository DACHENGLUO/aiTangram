package tangram;
import java.util.ArrayList;
import java.util.List;

public class Data {
	public List<int[][]> targetList;

	private int[][] target1= {{0,0,0,14,11,0,0,0},
			                 {0,0,14,23,27,11,0,0},
			                 {0,14,23,27,23,27,11,0},
			                 {14,23,27,23,27,23,27,11}};

	private int[][] target2= {{23,27,23,27},
		                     {27,23,27,23},
		                     {23,27,23,27},
		                     {27,23,27,23}};

	private int[][] target3= {{0,0,0,14,11,0},
			                {0,0,14,23,27,11},
			                {0,14,23,27,23,13},
			                {14,23,27,23,13,0},
			                {12,27,23,13,0,0},
			                {0,12,13,0,0,0}};

	private int[][] target4= {{0,0,0,14,23,27,23,13},	
			                {0,0,14,23,27,23,13,0},
			                {0,14,23,27,23,13,0,0},
			                {14,23,27,23,13,0,0,0}};

	private int[][] target5= {{0,14,23,27,23,13},	
			                {14,23,27,23,13,0},
			                {23,27,23,13,0,0},
			                {27,23,13,0,0,0},
			                {23,13,0,0,0,0},
			                {13,0,0,0,0,0}};

	private int[][] target6= {{0,0,14,11,0},
		                    {0,14,23,27,11},
                            {14,23,27,23,13},
	         	            {23,27,23,13,0},
			                {27,23,13,0,0},
			                {23,13,0,0,0},
		                    {13,0,0,0,0}};

	private int[][] target7= {{23,27,11,0,0,0},
	      		           {27,23,27,11,0,0},
			               {23,27,23,27,11,0},
			               {27,23,27,23,27,11}};

	private int[][] target8= {{0,0,14,23,27,23,27},
			                {0,14,23,27,23,27,23},
		                    {14,23,27,23,27,23,13}};

	private int[][] target9= {{23,27,23,27,11},
 			                {27,23,27,23,13},
	       	       	        {23,27,23,13,0},
			                {27,23,13,0,0},
		                    {12,13,0,0,0}};

	private int[][] target10= {{0,14,23,27,11,0},
		                     {14,23,27,23,27,11},
		                     {12,27,23,27,23,13},
		                     {0,12,27,23,13,0}};

	private int[][] target11= {{0,14,23,27,23,27,11},
			                 {14,23,27,23,27,23,13},
	        	             {12,27,23,27,23,13,0}};	

	private int[][] target12= {{14,23,27,11,0},
		                  {23,27,23,27,11},
		                  {27,23,27,23,13},
		                  {12,27,23,13,0},
		                  {0,12,13,0,0}};

	private int[][] target13= {{0,0,14,23,27},
			                 {0,14,23,27,23},
	         	             {14,23,27,23,13},
			                 {23,27,23,13,0},
	        	             {27,23,13,0,0}};
	
	
	

   
   
	
	public  int[] sizeY = {4,4,6,4,6,7,4,3,5,4,3,5,5};
	public  int[] sizeX = {8,4,6,8,6,5,6,7,5,6,7,5,5};
    public  int[][] LT = {{0,14,11,0},
		                  {14,23,27,11}};

    public  int[][] MT = {{0,14},
		                  {14,23}};	

    public  int[][] ST = {{14,11}};

    public  int[][] SQ = {{14,11},
	              {12,13}};

    public  int[][] PA = {{14,23,13}};
	
	public Data() {
		targetList = new ArrayList<>();
		targetList.add(target1);
		targetList.add(target2);
		targetList.add(target3);
		targetList.add(target4);
		targetList.add(target5);
		targetList.add(target6);
		targetList.add(target7);
		targetList.add(target8);
		targetList.add(target9);
		targetList.add(target10);
		targetList.add(target11);
		targetList.add(target12);
		targetList.add(target13);
		
		
	}
	
}