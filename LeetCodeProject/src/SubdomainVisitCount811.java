import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SubdomainVisitCount811 {

	public SubdomainVisitCount811() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String[] input = {"9001 discuss.leetcode.com"};
      
      System.out.println(" SubdomainVisitCount" +
    		  subdomainVisits(input));
	}
	
	  public static List<String> subdomainVisits(String[] cpdomains) {
		 
		 Map<String,Integer> resultmap=new HashMap<String,Integer>();
		for(int i=0;i<cpdomains.length;i++)
		{
			String[] arr = cpdomains[i].split("\\s+");
			String[] dotfragments = arr[1].split("\\.+");
			int count=Integer.valueOf(arr[0]);
			
			String strwithdotcom="";
			for(int i1=dotfragments.length-1;i1>=0;i1--) {
				if(i1==dotfragments.length-1)
				{
					strwithdotcom= dotfragments[i1];
				}
				else {
					strwithdotcom=dotfragments[i1]+ "."+strwithdotcom;
				}
			    
				if(resultmap.containsKey(strwithdotcom))
				{
					resultmap.put(strwithdotcom,resultmap.get(strwithdotcom)+count);
				}
				else {
					resultmap.put(strwithdotcom,count);
				}
			}
		}
		
		List<String> resultList= new ArrayList<String> (); 
		
		for(Map.Entry<String,Integer> e:resultmap.entrySet())
		{
			resultList.add(e.getValue()+" "+e.getKey());
		}  

		return resultList;
	    }

}
