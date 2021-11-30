import java.util.stream.Stream;

public class BeautifulArrangementLC526 {
    static int count=0;
	public BeautifulArrangementLC526() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countArrangement(1));
	}
	
	  public static int  countArrangement(int n) {
			 
			//time: less than O(k),(only valid permutations)k<n! since not all branches will be followed till last in backtrack 
		    //space: O(n) numarr+visited=2n
			//backtrack
			int[] numarr=new int[n];
			for(int i=1;i<=n;i++)
			{
				numarr[i-1]=i;
			}
			boolean[] visited=new boolean[n];
			
			//trigger for backtrack position n=0
			backtrack(numarr,1,visited); 
			
			return count;
		    }
		 
	 
	 private static void backtrack(int[] numarr, int position, boolean[] visited) {
			// TODO Auto-generated method stub
			
			 //result condition
			 if(position==numarr.length+1)
			 {
				 count++;
	             return;
			 }
			 
			 //possible branches(numarr[0] to numarr[numarr.length-1]) for this position //not all valid
			 for(int i=1;i<=numarr.length;i++)
			 {
				 //bounding condition to ignore the branch ,numarr[i] is already added in the branch or it is
				 //not following this -> numarr[i]%i==0 || i%numarr[i]==0
				 
				 //bounding condition not true
				 if(!visited[i-1] && (numarr[i-1]%position==0 || position%numarr[i-1]==0))
				 {
				    visited[i-1]=true;
				    backtrack(numarr,position+1,visited);
				    visited[i-1]=false;	 
				 } 
			 }	
		}

	

}
