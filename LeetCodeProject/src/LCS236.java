       //given any subtree or the main tree any node is LCA if
	        //result case 1:  l =a, r=b ,root ,lcs=root
	        //result case 2: root=a, l or r=b , lcs=root

	        //Question 1: are all values unique 
             //Question 2:  can given nodes(p and q) be null?
                //how tree is stored

	        //edge case: root node = null
	      
	        
           //time= O(n) ,every node 2 times max 
	       //space: O(h) //call stack height
              //best case balanced, h = log(n)
	          //worst case skewed,  h=n



public class LCS236 {
	
		public class TreeNode {
		       int val;
		       TreeNode left;
		       TreeNode right;
		       TreeNode() {}
		       TreeNode(int val) { this.val = val; }
		       TreeNode(int val, TreeNode left, TreeNode right) {
		         this.val = val;
		         this.left = left;
		         this.right = right;
		     }
		 }

		 

	    public static TreeNode  lcsNode = null;
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	 
	        
	lcsNode=null;
	          checkLCS(root,p,q);
	          return lcsNode;
	        
	        
	    }
	    
	    public boolean checkLCS(TreeNode node,TreeNode p, TreeNode q)
	    { 
	     
	        if(node==null)
	        {
	           return false; 
	        }
	        
	        int rt=(node.val==p.val||node.val==q.val)?1:0;
	        int l=0;
	        int r=0;
	        if(lcsNode==null)
	        {
	        l=checkLCS(node.left,p,q)?1:0;
	        }
	           if(lcsNode==null)
	        {
	         r=checkLCS(node.right,p,q)?1:0;
	           }
	        
	        if(rt+l+r==2)
	        {
	           lcsNode = node; 
	        }
	        return rt+l+r>0;
	         
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
