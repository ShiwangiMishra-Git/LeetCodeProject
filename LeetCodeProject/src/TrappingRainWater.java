
public class TrappingRainWater {

	public TrappingRainWater() {
		// TODO Auto-generated constructor stub
		
			}
	
	public int trap(int[] height) {
		
		int water = 0;
		
		int left=0;
		int right=height.length-1;
		
		int leftmax=height[left];
		int rightmax=height[right];
		
	if(height.length>2)
	{
		while(left<right) {
			
		}
		
				if(Math.min(height[leftmax],height[rightmax])<height[left])
				{
					return water;
				}
				else {
					water+= height[left]-(Math.min(height[leftmax],height[rightmax]));
				}
			
		
	}
	else {
		return 0;
	}
	
			
        
		
		return water;
    }


}
