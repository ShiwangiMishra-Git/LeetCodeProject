import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeIntervals {

	public MergeIntervals() {
		// TODO Auto-generated constructor stub

	}

	public int[][] merge(int[][] intervals) {

		if(intervals.length<=1)
		{
			return intervals;
		}
		//sort in increasing order of start time if start a < start b < start c< start d
		// if end a >=start b then merge => start a, max(end a,end b)
		//if two contiguous event a and b does not overlap then a will not overlap with rest of the event as well since it is ordered by start time. 
		//if end a < start b and start b < or = start c => end a <start c so event a is not merging with others.
		
		//O(nlogn) (sorting) + O(n) (scanning the sorted intervals) = O(nlogn)
		
		class sortintervals implements Comparator<int[]> {

			@Override
			public int compare(int[] o1, int[] o2) {
				
			return	Integer.compare(o1[0],o2[0]);
				/*if (o1[0] < o2[0]) // descending order
				{
					return 1;
				} else {
					return -1;
				}*/
				// TODO Auto-generated method stub
			}

		}

		// sort based upon end time
	//	Arrays.sort(intervals, new sortintervals());
		
		Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));   //O(nlogn)
		
		List<int[]> outputArr=new ArrayList<int[]>();  
		
		int currintervalend=intervals[0][1];
		
		outputArr.add(intervals[0]);
		int index=0;
		for(int[] interval: intervals)                               //O(n)
		{
			if(interval[0]<=currintervalend)
			{ 
				int[]curr=outputArr.get(index);                    //due to arraylist get is just o(1)
				currintervalend= Math.max(currintervalend,interval[1]);
				outputArr.set(index, new int[]{curr[0],currintervalend});
			}
			else {
				index++;
				outputArr.add(interval);                               //O(1)
				currintervalend=interval[1];
			}
		}
		
		
		
		return outputArr.toArray(new int[outputArr.size()][]);
		

	/*	List<List<Integer>> list = Arrays.stream(intervals)
				.map(row -> IntStream.of(row).boxed().collect(Collectors.toList())).collect(Collectors.toList());*/

		

		// List<List<Integer>> listInt=
		// Arrays.stream(intervals).map(r->IntStream.of(row).boxed().collect(Collectors.toList())).collect(Collectors.toList())
		// .forEach(r->Arrays.asList(r)).map(Arrays::asList).collect(Collectors.toList());

		// List<List<Integer>> listInt=
		// Arrays.stream(intervals).<List<Integer>>map(Arrays::asList).collect(Collectors.toList());
		// Arrays.asList(intervals);
		// Arrays.asList(intervals);

		// start processing this array and keep merging intervals - where end time of
		// selected interval is between start and end time (including the start and end
		// time)

		// overlap condition end1<=beg2

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
