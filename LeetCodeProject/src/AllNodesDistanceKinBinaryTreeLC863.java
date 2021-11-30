
public class AllNodesDistanceKinBinaryTreeLC863 {

	public AllNodesDistanceKinBinaryTreeLC863() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
	/*
class Solution {
     Map<Integer,HashSet<Integer>> mapList=new HashMap();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
           // create hashmap for adjancy list;
            constructList(root);
      System.out.println(mapList);        

        int depth=0;
        Queue<Integer> q=new LinkedList();
        q.add(target.val);
        Map<Integer,Integer> mp=new HashMap<>();
        List<Integer> visited=new LinkedList();
        mp.put(target.val,0);
        while(!q.isEmpty())
        {  Integer i=q.poll();
          Set<Integer> s= mapList.get(i);
          for(Integer n:s)
          {
              if(!visited.contains(n)){
                 System.out.println(n +" is at "+ ( mp.get(i)+1));
              mp.put(n,mp.get(i)+1);
              q.add(n);}
          }
         visited.add(i);
        } 
        List<Integer> list=new LinkedList<Integer>();
        for(Map.Entry<Integer,Integer> e: mp.entrySet())
        {
            if(e.getValue()==K)
            {
              list.add(e.getKey());  
            }
        }
        return list;
        
    }
    public void constructList(TreeNode root)
    {
        if(!mapList.containsKey(root.val))
        {
          mapList.put(root.val,new HashSet<Integer>());
        }
              HashSet<Integer> set= mapList.get(root.val);
              if(root.left!=null)
              { set.add(root.left.val);
                   if(!mapList.containsKey(root.left.val))
                      {
                          mapList.put(root.left.val,new HashSet<Integer>());
                        }
                     HashSet<Integer> setL= mapList.get(root.left.val);
                     setL.add(root.val);
                   mapList.put(root.left.val,setL);
              }
              if(root.right!=null)
              {
                  set.add(root.right.val);
                   if(!mapList.containsKey(root.right.val))
                      {
                          mapList.put(root.right.val,new HashSet<Integer>());
                        }
                     HashSet<Integer> setR= mapList.get(root.right.val);
                     setR.add(root.val);
                   mapList.put(root.right.val,setR);
              }
         mapList.put(root.val,set);
         if(root.left!=null)
              {
         constructList(root.left);}
         if(root.right!=null)
              {
          constructList(root.right);}
    }
}


//find the distance of node from 
	 */

}


