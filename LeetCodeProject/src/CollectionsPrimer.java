
/*public class CollectionsPrimer {

	public CollectionsPrimer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("collections primer!!");
		

	}

}*/



import java.util.Scanner;

class CollectionsPrimer {
    public static boolean isHappyNumber(int n) {
        int rem=0;
        int result=0;
        while(n!=0)
        {
            rem=n%10;
            n=n/10; 
            result+=rem*rem;
        }
        int sum=0;
        while(result!=0)
        {
            rem=result%10;
            result=result/10; 
            sum+=rem;
            if(result==0 && sum/10!=0)
            {
                result=sum;
                sum=0;
            }
        }
        if(sum==1)
        {
            return true;
        }
        // WRITE YOUR BRILLIANT CODE HERE
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      //  int n = Integer.parseInt(scanner.nextLine());
      //  scanner.close();
        boolean res = isHappyNumber(68);
        System.out.println(res);
    }
}
