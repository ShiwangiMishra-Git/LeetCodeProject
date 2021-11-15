import java.util.*;

import javax.xml.parsers.SAXParser;

public class ReconstructOriginalDigitsfromEnglish423 {

	public ReconstructOriginalDigitsfromEnglish423() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//char[] count = new char[26 + (int)('a')]; - build char[] with small alphbets ascii value as index and frequency in value
		//Uniquely identify letters to find out which is the digit - eg: letter "w" is present only in "two"
		// and based upon the count of this letter we can identify number of times the digits is present in the string 
		// int[] out = new int[10]; and save it in int array of size 10. each index represent digit and value its occurrence count
		// iterate through this int array and print the digit number of times its value/occurance in int[]. building output string of digits 00111222 etc based upon this  
		
				 String para = "owoztneoerowoztneoer";
			        System.out.println(" Reconstructed Original Digits from English are" +
			        		originalDigits(para));

	}
	 public static String originalDigits(String s) {
		 
		 String result=""; 
		 
	     char[] count = new char[26 + (int)('a')];
	 
	     // building hashmap letter -> its frequency
	     for(char letter: s.toCharArray()) {
	      count[letter]++;
	      }
	     // building hashmap digit -> its frequency
	     int[] out = new int[10];
	     
	     out[0] = count['z'];
	     // letter "w" is present only in "two"
	     out[2] = count['w'];
	     // letter "u" is present only in "four"
	     out[4] = count['u'];
	     // letter "x" is present only in "six"
	     out[6] = count['x'];
	     // letter "g" is present only in "eight"
	     out[8] = count['g'];
	     // letter "h" is present only in "three" and "eight"
	     out[3] = count['h'] - out[8];
	     // letter "f" is present only in "five" and "four"
	     out[5] = count['f'] - out[4];
	     // letter "s" is present only in "seven" and "six"
	     out[7] = count['s'] - out[6];
	     // letter "i" is present in "nine", "five", "six", and "eight"
	     out[9] = count['i'] - out[5] - out[6] - out[8];
	     // letter "n" is present in "one", "nine", and "seven"
	     out[1] = count['n'] - out[7] - 2 * out[9];
	     
	     // building output string
	     StringBuilder output = new StringBuilder();
	     for(int i = 0; i < 10; i++)
	       for (int j = 0; j < out[i]; j++)
	         output.append(i);
	     return output.toString();
	 }
	 
	 
	 public static String originalDigitsmine(String s) {
			
		  Map<Character, Integer> charMap= new HashMap<Character,Integer> ();
		  char[] arr= s.toCharArray();
		  
		  String result="";
		  
		  for(int i=0;i<=arr.length-1;i++)
		  {
			  if(!charMap.containsKey(arr[i]))
			  {
				  
				  charMap.put(arr[i],1);
			  }
			  else {
				  charMap.put(arr[i],charMap.get(arr[i])+1);	  
			  }
		  }
		   
		  
		  //search for zero
		 if(charMap.containsKey('z'))
		 {	 
			 int countz=0;
			 int counte=0;
			 int countr=0;
			 int counto=0;

			 countz=charMap.get('z');
			 
			 if(charMap.containsKey('e'))
			 {
				 counte=charMap.get('e');}
			 
			 if(charMap.containsKey('r'))
			 {
				 countr=charMap.get('r');}
			 
			 if(charMap.containsKey('o'))
			 {
				 counto=charMap.get('o');}
			 
			 if(countz>0 && counte>0 && countr>0 && counto>0)
			 {
				 charMap.put('z',charMap.get('z')-1);
				 charMap.put('e',charMap.get('e')-1);
				 charMap.put('r',charMap.get('r')-1);
				 charMap.put('o',charMap.get('o')-1);
				 result=result+"0";
			 }			
		 }
		 
		 
		//search for one
		 if(charMap.containsKey('o'))
		 {	 
			 int counto=0;
			 int countn=0;
			 int counte=0;

			 counto=charMap.get('o');
			 
			 if(charMap.containsKey('n'))
			 {
				 countn=charMap.get('n');}
			 
			 if(charMap.containsKey('e'))
			 {
				 counte=charMap.get('e');}
			 
			 if(counto>0 && countn>0 && counte>0)
			 {
				 charMap.put('o',charMap.get('o')-1);
				 charMap.put('n',charMap.get('n')-1);
				 charMap.put('e',charMap.get('e')-1);
				 result=result+"1";
			 }			
		 }
		 
		  //search for two
		 if(charMap.containsKey('t'))
		 {	 
			 int countt=0;
			 int countw=0;
			 int counto=0;

			 countt=charMap.get('t');
			 
			 if(charMap.containsKey('w'))
			 {
				 countw=charMap.get('w');}
			 
			 if(charMap.containsKey('o'))
			 {
				 counto=charMap.get('o');}
			 
			 if(countt>0 && countw>0 && counto>0)
			 {
				 charMap.put('t',charMap.get('t')-1);
				 charMap.put('w',charMap.get('w')-1);
				 charMap.put('o',charMap.get('o')-1);
				 result=result+"2";
			 }			
		 }
		  
		
		  return result;
		   
	    }

}
