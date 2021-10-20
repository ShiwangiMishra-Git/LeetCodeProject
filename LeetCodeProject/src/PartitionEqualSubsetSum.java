import java.util.Arrays;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;
public class PartitionEqualSubsetSum {

	public PartitionEqualSubsetSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(new PartitionEqualSubsetSum().canPartition(new int[] {1}));
		
		System.out.println(new PartitionEqualSubsetSum().canPartitionDP(new int[] {1,5,11,5}));

	}
	
	public boolean canpart(int[] nums,int n,int sum,Boolean[][] canpartResultArr)
	{
		if(sum==0)
		{
			return true;
		}
		else {
			if(n>=0)
			{
				if(canpartResultArr[n][sum]!=null)
				{
					return canpartResultArr[n][sum];
				}
				//including
				boolean includingResult=false;
				if(nums[n]<=sum)
				{
				 includingResult=canpart(nums,n-1,sum-nums[n],canpartResultArr) ;
				}
				//not including 
				boolean excludingResult=canpart(nums,n-1,sum,canpartResultArr) ;
				
				//set up memonization 
				canpartResultArr[n][sum]=includingResult|| excludingResult;
				
				return canpartResultArr[n][sum];
			}
			else{
				return false;
			}
		}
	}
	
	
	 public boolean canPartition(int[] nums) {
	        
		// Integer[] arr = IntStream.of(new int[10]).mapToObj(i -> 1).toArray(Integer[]::new);
		// Integer[] arr = IntStream.generate(()->2).limit(10).mapToObj(i->1).toArray(Integer[]::new);
		// Integer[] arr = Arrays.stream(new int[10]).mapToObj(i->10).toArray(Integer[]::new);
		 
	     int sumMax=Arrays.stream(nums).sum(); 
	     int sumT=sumMax%2;
	     int equalSum=sumMax/2;
	     
	  
	     
	     //we need to find a subset with  equalSum if we find one that means another subset is also there with equalSum and equal partition is possible.
	     
	     if(sumT!=0)
	     {
	    	 //odd numbers so equal partition not possible
	    	 return false;
	     }
	     else {
	    	 
	    	//recursion top - down 
	    	//return canpart(nums,nums.length,equalSum);	
	    	
	    	 //recursion top - down  + memonization
	    	   //for each number in the nums array and sum
		       Boolean[][] canpartResultArr=new Boolean[nums.length][equalSum+1];
		       canpartResultArr=Arrays.stream(canpartResultArr).map(b->new Boolean[equalSum+1]).toArray(Boolean[][]::new);
		       
		       
	    	   return canpart(nums,nums.length-1,equalSum,canpartResultArr);	  
	     }
	    }
	    	 
	     
	     //recursion + memonization
	    
	   /* if(sumT!=0)
	     {
	    	 //odd numbers so equal partition not possible
	    	 return false;
	     }
	     else {
	    	 
	    	//recursion top - down 
	    	return canpart(nums,nums.length,equalSum);	    	 
	     }*/
	    	
	 public boolean canPartitionDP(int[] nums) { 
		 
		 int sumMax=Arrays.stream(nums).sum(); 
	     int sumT=sumMax%2;
	     int equalSum=sumMax/2;
	     
	     if(sumT!=0)
	     {
	    	 //odd numbers so equal partition not possible
	    	 return false;
	     }
	     else {
	    	 //DP/Iterartive // bottom - up
	    	 
	    	 //base/initialization: if n==0,sum=0 
		     //sum==0, can be made from any number by not taking it.
	    	 
	    	//i=n
		     //j=sum
		     //when j=0; for all i dp[i][j]=true;
		     //when i=0; for all j>0 dp[i][j]=false;
	    	 Boolean[][] canpartResultArr=new Boolean[nums.length+1][equalSum+1];
	    	 for(int i=0;i<canpartResultArr.length;i++)
	    	 {
	    		canpartResultArr[i][0]=true;
	    	 }
	    	 for(int j=1;j<canpartResultArr[0].length;j++)
	    	 {
	    		canpartResultArr[0][j]=false;
	    	 }
		      
		     ///recursion/iterations
		     //for other places, i>0,j>0: 
		     //if(nums[i]>j)
		     //then exclude it, dp[i][j]=dp[i-1][j];
		     //else dp[i][j]=dp[i-1][j-nums[i-1]]; //including nums[i-1] in sum which is j at this point of time
		     //at last return dp[nums.length][sumMax]
	    	 
	    	 for(int i= 1;i<canpartResultArr.length;i++)
	    	 {
	    		 System.out.print(i);
	    		 for(int j= 1;j<canpartResultArr[0].length;j++)
	    		 {
	    			 
	    			 if(nums[i-1]<=j)
	    			 {
	    				//include 
	    				 canpartResultArr[i][j]=canpartResultArr[i-1][j-nums[i-1]];
	    				 
	    			 }
	    			 else {
	    				//exclude 
	    				 canpartResultArr[i][j]=canpartResultArr[i-1][j];
	    			 } 
	    			 
	    		 }
	    	 }
	    	 
	    	// Arrays.stream(canpartResultArr).forEach((x)->Arrays.stream(x).forEach(r-> System.out.print(r.booleanValue())));
	    			// ; System.out.println(x));;
	    	 
	    	for(Boolean[] a:canpartResultArr)
	    	{
	    		for(Boolean b:a)
	    		{
	    			System.out.print(b+ " ");
	    		}
	    		System.out.print("\n");
	    	}
	    	 return canpartResultArr[canpartResultArr.length-1][canpartResultArr[0].length-1];   	  
	        
	    }

}
	 
}
