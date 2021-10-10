import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PourWater {

	public PourWater() {
		// TODO Auto-generated constructor stub
	}
	//Total time complexity O(nv)
	//space complexity O((size of int in array).n (size of array)+3*size of int = O(n)
	//drop will settle as near as possible to the drop point at both end - first it will try to travel as much left as possible then as much right as possible
	//and at last it will try to move left towards the drop point as far  
	
	//1- start from k move left till height is same as previous height or lower
	//2- After reaching till end as far height is same or lower at left, start moving right till height in curr(left) is higher or equal to right(curr+1)  (only extreme till end length)
	//3-at last drop will try to move back to drop point and stop if it gets the drop point or any place before drop point where left point (curr-1) has height higher than (right)curr
	 public  int[] pourWater(int[] heights, int volume, int k) {
		 
		 for(int i=volume;i>0;i--) // O(V)
		 {
			 
		 int curr=k;
		 ///left
		 //move left untill 
		 while(curr>0 && heights[curr]>=heights[curr-1]) //O(n) n is length of heights
		 {
			 curr--;
		 }
		 
		//right
		 while(curr<heights.length-1 && heights[curr]>=heights[curr+1]) //O(n)
		 {
			 curr++;
		 }
		  
		 //Right to K
		 while(curr>k && heights[curr-1]<=heights[curr]) //O(n)
		 {
			 curr--;
		 }	
		 
		 heights[curr]++;
		 }
		 return heights;
	    }
	 
	 
	 public static void main(String[] args)
	 {
	 	//int[] heights = {2,1,1,2,1,2,2};
	 	//int volume=4;
	 	//int k=3;
		int[] result= new PourWater().pourWater(new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1},10,2);
		List<Integer> l=Arrays.stream(result).boxed().collect(Collectors.toList());
		for(Integer i:l)
		{
			System.out.println(i);
		}
	 	
	 	

	 }

	 
	

}
