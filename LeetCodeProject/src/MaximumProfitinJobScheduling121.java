import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumProfitinJobScheduling121 {

	public MaximumProfitinJobScheduling121() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// First - max profit (optimal solution)

		// Choosing whether to take a job or not

		// Optimal substructure: As we choose a job and find max profit till that job
		// and then save it. Use it in later jobs selection it is dp
		//get max at the end of memonization profitOptimal[n-1]
		
		//complexity O(nlogn) //Sorting +O(nlogn) //Binary Search n times =O(nlogn)
		//space: Sorting O(n) no extra space, jobarr =O(n) space, total

		
		int[] startTime = {1,2,3,4,6}; int[] endTime = {3,5,10,6,9}; int[] profit = {20,20,100,70,60};
		System.out.println(new MaximumProfitinJobScheduling121().jobSchedulingMine(startTime, endTime, profit));

	}
	

	public int jobSchedulingMine(int[] startTime, int[] endTime, int[] profit) {

		int[][] jobarr = new int[startTime.length][3];

		for (int i = 0; i < jobarr.length; i++) {
			jobarr[i] = new int[] { startTime[i], endTime[i], profit[i] };
		}

		//sorting quicksort O(nlogn)
		// sort array based upon end time ascending
		Arrays.sort(jobarr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}

		});
		
		  Arrays.stream(jobarr).forEach(x->System.out.println(x[1]));
		   System.out.println("---");
		// go through all jobs from i=1 to all jobs

		int[] profitOptimal = new int[startTime.length];
		for (int i = 0; i < jobarr.length; i++) { //O(n*logn) //logn for binary search
			 int profitcurr=0;
			if (i == 0) {
				profitOptimal[i] = jobarr[i][2];
			}

			else {
				// total profit till i= max(profitOptimal[i-1],jobarr[i][2]+( optimal profit
				// profitOptimal[],in first right most job in left of i, which has end time less
				// than start time of job i))

				// binary search to find in first right most job in left of i, which has end
				// time less than start time of job i
				
				//O(logn)
				int positionpre=BinarySearch(jobarr,0,i-1,i);
				int profitpre=0;
				if(positionpre>-1)
				  profitpre=profitOptimal[positionpre];
				  profitcurr=jobarr[i][2]+profitpre;
				  System.out.println("profitcurr:"+ profitcurr);
			}
			if (i != 0) {  
			   profitOptimal[i] =Math.max(profitOptimal[i-1], profitcurr);}
			   Arrays.stream(profitOptimal).forEach(x->System.out.println(x));
			   System.out.println("---");

			}
		

		return profitOptimal[profitOptimal.length-1];

	}

	int BinarySearch(int[][] jobarr, int l, int r, int i) {
		
		int searchresultjob=-1;//nearest job with endtime less than current start time
		while (l <= r) {
			int mid = (l + r) / 2;
			// we have to find job in left of i, which has end time less than start time of current job
			// job i
			if (jobarr[mid][1] <= jobarr[i][0]) {
				searchresultjob= mid;
				l=mid+1;
			} else {
					r = mid - 1;
			}
			
		}

		return searchresultjob;
	}
	

}
