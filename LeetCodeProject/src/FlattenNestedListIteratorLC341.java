import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     /*Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// input= [0,[1,2],3,[5,[6,7]]]
// output=
/*NestedInteger=
    0
    [1,2]
    3
    [5,[6,7]]*/

// input=[] return 

//Time Complexity = O(n+L)

// N for total integer elements in list and L number of lists in the nestedList,  for each list with n integers, sum(n)=N, N(adding each integer in the list using for) + L times call to flat each list 
//Space Complexity = O(N+D) number of total integers, N number of integers in the list and D for max nesting in the list for stack calls.

public class NestedIterator implements Iterator<Integer> {
  public static List<NestedInteger> flatlist;
    public static int counter;
    
    public NestedIterator(List<NestedInteger> nestedList)
    {
        flatlist= new ArrayList<NestedInteger>();
        flatList(nestedList);
        counter=-1;
    }
    
       @Override
    public Integer next()
    {
    if(hasNext())
    {
    return flatlist.get(++counter).getInteger();
    };
   
    return Integer.MAX_VALUE;
    }
    
       @Override
    public boolean hasNext() {
    if(flatlist.size()>counter+1)
    {
    return true;
    }
    return false;
    
    }
    
       
       public void flatList(List<NestedInteger> nestedList){
           for(NestedInteger n:nestedList)
           {
             //  flat(n);
               
                if(n.isInteger())//single
             {
                 System.out.println("Int"+n.getInteger());
                 flatlist.add(n);
             }
    else{
        
         flatList(n.getList());
         
        }
           }
    
    
}

/*public class NestedIterator implements Iterator<Integer> {

    public NestedIterator(List<NestedInteger> nestedList) {
        
    }

    @Override
    public Integer next() {
        
    }

    @Override
    public boolean hasNext() {
        
    }
}
}*/

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */