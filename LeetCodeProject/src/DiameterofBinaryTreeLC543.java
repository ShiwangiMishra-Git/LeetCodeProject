
public class DiameterofBinaryTreeLC543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int maxlen;
	    public int diameterOfBinaryTree(TreeNode root) {
	        this.maxlen=0;
	        DFS(root);
	        return this.maxlen;
	    }
	    
	    public int DFS(TreeNode node)
	    {
	        if(node==null)
	        {
	            return 0;
	        }
	        
	        int pathlenLeft=0;
	        int pathlenRight=0;
	        
	        if(node.left!=null)
	        {
	           pathlenLeft=DFS(node.left)+1;
	        }
	        if(node.right!=null)
	        {
	           pathlenRight=DFS(node.right)+1;
	        }
	        
	        maxlen=Math.max(pathlenLeft+pathlenRight,this.maxlen);
	        
	        return Math.max(pathlenLeft,pathlenRight);
	    }

}
