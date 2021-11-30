import java.io.*;
import java.util.*;

class calcDroneMinEnergyClass {

  static int calcDroneMinEnergy(int[][] route) {
    // your code goes here
    //run time O(n)
	  //space O(1)
    int minen=0;
    
    int enInHand=0;
    //go through the array
    for(int i=1;i<route.length;i++)
    {
      int enspent = route[i-1][2] -route[i][2];
     
      enInHand += enspent;
      
      if(enInHand<0)
      {
    	  minen=-(enInHand);
        enInHand+=-(enInHand);
        
      }
      
    }
    return minen;
  }

  public static void main(String[] args) {
	  System.out.println(calcDroneMinEnergy(new int[][] 
              {{0,2,6},{10,10,20}}));

  }

}