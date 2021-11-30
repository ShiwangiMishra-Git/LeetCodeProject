import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

class GettingADifferentNumber {

  /*static int getDifferentNumber(int[] arr) {
    // your code goes here
	  //use priority queue
	  PriorityQueue<Integer> pq=new PriorityQueue<Integer>(); 
	  Arrays.stream(arr)
      .forEach(e->pq.add((Integer)e)); //O(n)+O(nlogn)
	  
    int i=0;
    int j=0;
    //O(nlogn)
    while(!pq.isEmpty() && i<=(Math.pow(2, 31)-1)) //O(n)
    {
    	j=pq.poll(); //O(logn)
		if(i!=j ) 	 
		{
			  System.out.println(j);
    		return i; 
    	 }
		else i++;
    }
  
    return i;
  
   
  }*/
  
  static int getDifferentNumber(int[] arr) {
	    
	    for(int i=0;i<arr.length;i++)
	    {
	      
	      if(arr[i]==0)
	      {
	        continue;
	      }
	    while((arr[i]!=i) && (0<=arr[i]) && (arr[i]<arr.length))
	    {
	      System.out.println(arr[i]+" "+i);
	      int temp=arr[arr[i]];
	      arr[arr[i]]=arr[i];
	      arr[i]=temp;
	    } 
	      
	    }
	    
	   for(int i=0;i<arr.length;i++)
	      {
	        if(arr[i]!=i)
	        {
	          return i;
	        }
	        
	       }
	    
	    return -1;
	 
	   
	  }


 
  public static void main(String[] args) {
new GettingADifferentNumber();
GettingADifferentNumber.getDifferentNumber(new int[] {0,1,2});
  }

}