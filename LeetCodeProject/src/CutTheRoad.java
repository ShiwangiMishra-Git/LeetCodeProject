
public class CutTheRoad {

	//unbounded KP
//Problem statement: https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
//Solution:(14 Rod Cutting Problem) https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
	
	public CutTheRoad() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static int maxProfit(int[] cuts,int n)
	{
		int[][] profit=new int[cuts.length+1][n+1];
		
		//initialization
		
		
		// bottom up DP(replacement of top down recursive function)
		//base: if n=0 or cuts.len=0 return 0;
		
		//for n=0
	    for(int i=0;i<profit.length;i++)
	    {
	    	profit[i][0]=0;
	    }
	    
	    //for cuts.len=0
	    for(int j=0;j<profit[0].length;j++)
	    {
	    	profit[0][j]=0;
	    }
	    
	
		//recursion
	    for(int i=1;i<profit.length;i++)
	    {
	    	for(int j=1;j<profit[0].length;j++)
		    {
	    		profit[i][j]
	    				= i<=j? Math.max(
	    						cuts[i-1]+profit[i][j-i] //can include - included
	    								,profit[i-1][j]) //can include - but don't include
	    						:profit[i-1][j] ; //can't include - as cut length(i) is more than j(rod length)
		    }	
	    }
	
		
		
		return profit[cuts.length][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
	        int size = arr.length;
	        System.out.println("Maximum Obtainable Value is " +
	        		 maxProfit(arr, size));
	}

}
