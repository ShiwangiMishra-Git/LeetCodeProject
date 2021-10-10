
public class ContainerWithMostWater {

	public ContainerWithMostWater() {
		// TODO Auto-generated constructor stub
	}
	
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
