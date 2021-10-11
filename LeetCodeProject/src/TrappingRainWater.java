
public class TrappingRainWater {

	public TrappingRainWater() {
		// TODO Auto-generated constructor stub

	}

	// brute force
	// from second to second last in the array
	//find left max ,find right max , find out the diff of height[j]-min(left and right) and if it is more than >0
	// add in the collected water.
	//  (Complexity O(n^2))
	public int trap1(int[] height) {

		int water = 0;
		// if height has less than 3
		if (height.length > 2) {
			for (int j = 1; j < height.length - 1; j++) {

				// find left max
				int left = j - 1;
				int right = j + 1;
				int leftmax = 0;
				int rightmax = 0;

				while (left >= 0) {
					leftmax = Math.max(leftmax, height[left]);
					left--;
				}

				// find right max
				while (right <= height.length - 1) {
					rightmax = Math.max(rightmax, height[right]);
					right++;
				}

				// find out the diff of height[j]-min(left and right) and if it is more than >0
				// add in the collected water.
				int watersaved = (Math.min(leftmax, rightmax) - height[j]);
				water += watersaved > 0 ? watersaved : 0;

			}

		}

		return water;
	}

	// dynamic programming (Complexity O(n)) but more space complexity O(n+n)=O(1)
	//saving the left and right max in two arrays (two while loops in the above method will be replaced by two for first loops below )
	public int trap2(int[] height) {

		int water =0;
		
		
		//if height has less than 3
		
		int[] leftmaxarray=new int[height.length-2];
		int[] rightmaxarray=new int[height.length-2];
		if (height.length > 2) {
			leftmaxarray[0]=Math.max(height[1],height[0]);
			rightmaxarray[rightmaxarray.length-1]=Math.max(height[height.length-1],height[height.length-2]);
			
			for (int j = 1; j < leftmaxarray.length; j++) {
				leftmaxarray[j]=Math.max(leftmaxarray[j-1],height[j+1]);
			}
			
            for (int j = rightmaxarray.length-2; j >= 0; j--) {
            	rightmaxarray[j]=Math.max(rightmaxarray[j+1],height[j+1]);
			}
			
			for (int j = 1; j < height.length - 1; j++) {
				
				//find out the diff of height[j]-min(left and right) and if it is more than >0 add in the collected water.
				int watersaved=(Math.min(leftmaxarray[j-1],rightmaxarray[j-1])-height[j]);
				System.out.println("watersaved: "+ watersaved);
				water+= watersaved>0?watersaved:0;

			}

		}

		return water;
	}
	

	// two pointer 
	// O(n), space: O(1) no extra space
	// we keep two pointers left and right to scan the array.
	//while scanning just consider points which you are seeing currently by left and right and past information (leftmax and rightmax)
	// if left pointer has lesser height than right then water will flow from right to left, means it will be limited by leftmax.
	// so calculate the water at left and move the left pointer, left ++
	// if right pointer has lesser height than left then water will flow from left to right, means it will be limited by rightmax.
	// so calculate the water at right and move the right pointer right--
	
	//keep doing until left < right meet (atlest two points to compare)
	public int trap3(int[] height) {
		int left=0;
		int right=height.length-1;
		int leftmax=0;
		int rightmax=0;
		
		int water =0;
		while(left<right)
		{
			leftmax=Math.max(leftmax, height[left]);
			rightmax=Math.max(rightmax, height[right]);
			
			if(height[left]<height[right])
			{
				water+=leftmax-height[left];
				left++;
			}
			else {
				water+=rightmax-height[right];
				right--;
			}	
		}
		return water;
	}
	
	
	

	public static void main(String[] args) {

		System.out.println(new TrappingRainWater().trap3(new int[] {0,1,0,2,1,0,1,3,2,1,2,1 }));

	}

}
