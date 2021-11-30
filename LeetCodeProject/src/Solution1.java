import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findLowestPrice' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY products
     *  2. 2D_STRING_ARRAY discounts
     */

    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {
    // Write your code here
    int t=0;
    
    HashMap<String,Discount> map=new  HashMap<>();
   for(List<String> disc:discounts)
  {
      map.put(disc.get(0),new Discount(disc.get(0), Integer.valueOf(disc.get(1)), Integer.valueOf(disc.get(2))));
  } 
  for(List<String> pro:products)
  {
      int price=Integer.valueOf(pro.get(0));
      int changePrice=price;
      
   for(int i=0;i<pro.size();i++)
   {
      changePrice=Math.max(changePrice, getPrice(map,price,pro.get(i)));       
   }
   t+=changePrice;
  }
  
 return t;

    }
   public static int getPrice(HashMap<String,Discount> map,int price,String discName)
   {
       if(discName.isEmpty()||discName.equals("Empty"))
       return price;
       
       Discount dis=map.get(discName);
       if(dis.type==0) return dis.amount;
       else if(dis.type==1) return (1-(dis.amount/100))*price;
       else return price-dis.amount;
       
       
   } 
    
  

}
 class Discount
  {
      String name;
      int type;
      int amount;
    Discount(String name,int type,int amount)
    {
        this.name=name;
        this.type=type;
        this.amount=amount;
    }
  }

public class Solution {