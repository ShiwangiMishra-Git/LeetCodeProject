

public class ContainerWithMostWater {

	public ContainerWithMostWater() {
		// TODO Auto-generated constructor stub
	}

	//scan the whole array using two pointers, one pointer from left and other from right.
	//to maximize the water we can either increase height or width.
	// in this case if we move one step horizontally decrease in width will be negligible by the amount of trapped water by the increased height delta of water.
	// first intiate the pointer , then condition to move the pointer is if move left pointer to right if left is lower else right pointer to left. 
	// after each movement calculate the trapped water = min(heightleft,heightright)*(right-left) if it is more than max water contained then update.
public static int maxArea(int[] height) {
        
        int left=0;
        int right=height.length-1;
        int maxwater=0;
            
  
            while(left<right)
            {
                int water=Math.min(height[right],height[left])*(right-left);
                if(water>maxwater)
                    maxwater=water;
            if(height[right]>height[left])
            {
              left++;
            }
                else{
                    right--;
                }
                
            }
        
        return maxwater;     
    }

public static void main(String[] args)
{
	int[] arr = {4,3,2,1,4};
	System.out.println(maxArea(arr));
	}

}
