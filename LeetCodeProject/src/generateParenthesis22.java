import java.util.ArrayList;
import java.util.List;

public class generateParenthesis22 {

	public generateParenthesis22() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(new generateParenthesis22().generateParenthesis(3)); 
	}
	
    public List<String> generateParenthesisMine(int n) {
    	
    	//height of time space tree atmost n (for any branch if valid and less than n if invalid)
    	//Since the depth of this tree is (obviously) at most 2.count, the space complexity is O(count).
    	//time: Since every function call can either add a ( or a ), the time complexity is at most O(2number of function calls) = O(2^(2*count)).
    	
    	//time complexity= O()
    	
    	//space complexity= O()
    	
    	//since it is problem of combinations it is example of backtracking problem
    	//best explanation https://youtu.be/s9fokUqJ76A
    	
    	//base condition for recursion = when resultstr =n*2 (when n=2 resultstr can be with len(4) = "()()")
    	//bounding condition to place right para= number of left parentheses > number of right parentheses
    	//when all left para are done, l==2 or n, place remaining right till r==2 or n
    	
    	/*Since the depth of this tree is (obviously) at most 2.count, the space complexity is O(count).

Since every function call can either add a ( or a ), the time complexity is at most O(2number of function calls) = O(2^(2*count)). where height of tree=2*count, so number of nodes are the  number of calls=2^h= 2^(2*count)

But, since the calls are conditional, the time complexity ends up being less, more specifically, it appears to be around O(2^(2*count)/count), though I'm yet to prove that.*/
    	
    	int l= 0; //number of left para used
    	int r = 0;  //number of right para used
    	List<String> result=new ArrayList<String>();
    	String combinationStr= "";
    
    	backtrackMine(n,result,l,r,combinationStr);
    	return result;
    }
    
    
    public void backtrackMine(int n,List<String> result,int l,int r, String combinationStr)
    {
    	
    	//result condition
    	if(l+r==2*n)
    	{
    		result.add(combinationStr);
    		return;
    	}
    	
    	if(l==n)
    	{
    		while(r<n)
    		{
    		combinationStr=combinationStr+")";
    		r=r+1;
    		}
    		result.add(combinationStr);
    		return;
    	}
    	
    	//recursion
    	
    	//add left (left branch of tree)
    	backtrackMine(n,result,l+1,r,combinationStr+"(");
    	
    	//add right (right branch of tree)
    	if(l>r) //bounding condition (can not follow this branch if this is not true)
    		backtrackMine(n,result,l,r+1,combinationStr+")");	
    }
	
	    public List<String> generateParenthesis(int n) {
	        List<String> ans = new ArrayList();
	        backtrack(ans, new StringBuilder(), 0, 0, n);
	        return ans;
	    }

	    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
	        if (cur.length() == max * 2) {
	            ans.add(cur.toString());
	            return;
	        }

	        if (open < max) {
	            cur.append("(");
	            backtrack(ans, cur, open+1, close, max);
	            cur.deleteCharAt(cur.length() - 1); //to prepare curr for next alternate branch by reverting the last addition
	        }
	        if (close < open) {
	            cur.append(")");
	            backtrack(ans, cur, open, close+1, max);
	            cur.deleteCharAt(cur.length() - 1);
	        }
	    }
}
