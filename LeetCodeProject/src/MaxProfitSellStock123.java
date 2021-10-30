import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxProfitSellStock123 {

	public MaxProfitSellStock123() {
		// TODO Auto-generated constructor stub

	}

	 public int maxProfit(int[] prices) {
		 
		 
		 //base case
		 if(prices.length<=1)
		 {
			 return 0;
		 }
	    	
			//as we have to make at most two transaction instead of one (as mentioned in 121) or unlimited as mentions in (122). 
		    //we have to divide the time line in two parts,  left and right, and we have to add profit from both to find the max profit.
		    //find the optimal cut on time line which results in max profit. cut at ith point, profit[i]=leftprofit[i] + rightptofit[i+1]
		    //for optimal profit compare it with the previous cut, maxprofit=max(profit[i],profit[i-1])

		    int[] leftprofit=new int[prices.length];
		    int[] rightprofit=new int[prices.length];
		    
		    //left and right pointer
		    int i=1;
		    
		    int leftmin=0;
		    int rightmax=prices.length-1;
		    
		    
		    
		    leftprofit[0]=0;
		    rightprofit[prices.length-1]=0;
		    while(i<prices.length)
		    {
		    	//scan from left (1 to n-1) //position 0 is pre-filled
		    	int leftminValue = Math.min(prices[leftmin], prices[i]);
		    	//update the leftmin pointer
		    	leftmin=leftminValue==prices[i]?i:leftmin;
		    	//leftminValue will be euqal to prices[i] if current value at i is min and profit will be 0 so leftprofit[i-1] will be taken
		    	//else prices[i]-leftminValue and leftprofit[i-1] will be compared and max will be taken, in previous case prices[i]-leftminValue is 0
		    	leftprofit[i]= Math.max(prices[i]-leftminValue, leftprofit[i-1]);
		    	
		    	
		    	//scan from right (n-2 to 0) //position n-1 is pre-filled
		    	//rightmaxValue will be euqal to prices[i] if current value at i is max and profit will be 0 so leftprofit[prices.length-1-i+1] will be taken
		    	//else rightmax-prices[prices.length-1-i] and rightprofit[prices.length-1-i+1] will be compared and max will be taken, in previous case rightmax-prices[prices.length-1-i] is 0
		    	int rightmaxValue = Math.max(prices[rightmax], prices[prices.length-1-i]);
		    	//update the rightmax pointer
		    	rightmax=rightmaxValue==prices[prices.length-1-i]?prices.length-1-i:rightmax;
		    	rightprofit[prices.length-1-i]=Math.max(rightmaxValue-prices[prices.length-1-i], rightprofit[prices.length-1-i+1]);		
		    	i++;
		    			
		    }
		    
		   Arrays.stream(leftprofit).forEach(x->System.out.print(x+" ,"));
		   System.out.println();
		   Arrays.stream(rightprofit).forEach(x->System.out.print(x+", "));
		    
		    //scan for the optimal results from both the arrays
		    i=0;
		    
		    //if no cut means bought at the start and sold at last only one transaction
		    int maxprofit=prices[prices.length-1]-prices[0];
		    while(i<prices.length-1)
		    {
		    	maxprofit=Math.max(leftprofit[i]+rightprofit[i+1],maxprofit);
		    	i++;
		    	
		    }
		    
		  
		  
		        
		       return maxprofit;
		        
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       System.out.println(new MaxProfitSellStock123().maxProfit(new int[] {1,2,3,4,5}));
	}

}
