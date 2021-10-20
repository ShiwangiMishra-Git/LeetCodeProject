import java.util.Arrays;

public class MedianofTwoSortedArrays {

	public MedianofTwoSortedArrays() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
      System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));

	}
	
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 
		 double median=0;
		 int m=nums1.length;
		 int n=nums2.length;
		 int first=0;
		 int second=0;
		 int count=0;
		 int mergedcount=(n+m)/2+1;
		 int[] merged=new int[mergedcount];
		 while(first<m && second<n && count<mergedcount)
		 {
			 int min=Math.min(nums1[first], nums2[second]);
			 merged[count]=min;
			 count++;
			 if(min==nums1[first])
			 {
				 first++;
			 }
			 else {
				 second++;
			 }
		 } 
		 
		 while(count<mergedcount)
		 {
			 if(first<m)
			 {
				 merged[count]=nums1[first];
				 count++;
				 first++;
				 //iterate first
			 }
			 else {
				 merged[count]=nums2[second];
				 count++;
				 second++;
				//iterate second
			 }
		 }
		 
		
		 
		 if((m+n)%2==0)
		 {
			//even
			 System.out.println("even");
			 System.out.println("mergedcount: "+count);
			 median=(double)(merged[count-2]+merged[count-1])/2;
		 }
		 else
		 {
			 System.out.println("odd");
			 median=merged[count-1];
			//odd
		 }
	
		 Arrays.stream(merged).forEach(x->System.out.println(x));
		 
		 return median;
		 
		 
		
	        //nums1 has m and nums2 has n elements
	        //m+n  odd then median =element(n+m/2)
	        //m+n even  then(m+n/2 + m+n-1/2)/2
	       // 
	        
	        //ccompare elements in both arrays
	        
	        // get  int len= min(n,m)
	        
	        
	        
	        //while array 1 is not over, keep cpmaring
	        
	        //while array 2 is not over keep cpmparing
	        
	        //if ar
	    }

}
