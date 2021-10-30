
public class MaxProfitSellStock122 {

	public MaxProfitSellStock122() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MaxProfitSellStock122().maxProfit(new int[] {1,2}));

	}
	
	 public int maxProfit(int[] prices) {
	    	
	//Valley is when price is kept on dipping and then it start increasing so just before it start increasing is the valley
	//peek is when price is kept on hiking and then it start dipping so just before it starts dipping is the peek
	//so find out the fist valley and then first peek after valley and collect the profit prince[peak]-prince[valley]
	//and then start searching from valley after this peek and corresponding peak for this valley. and keep collecting profit.
    //Don't wait for the the highest peek after valley as the cumulative profit will be lesser.
		 // 9, 10, 8,7,6,5(first valley - 5<8),8(first peak 8>3),3,2,1(2nd valley),11,12,15(2nd peak),2,1(3rd valley),21(peek)[end of array- so have to sell and ]
		 //edge case1: end of array- so have to sell 
		// edge case2: if it keeps dipping and have not yet bought the stock then no profit for that portion. 
    //we need to keep track of each valley and immediate peek 

       
       //scan using two pointers 
      
       int curr=1;
       int dif=0;
   	   int lmin=0;

       while(curr<prices.length)
       {
 
    	   while(curr<prices.length && prices[curr]<prices[curr-1])
    	   {
    		   curr++;
    		  //try to sell and check the profit 
    	   } 
    	   lmin=curr-1;//valley
    	   //curr=peak
    	   while(curr+1<prices.length && prices[curr]<prices[curr+1]) {
    		   curr++;
    	   }
    	   if(curr>=prices.length)
    	   {
    		   dif+=prices[curr-1]-prices[lmin];
    	   }
    	   
    	   else {
    	   dif+=prices[curr]-prices[lmin];
    	   }
    	   curr++;
    	   
       }
       
    	
		return dif;
        
    }

}
