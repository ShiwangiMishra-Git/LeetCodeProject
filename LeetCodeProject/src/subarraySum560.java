import java.util.HashMap;
import java.util.Map;

public class subarraySum560 {

	public subarraySum560() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 int coins[] = new int[] {1};
	        int amount =0;
	        System.out.println("Minimum coins needed are " +
	        		subarraySum(coins, amount));
	}
	
	//if only positive numbers are given
	  public static int subarraySumPositive(int[] nums, int k) {
	        
	        int l=0;
	        int j=0;
	        int count=0;
	        long windowsum=0;
	        
	        //nums[0];
	        
	        if(nums.length==1 && windowsum==k)
	        {
	        	return 1;
	        }
	        while(j<=nums.length-1)
	        {
	        	//first inner while loop
	        	//reach the window sum
	        	windowsum+=nums[j];
	            while(windowsum<k)
	            {
	            	//first scenario to shift j
	            	j++;
	            	if(j<nums.length)
	            	windowsum+=nums[j];
	            }
 
	            
	            //first scenario to shift l
	            //if window sum is reached 
	            //shift left side boundary to right by one (++l)
	            //and  reduce the window sum by the eliminated value of past l before l++
	            if(windowsum==k)
	            {	
		                count++; 
		                windowsum-=nums[l];
		                l++;
		                
	            }
	            
	            
	            //first scenario to shift l
	            //if window sum is more than target sum 
	            //start shifting left side boundary to right (l)
	            //and keep reducing the window sum by the eliminated value of past l before l++
	            //while reducing if you get the sum==k, stop, increase the count and break the reduction loop  
	            while(windowsum>k)
	            {
	            windowsum-=nums[l];
	            l++;
	            if(windowsum==k)
	            {
	                count++; 
	                break;
	            } 
	        
	            
	            }
	            
	          //second scenario to shift j
	            //after the first inner while loop we might either get windowsum==k or windowsum>k
	            //at the end here increase the right boundary variable to scan more variables for sum k. this is the second place to change j
	            j++;
	           
	        }
	        
	        return count;
	        
	    }
	  
	//if only positive numbers are given
	  public static int subarraySum(int[] nums, int k) {
		  int count=0;
		  Map<Integer, Integer> sums=new HashMap();
		  
		  int sum=0;
		  sums.put(0,1); //put sum 0 initially and count 1
		  
	      //we want to have sums as we iterate in array from 0 to nums.len, saved in a hashtable 
	      //where key is sum and count is the value and if we again encounter the same count 
	      //we just update the count of the same key by one.
	      //logic is: if i iterate through the array and if I find out the sum (s) uptill now:
	      //s-k=x and x is present in our table we update the count by one.
	      //x(sum of elements in left)+k(sum of elements in the middle)=s(sum of elements in the right)
	      // if k=5, s=6, s-k=x, if 1 is present in the hash table we found the sum=k, sandwiched in middle  
		  //if  i =nums.length-1, then if s=sum+=nums[i], s-k=0 then it means if we add the numbers we will get k.
		  
		  
		  for(int i=0;i<nums.length;i++)
	      {
	    	 sum+=nums[i]; 
	    	 
	    	
	    	
	    	 
	    	//check for k 
	    	/*  if (sums.containsKey(sum - k))
	                count += sums.get(sum - k);*/
	    	  

	 
	    	 if(sums.get(sum-k)!=null) {
	    		int x=sums.get(sum-k); 
	    		if(x!=0)
	    		{
	    		count+=x;	
	    		}
	    	
	    	 }
	    	 
	    	 //update the count for sum
	    	 
	    	  Integer sumcount=sums.get(sum);
		    	 if(sumcount != null)
		    		 sums.put(sum,1);
		    		 else
		    			 sums.put(sum, 1);
		    	 
		    	//  sums.put(sum, sums.getOrDefault(sum, 0) + 1);
		    	
		    	 
             
	      }
	       
		  return count;
	  }
	        

}
