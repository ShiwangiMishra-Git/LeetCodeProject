import java.util.Arrays;

public class MinimumSubsetSumDifference {

	public MinimumSubsetSumDifference() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new MinimumSubsetSumDifference().minDiffSubsetSum(new int[] { 3, 1, 4, 2, 2, 1 }));

	}
	
	public int minDiffSubsetSum(int[] nums)
	{
		//max sum of a part
		int sum=(int) Math.ceil(Arrays.stream(nums).sum());
		int sumpart=(int)sum/2;
		
		//result will be sum-sumpart
		int capacity=sumpart; //j
		boolean[][] dp=new boolean[nums.length+1][capacity+1];
		
		for(int i=0;i<=nums.length;i++)
		{
			dp[i][0]=true;
		}
		for(int j=1;j<=capacity;j++)
		{
			dp[0][j]=false;
		}
		
		for(int i=1;i<=nums.length;i++)
		{
			for(int j=1;j<=capacity;j++)
			{
				if(nums[i-1]<j)
				{
					//include
					dp[i][j]= dp[i-1][j-nums[i-1]] || dp[i-1][j];
				}
				
				else
				{
					dp[i][j]= dp[i-1][j];
					//exclude
					
				}
			}	
		}
		
		for(int j=capacity;j>0;j--)
		{
			if(dp[nums.length][j])
			{
				sumpart=j;
				break;
			}
		}
		System.out.println(sumpart);

		
		return Math.abs((sum-sumpart)-sumpart);
		
	}

}
