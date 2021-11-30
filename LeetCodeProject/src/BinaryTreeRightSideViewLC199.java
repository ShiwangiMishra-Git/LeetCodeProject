import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideViewLC199 {

	
	// 0,1,2
	//may I ho the tree is represente in ds: 
	//class: treenode - val,leftnode ,right node
	//input- 1,2,3
	//4,5
	  /*  1
	    3
	    5*/
	 //[] => null
	        
	 //what should be the max value of node => +- 10^9 value- Integer
	 //number of  nodes   
	//
	        
	  //recursion -> root,right,left
	        //keep track of depth if current dept is > last max (add it in our view)
	        //
	//time: worst and best same as all the nodes will be traversed O(n)
	   
	//space: best recursion stack O(logn) + elements in longest branch O(logn) 
	      // worst: skewed O(n)+O(n)

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	   public static int maxpathlen;
	   /*  public List<Integer> rightSideView(TreeNode root) {
	         List<Integer> result=new ArrayList<Integer>();;
	         maxpathlen=-1;
	         result=new ArrayList<Integer>();
	         return recurRightSide(root,0,result);
	     }*/
	   
	     //using dfs
	    public List<Integer> recurRightSide(TreeNode node,int pathlen,List<Integer> result)
	    {
	        if(node!=null)
	        {
	     
	        if(pathlen>maxpathlen)
	        {
	        result.add(node.val);
	        maxpathlen=pathlen; 
	        }
	        
	        result=recurRightSide(node.right,pathlen+1,result);
	        result=recurRightSide(node.left,pathlen+1,result);
	        }
	        return result;

	    }
	     
	     public static int currLevel;
	     public static int nextLevel;
	     public static List<Integer> result=null;
	     public static List<TreeNode> currQueue=null;
	     
	     public List<Integer> rightSideView(TreeNode root) {
	         
	         result=new ArrayList<Integer>();
	         currQueue=new LinkedList<TreeNode>();
	     if(root!=null)
	     {
	         currQueue.add(root);
	         currLevel=0;
	         BFS(currQueue);}
	         
	         return result;
	     }
	     
	     public void BFS(List<TreeNode> currQueue)
	     {
	         TreeNode curr=null;
	         List<TreeNode> nextQueue=new LinkedList<TreeNode>();
	          while(!currQueue.isEmpty())
	         {
	             curr=currQueue.remove(0);
	             if(curr.left!=null)
	             {
	               nextQueue.add(curr.left);   
	             }
	             
	              if(curr.right!=null)
	             {
	               nextQueue.add(curr.right);   
	             }
	             
	         }
	         if(curr!=null)
	         {
	             result.add(curr.val);
	             currLevel=currLevel+1;
	             BFS(nextQueue);
	         }
	     }

}
