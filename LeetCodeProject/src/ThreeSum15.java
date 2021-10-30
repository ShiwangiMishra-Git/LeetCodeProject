import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class ThreeSum15 {

	public ThreeSum15() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
	
	//It is like 2 sum if we fix a number (a) and try to pair it with others(b) and  find the number -(a+b) as target, which is like two sum 	
    //got through each number a the list
	//(a)fix one number(take care if it is not processed before) //using set
		//- scan through every number(b) coming after this  
		//Check if(c) -(a+b) is present in the seen hashmap 
		   //if yes then we found(c) which is a complement and triplet (a,b,c) and
		//sort (sorting is required since we don't need to add the same triplet in the result such as -1,0,1 and 0,-1,1 are same but different order
		    //first one we got which processing -1 and second one we got while processing 0)
		//& add it in our result Set
		//Add (b) in the seen HashMap with key as the number seen(b) and value number(a) as the number fixed in line 1
		//
		
		Set<List<Integer>> result=new HashSet<List<Integer>>();
		
		Set<Integer> dups=new HashSet<>();
		
		Map<Integer,Integer> seen=new HashMap<Integer,Integer>();
		
		for(int i=0;i<nums.length;i++)
		{
			if(dups.add(nums[i]))
			{
				for(int j=i+1;j<nums.length;j++)
				{
					int c=-(nums[i]+nums[j]);
					if(seen.containsKey(c) && seen.get(c)==i)
					{
						List<Integer> tripplet=Arrays.asList(nums[i],nums[j],c);
						Collections.sort(tripplet);
						result.add(tripplet);
					}
					
					seen.put(nums[j], i);
				}
			}
			
			
		}
		
		return new ArrayList(result);
		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int nums[] = new int[] {-1,0,1,2,-1,-4};
	        System.out.println("threeSum tripplets are " +
	        		threeSum(nums));
	}

}
