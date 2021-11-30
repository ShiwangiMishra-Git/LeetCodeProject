import java.util.Collections;
import java.util.PriorityQueue;

public class minRefuelStopsLC871 {

	public minRefuelStopsLC871() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minRefuelStops(100,1,
				new int[][] {{10,100}}));

	}
	
	 public static int minRefuelStops(int target, int startFuel, int[][] stations) {
		 
		 
		 
/*
		
		//Using DP //for 
		//we need to go through all the stations and record the max distance we can travel if we fuel at that station 
		//At last we will see which was the fist station after fueling there we were able to reach to the target distance and that would be our result.
		// Time : O(n^2) two for loops
		// Space:O(n)
		
		int[] DP=new int[stations.length+1];
		
		DP[0]=startFuel;
		if(DP[0]>=target)
		{
			return 0;
		}
		for(int i=1;i<DP.length;i++)
		{
			int j=i-1;
			while(j>=0)
			{
			  if(stations[i-1][0]<=DP[j]) // if we can reach to this station from jth station DP[j] is the max distacne we can travel from j and ith station should be reachable from j to be used in refueling.
			  {
			   DP[i] = Math.max(DP[i],stations[i-1][1]+DP[j]);
			  }
			   j--;
			}
			if(DP[i]>=target)
			{
				return i;
			}
		}
		return -1;
		
		
		*/
		
		
		//Using Greedy
		
		//We can use heap(ordered complete BT) to reduce Time complexity to O(nlogn) where logn is the max height of tree
		//at each stop either we can refuel or not - we have to refuel in the last maxfuel stop if this stop is unreachable with current fuel
		//instead just go through whole stations array once.
		//save it in the heap (priority queue) and  while going through this array when the fuel is (negative) go back and refill the fuel, and increase the count by one and update the fuel and keep on going until the fuel is negative again 
		//this way we don't have to check, and update the max distance traveled from the station by going back all the stations prior to this and stop at the fist station which reaches target value.
		
		//Time : O(nlogn) one for loops and one priority queue (add and poll)
		//extra space: O(n) //where n is number of stations, PQ size

	    int minStops =0;
		PriorityQueue<Integer> pq=new PriorityQueue<Integer> (Collections.reverseOrder());
		int fuelinhand=startFuel;
		int distancetraveled=0;
		for(int i=0;i<=stations.length;i++)
		{
			int location=stations[i][0];
			int capacity=stations[i][1];
			fuelinhand-=(location-distancetraveled);

			//if fuel got over and this location can't be reached
			while(fuelinhand<0 && !pq.isEmpty())
			{
				int maxfuel=pq.poll(); //O(logn) //refuel
				fuelinhand=fuelinhand+maxfuel; //fuel in hand updated
				minStops++; //add used stops
			}
			
			if(fuelinhand<0 && pq.isEmpty())
			{
				return -1;
			}
			
			//two things we have to do if we can reach this station
			pq.add(capacity);
			distancetraveled=location;
		}
		
		//check with remaining fuel after last station - if we can cover locationoflaststation aka distancetraveled to target
		fuelinhand-=(target-distancetraveled);
		while(fuelinhand<0 && !pq.isEmpty())
		{
			int maxfuel=pq.poll(); //O(logn)
			fuelinhand=fuelinhand+maxfuel;
			minStops++;
		}
		if(fuelinhand<0 && pq.isEmpty())
		{
			return -1;
		}
		
		return minStops;
		
	        
	    }

}
