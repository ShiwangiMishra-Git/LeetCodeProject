
public class lowestCommonAncestorIIILC1650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node parent;
	};

	//time: O(h), h=n-1 to logn
	//space: O(1)

	class Solution {
	    public Node lowestCommonAncestor(Node p, Node q) {
	        
	        //calculate the height of both the nodes
	       int h1= height(p);
	       int h2= height(q);
	        
	        //p always points to deepest node
	        if(h1<h2)
	        {
	            Node temp=q;
	            q=p;
	            p=temp;
	           int temph=h2;
	            h2=h1;
	            h1=temph;
	        }
	        
	        //bring p to same height as q
	        while(h1-h2>0)
	        {
	            p=p.parent;
	            h1--;
	        }
	        
	        //keep moving up until reach lcs
	        while(p!=q)
	        {
	            p=p.parent;
	            q=q.parent;
	        }
	        return p;

	    }
	    
	    //O(h)
	   public  int height(Node p)
	    {
	        int h1=0;
	        while(p.parent!=null)
	        {
	            h1++;
	            p=p.parent;
	        }
	        return h1;
	            
	    }
	    

}
