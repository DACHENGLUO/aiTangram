package tangram;



public class Unit {
	private int type;
	private boolean blank = true;
	private int[] xPoints;
	private int[] yPoints;
	private int locationX;
	private int locationY;
	public void setBlank(boolean blank) {
		this.blank = blank;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void  setLocation(int locationX,int locationY) {
		this.locationX = locationX;
		this.locationY = locationY;
	}
	public void setXYPoints() {
		
		if(type == 1) {
			xPoints[0] = locationX*20;
			xPoints[1] = (locationX+1)*20;
			xPoints[2] = locationX*20;
			yPoints[0] = locationY*20;
			yPoints[1] = locationY*20;
			yPoints[2] = (locationY+1)*20;
		}
		else if(type == 2) {
			xPoints[0] = locationX*20;
			xPoints[1] = (locationX+1)*20;
			xPoints[2] = locationX*20;
			yPoints[0] = locationY*20;
			yPoints[1] = (locationY+1)*20;
			yPoints[2] = (locationY+1)*20;
		}
		else if(type == 3) {
			xPoints[0] = locationX*20;
			xPoints[1] = (locationX-1)*20;
			xPoints[2] = locationX*20;
			yPoints[0] = locationY*20;
			yPoints[1] = (locationY+1)*20;
			yPoints[2] = (locationY+1)*20;
		}
		else if(type == 4) {
			xPoints[0] = (locationX-1)*20;
			xPoints[1] = locationX*20;
			xPoints[2] = locationX*20;
			yPoints[0] = locationY*20;
			yPoints[1] = locationY*20;
			yPoints[2] = (locationY+1)*20;
		}
		else {
			xPoints[0] = 0;
			xPoints[1] = 0;
			xPoints[2] = 0;
			yPoints[0] = 0;
			yPoints[1] = 0;
			yPoints[2] = 0;
		}
	}

}
