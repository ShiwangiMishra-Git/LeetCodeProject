import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII253 {

	public MeetingRoomII253() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int minMeetingRooms(int[][] intervals) {
	       //sort meetings with start time
		   //so that while processing we know that if the current meeting start time is later than the root of min heap discussed below than any other meeting coming after this is the list will also be in conflict and would need a new room
		 
		 //process one by one (event e1)
		 // while processing put the end time in the  min heap(priority queue in case of java) so othat we can pull the earlist ending meeting 
		       //if the e1 start time is after the min priority queue root event end time then we can reuse its room. so remove top element front queue.
		       // else we need a new room so increase the roomcount by one.
		    //Add e1's end time in the queue

		 Arrays.sort(intervals,new Comparator<int[]>()
		 {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
			 
		 });
		 
		 int roomcount=0;
		 
		 PriorityQueue<Integer> endtimings = new  PriorityQueue<Integer>();
		 endtimings.add(intervals[0][1]);
		 roomcount++;
		 
		 for(int i=1;i<intervals.length;i++)
		 {
			 
			 if(intervals[i][0]< endtimings.peek().intValue())
			 {
				 roomcount++; 
				 
			 }
			 else {
				 endtimings.poll();
			 }
			 endtimings.add(intervals[i][1]);	 
		 } 
		 
		 return roomcount;
	    }
}
