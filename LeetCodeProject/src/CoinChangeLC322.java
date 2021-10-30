
public class CoinChangeLC322 {
	//unbounded KP
	public CoinChangeLC322() {
		
		// TODO Auto-generated constructor stub
		
	}
	
    public static int coinChange(int[] coins, int amount) {
        
        int[][] minCoins=new int[coins.length+1][amount+1];
		
		//initialization
		
		
		// bottom up DP(replacement of top down recursive function)
		//base: if n=0 or cuts.len=0 return 0;
		
		//for amount=0 //no coins needed
	    for(int i=0;i<minCoins.length;i++)
	    {
	    	minCoins[i][0]=0;
	    }
	    
	    //for coins.len=0
	    for(int j=1;j<minCoins[0].length;j++)
	    {
	    	minCoins[0][j]=Integer.MAX_VALUE-1;
	    	//(we are using Integer.MAX_VALUE-1 because in line number 46 if we add 1 it will become Integer.MAX_VALUE which is the max int can hole else it would exceed and overflow will happen)
	    	//line number 47: Math.min(1+(Integer.MAX_VALUE-1),Integer.MAX_VALUE-1 or any other value) will make sure we store anything lesser than Integer.MAX_VALUE in our minCoins grid for that coin selection
	    }
	    
	    //if only one coin is available
	    for(int j=1;j<minCoins[0].length;j++)
	    {
	    	minCoins[1][j]=
	    			(j%coins[0]==0)? (j/coins[0]):(Integer.MAX_VALUE-1); //j(which is the current amount)%coins[0] //if only one coin is available
	    }
	   
		//recursion
	    for(int i=2;i<minCoins.length;i++) //current coin
	    {
	    	for(int j=1;j<minCoins[0].length;j++) //current amount
		    {
	    		//check if j(current sum) which is the amount is less than coins[i-1]
	    		minCoins[i][j]
	    				= (coins[i-1]<=j)?
	    						Math.min( //to find the min number of coins
	    						1+minCoins[i][j- coins[i-1]]//can include - included one coin added + minCoins[same available options][remaining value]
	    								,minCoins[i-1][j]) //can include - but don't include minCoins[available options excluding current (i)][original sum value (j)]
	    						:minCoins[i-1][j] ; //can't include - as cut length(i) is more than j(rod length)   -  minCoins[available options excluding current (i)][original sum value (j)]
		    }	
	    }
	
		
		
	    return minCoins[coins.length][amount]==Integer.MAX_VALUE-1?-1: minCoins[coins.length][amount]; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				 int coins[] = new int[] {1, 2,5};
			        int amount = 11;
			        System.out.println("Minimum coins needed are " +
			        		coinChange(coins, amount));

	}

}
