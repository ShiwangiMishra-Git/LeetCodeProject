
public class RobotBoundedInCircle1041 {

	public RobotBoundedInCircle1041() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//for robot to come to the origin either -
		//1: it comes back to (0,0) after a cycle.
		//2: or after one cycle - it should be facing  direction other than north 
		//because if it facing north (0 degree movement) it will never come back to origin it will always go straight 
		
		//go through the path for one cycle
		//directions         
				//0- n(0,1),1- e(1,0),2- s(0,-1),3- w(-1,0)
		//if it gets "G": this array has coordinate changes if robot moves (G) in that direction
		//if it gets "L" : next direction (d+3)%4 => eg: 0->3, 1->0, 2->1, 3->2
		//if it gets "R" : next direction (d+1)%4 => eg: 0->1, 1->2, 2->3, 3->0
        //time: O(n): instructions array size
		//space: O(1): since directions is fixed size
	}
	
	 public boolean isRobotBounded(String instructions) {	 
		boolean isBounded = false;
		 
		//directions
		//0- n(0,1),1- e(1,0),2- s(0,-1),3- w(-1,0)
		
		
		//this array has coordinate changes if robot moves (G) in that direction
		int[][] directions=new int[][] 
           {{0,1},
			{1,0},
			{0,-1},
			{-1,0}};
			
	//initial direction is north
	  int dir=0;
	  int x=0; int y=0;
	//check for one cycle		
	for(char step: instructions.toCharArray())
	{
		if(step=='L')
		{
			//change direction
		    dir=(dir+3)%4;
		}
		else {
			if(step=='R')
			{
				//change direction
				dir=(dir+1)%4;
			}
			else{
				//move
				x=x+directions[dir][0];
				y=y+directions[dir][1];	
			}
		}	
	}
	        //1: it comes back to (0,0) after a cycle.
			//2: or after one cycle - it should be facing  direction other than north 
		if((x==0 && y==0)||!(dir==0))
		{
			isBounded=true;
		}
		return isBounded;
	 }

}
