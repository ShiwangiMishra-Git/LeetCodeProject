import java.util.HashMap;
import java.util.Map;

public class longestCommonPrefixLC14 {

	public longestCommonPrefixLC14() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s= "flower".substring(0, 0);
		//System.out.println(s);
		String[] strArg={"flower","flow","flight"};
		   System.out.println(" longestCommonPrefix: " +
				   longestCommonPrefix1(strArg));
	}
	
	//horizontal scanning 
	//compare prefix =arr[i] , for i=0 and finalize prefix for i=1,finalize prefix for i=2 so on till i=n-1
	//strs[i].indexOf(prefix) will return 0 if it is prefix is present at the start else -1 if not present at all or some other index if it is in the middle somewhere 
	public static String longestCommonPrefix1(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0]; // select first as prefix
	    for (int i = 1; i < strs.length; i++) // then find the prefix for each element one by one
	        while (strs[i].indexOf(prefix) != 0) { //strs[i].indexOf(prefix) will return 0 if it is prefix is present at the start else -1 if not prsent at al or someother index if it is in the middle somewhere 
	            prefix = prefix.substring(0, prefix.length() - 1); // if prefix is not a prefix then trim it 
	            if (prefix.isEmpty()) return ""; // if after trimming empty string af return 
	            //else check again prefix while (strs[i].indexOf(prefix) != 0)
	     //after comparing two strings 0,1 and finding the prefix it may be some string of len >=0, move to next i and check if this prefix is present here and trim the prefix if need and find the final prefix till this i.        
	        }   
	    Map<String,Integer> resultmap=new HashMap<String,Integer>();
	    return prefix;
	}
	
	//Column wise  scanning 
	//compare each character  word =strs[0], word[j], j=0 to word.length-1 check in all other words i=1 to n-1, and see if word[j] is present in strs[i][j] for rest all i's if not word.substring(0,j) is the prefix
		public static String longestCommonPrefix2(String[] strs) {
		    if (strs.length == 0) return "";
		    String word = strs[0]; // select first as prefix
		    for (int j = 0; j < word.length(); j++)  // each letter
		   {
		    	for (int i = 1; i < strs.length; i++) //check each word for this letter
				   {
		    		//if length of this world is less than j or if this letter is not present at j position in current string strs[i]
		    		if(strs[i].length()==j|| 
		    				strs[i].charAt(j)!=word.charAt(j))
		    		{
		    			return word.substring(0,j);
		    		} 
		    		//else go to next string in array strs
		        }    
		        }    
		  
	
		    return word;
		}
		
		//divide and conquer => recursion divide in half and find lcp 
		//2T(n/2)+O(m) =n.m (in worst case m is same for all,in best case m is len of minlenword)
		public String longestCommonPrefix3(String[] strs) {
		    if (strs == null || strs.length == 0) return "";    
		        return longestCommonPrefix(strs, 0 , strs.length - 1);
		}

		private String longestCommonPrefix(String[] strs, int l, int r) {
		    if (l == r) { //base condition
		        return strs[l];
		    }
		    else {
		        int mid = (l + r)/2; //divide
		        String lcpLeft =   longestCommonPrefix(strs, l , mid); //conquer  --(n/2 elements)
		        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);//conquer  --(n/2 elements)
		        return commonPrefix(lcpLeft, lcpRight); //merge for result of l to r   --  O(m)
		        //2T(n/2)+O()
		   }
		}

		String commonPrefix(String left,String right) {
		    int min = Math.min(left.length(), right.length());       
		    for (int i = 0; i < min; i++) {
		        if ( left.charAt(i) != right.charAt(i) )
		            return left.substring(0, i);
		    }
		    return left.substring(0, min);
		}
		
		//binary search
	   // get minlenword with lmin length and left=0 right=mid=lmin/2 (mid for binary search)
		//instead of checking column wise for all the check for substring  strs[0].substring(0,mid) to be a isprefix(strs,left,right) , left=0, right=mid in all the words 1 to n  
		// if not a prefix reduce right=mid-1, else increase left=mid+1; doing so at some point left ad right would cross each other left >right and that would be end of binary search
		// at that point we get out prefix
		   public String longestCommonPrefix(String[] strs) {
			    if (strs == null || strs.length == 0)
			        return "";
			    int minLen = Integer.MAX_VALUE;
			    for (String str : strs)
			        minLen = Math.min(minLen, str.length());
			    int low = 1;
			    int high = minLen;
			    while (low <= high) { //perform bs with this terminating condition (until 1 element is there between l==r)
			        int middle = (low + high) / 2;
			        if (isCommonPrefix(strs, middle)) //check to manipulate the search boundaries to narraow down the search
			            low = middle + 1;
			        else
			            high = middle - 1;
			    }
			    return strs[0].substring(0, high); //high is the boundary h<l then we termnate the bs
			}

			private boolean isCommonPrefix(String[] strs, int len){ //middle is the len of prefix to be checked here it len can have  max value= minlen
			    String str1 = strs[0].substring(0,len);
			    for (int i = 1; i < strs.length; i++)
			        if (!strs[i].startsWith(str1))
			            return false;
			    return true;
			}
}
