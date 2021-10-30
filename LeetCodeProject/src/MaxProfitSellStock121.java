import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class MaxProfitSellStock121 {

	public MaxProfitSellStock121() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.out.println(new MaxProfitSellStock121().maxProfit(new int[] {7,1,5,3,6,4}));

	}
	
    public int maxProfit(int[] prices) {
    	
    	
    	 //digression: sorting hashmap using stream
    /*	Map<Integer,Integer> pricesMap=new HashMap<Integer,Integer>();

    	//days as key, value as value
    	for(int i=0;i<=prices.length-1;i++)
    	{
    		pricesMap.put(i, prices[i]);
    	}
    	 pricesMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new)).entrySet().forEach(System.out::println); */
      
    	
    	//sort based on value of stock
       
    	

       
       //scan using two pointers 
       int lmin=0;
       int curr=1;
       int dif=0;
       
       
       while(curr<prices.length)
       {
    	   if(prices[curr]>prices[lmin])
    	   {
    		  //try to sell and check the profit 
    		   dif=Math.max(prices[curr]-prices[lmin],dif);
    	   }
    	   else {
    		   // set the new min
    		   lmin=curr;
    	   }
    	   curr++;
       }
       
    	
		return dif;
        
    }

}
