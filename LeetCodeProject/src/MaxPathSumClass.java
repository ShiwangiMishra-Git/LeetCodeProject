
 // Definition for a binary tree node.
 
//at any node:
//current= left + right +node and comparae it with previous max
// return at any recursion call max path sum which can have either node alone or with (left or right tree)
// space complexity= O(h), h=height of tree =worst case for skewed tree (h=n)
// time=O(n)//since each node visited twice at max // one when it is root second when it is child

class MaxPathSumClass {
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
	 

   
    public static int maxsum=Integer.MIN_VALUE;
   
    public static int maxsum(TreeNode node)
    {
        if(node==null)
            return 0;
        
        
            int left=Math.max(maxsum(node.left),0);
            int right=Math.max(maxsum(node.right),0);
            int current=node.val;
        
            int allsum=left+right+current;
            maxsum=Math.max(maxsum,allsum);
        
       
           int maxChildBranch=Math.max(left,right);
           return current+maxChildBranch;
       
        
    }
     public int maxPathSum(TreeNode root) {
         maxsum=Integer.MIN_VALUE;
         maxsum(root);
         
         return maxsum;
     }
     
     public static void main(String[] args) {
 		// TODO Auto-generated method stub

 	}
}







