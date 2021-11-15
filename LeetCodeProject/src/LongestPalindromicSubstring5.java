
public class LongestPalindromicSubstring5 {

	public LongestPalindromicSubstring5() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String para = "bb";
	        System.out.println(" longestPalindrome" +
	        		longestPalindrome(para));
	}
	
	 public static String longestPalindrome(String s) {
		 
		 //Question type 1: palindrome: 
			 //to find palindrome iterate from both ends for i=0 to (n/2)-1 , start = start(intialize with 0) + i , end = end(n-1) - i;
		 //s[start] and s[end] should be same. //
		 //if n is even n=4, i=1,2 due to zero index : i=0,1, pair(start,end) = pair(0,3=n-1),pair(1=0+1,2=3-1)
		 //O(n) complexity
		 
		 //Question type 2:to find longestPalindrome:
		 //BF: 
		 //step1:O(n^2) Find all the substring for all i=0 to n-1 -> j=i+1 to n-1 
		 //step2:O(n) Finding if it is palindrome for all the substrings 
		 //and then we can find out the one with max length
		 //total complexity O(n^3)
		 
		 //each palindrome has something in center which acts as mirror (n/2+1)
		 //in case of even numbers we have two mirrors n/2,n/2+1
		 //so if we one by one check for each number (i and i+1) for being a mirror we will get to know the palindrome length around each number
		 //pallen1=expand(s,left=i,right=i) and pallen2=expand(s,left=i,right=i+1)
		 //Initialize: start=0,end=0,palmaxlength=end-start
		 //if maxlen=max(pallen1,pallen2)
		 //maxlen>palmaxlength, newstart=i-(maxlen-1/2), newend=i+(maxlen/2)
		 //
		 
		 int start=0;
		 int end=0;
		 int maxlen=1;
		 
		 int len1=0;
		 int len2=0;
		 for(int i=0;i<s.length();i++)
		 {
			 //one center elements
			 len1=expand(s,i,i);
			 
			 //two center elements
			 len2=expand(s,i,i+1);	
			 
			 int maxlennew=Math.max(len1, len2);
			 if(maxlen<maxlennew)
			 {
				 //update start and end
				 //in case of odd len , half elements left to i = (maxlennew-1)/2 = maxlennew/2 , n=7,7/2 and 6/2 is same
				 //mirror of size 1 but pick maxlennew-1 to accommodate one formula in both cases even and odd.
				 //in case of even len , half elements left to i = (maxlennew-1)/2, //mirror of size 2 so (len-1)/2 elements to left of i
				 //example : maxlennew=6(3rd and 4th elements are at centre so we can take it as one element and it will become like odd len: remaining len-1 to calculate=>),
				 // elements will be left of i
				 start=i-(maxlennew-1)/2; 
				 //in case of even - mirror of size 2 so (len-1)/2 elements to left of i but right of i is not impacted by this mirror size, it still has len/2 elements to right of i
				 //odd (maxlennew)/2 elements will be right of i
				 end=i+(maxlennew)/2; 
				 maxlen=maxlennew;
				 
			 }
		 }
		 
		 String result=s.substring(start, end+1);
		 
		 return result;
		 	 
	 }
	 
	 public static int expand(String s,int left,int right)
	 {
		 
		int pallength=0;
		
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
		{
			right++;
			left--;
		}
		
		pallength=right - (left+1);
		return pallength;
		 
	 }

}
