import java.util.Stack;

public class NumberOfIslands {

	public NumberOfIslands() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		/*char [][] arr= {{'1','1','1','1','0'}
		              ,{'1','1','0','1','0'}
		              ,{'1','1','0','0','0'}
		              ,{'0','0','0','0','0'}};
		*/
		char [][] arr= {{'1','1','0','0','0'}
        ,{'1','1','0','0','0'}
        ,{'0','0','1','0','0'}
        ,{'0','0','0','1','1'}};
		// TODO Auto-generated method stub
		
		System.out.println(new NumberOfIslands().numIslands(arr));

	}
	
	 public int numIslands(char[][] grid) {
		 
		 int numberOfIslands=0;
		 
		 //iterate each element
		 
		 for(int i=0;i<grid.length;i++)
		 {
			 for(int j=0;j<grid[0].length;j++)
			 {
				 if(grid[i][j]=='1')
				 {
					 numberOfIslands++;
					 Stack<Integer> treestack=new Stack<Integer> ();
					 //Do DFS and convert all 1's to zero which are in the single dfs tree
					 DoDFS(grid,i,j,treestack);
					 
				 }
			 }
		 }
		 
		 return numberOfIslands;
	 }
	 
	 private void DoDFS(char[][] grid, int i, int j,Stack<Integer> treestack) {
		 
		 Integer p= (grid[0].length)*i +j; 
		 treestack.push(p);	//push now and pop at the end when all children sub trees are done
		 grid[i][j]='0'; //processed position

			//Integer curr = treestack.peek();
			
			//Integer ipos=p/grid[0].length;
			//Integer jpos=p%grid[0].length;
			
			
			//DFS all children
			
			
			//sub tree 1
			if(j+1<grid[0].length && grid[i][j+1]=='1')
			{
				DoDFS(grid,i,j+1,treestack);
			 
			 }	
			
			//sub tree 2
			if(j-1>=0 && grid[i][j-1]=='1')
			{
				DoDFS(grid,i,j-1,treestack);
			}
			
			//sub tree 3
			if(i+1<grid.length && grid[i+1][j]=='1')
			{
				DoDFS(grid,i+1,j,treestack);
			}
			
			//sub tree 4
			if(i-1>=0 && grid[i-1][j]=='1')
			{
				DoDFS(grid,i-1,j,treestack);
			}
			 
			//all done so pop the root i,j 
			//popping will start happening from terminal nodes- when we reach the end of a branch where there are no sub trees so none of the above DoDFS calls
			// intermediate nodes will be popped- when all the DoDFS calls have completed and all the nodes(of intermediate sub trees) are processed by pushing/popping (their own recursive calls are done)
			//at the end the top node which was pushed initally by the numIslands will be popped and one full DFS tree will be done. which is an island. 
			//and then we will move to next i,j which is not processed (grid[i][j]==1) in previous call 
			
			treestack.pop(); 	
			//return grid;
	}

	// TODO Auto-generated method stub
	 
			 //Use stack for LIFO 
			 //as we insert the root and keep pushing branch by branch (push the node,when all children trees are done getting pushed and popped out, pop out this root as well, this is true for all trees and subtrees of DFS). 
			      //we process bracnch by brach in each tree/sub tree - When one branch gets over (last node did not have any children ).
			     //Start popping out. and move to it's sibling if no sibling pop out the parent and so on ...at the end the root node that way stack gets over and we traversed the whole DFS tree
			 
			 
				/* get the position from i and j,
				  p= len*i+j to push in the stack
				 
				 4*0+j     4*1+j      4*2+j
				 
				 i=0       i=1        i=2
			     j=0
				 index=0   index=4      8      
				 
				 i=0
				 j=1
				 index=1   index=5      9      
				 
				 i=0
				 j=2
				 index=2   index=6     10
				 
				 i=0
				 j=3 
				 index=3   index=7     11 */
				 
				 //while popping from stack we get the position , i=p/len and j=p%len
				 
			 

}
