
public class CountSubsetsSumWithGivenSum {

	public CountSubsetsSumWithGivenSum() {
		// TODO Auto-generated constructor stub
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new CountSubsetsSumWithGivenSum().countSubset(new int[] {3,2,2,5,6,7}, 10));

	}
	public int countSubset(int[] nums, int target)
	{
		 int[][] dp=new int[nums.length+1][target+1];
	        
	        //initialization
	        int count=0;
	        
	        for(int i=0;i<=nums.length;i++)
	        {
	           dp[i][0]=1; 
	        }
	        
	        for(int j=1;j<=target;j++)
	            {
	             dp[0][j]=0;
	            }
	        
	        for(int i=1;i<=nums.length;i++)
	        {
	           for(int j=1;j<=target;j++)
	            {
	             if(nums[i-1]>j)
	             {
	                 //exclude nums[i]
	                   dp[i][j]=dp[i-1][j];
	             }
	               else{
	                   
	                       //include nums[i]   //exclude nums[i]
	             dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
	                   
	               }
	            }
	        }
	        
	        for(int i=0;i<=nums.length;i++)
	        {
	           for(int j=0;j<=target;j++)
	            {
	        	   System.out.print(dp[i][j]+ " ");
	        	}
	           System.out.println();
	        }
	        
	        return dp[nums.length][target];
	}

}
