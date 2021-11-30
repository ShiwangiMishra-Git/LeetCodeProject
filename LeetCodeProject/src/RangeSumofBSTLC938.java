import java.util.ArrayList;
import java.util.List;

public class RangeSumofBSTLC938 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int rangeSumBST(TreeNode root, int low, int high) {
	       
	        List<TreeNode> q=new ArrayList<TreeNode>();
	        int result=0;
	        if(root!=null)
	        {
	        q.add(root);
	        }
	        while(!q.isEmpty())
	        {
	            TreeNode curr=q.remove(0);
	            
	            
	            if(curr.val>=low && curr.val<=high)
	            {
	              result=result+curr.val;  
	            }
	            
	            if(curr.val>low && curr.left!=null)
	            {
	               q.add(curr.left); 
	            }  
	            
	            if(curr.val<high && curr.right!=null)
	            {
	               q.add(curr.right);  
	            }
	        }
	        return result;
	    }

}
