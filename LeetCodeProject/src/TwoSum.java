import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
    	
    	int[] res=new int[] {-1,-1};
    	
    	
    	Map<Integer,Integer> m1=new HashMap();
    	
    	for(int i=0;i<nums.length;i++)
    	{
       if(m1.containsKey(nums[i]))
       {
    	  int compInt=m1.get(nums[i]);
    	   res= new int[]{i,compInt};
       }
       else {
    	   m1.put(target-nums[i],i);
       }
    	}  
    	
    	return res;
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] res=new Solution1().twoSum(new int[] {2,7,11,15},26);
		for(int i=0;i<res.length;i++)
		{
			System.out.println(res[i]);
		}
		

	}

}
