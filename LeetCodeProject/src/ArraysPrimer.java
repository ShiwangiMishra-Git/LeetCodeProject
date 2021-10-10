import java.util.Arrays;
import java.util.Scanner;

public class ArraysPrimer {

	public ArraysPrimer() {

		/*
		 * An array is a data structure that stores a collection of values of the same
		 * type.The array length need not be a constant: new int[n] creates an array of
		 * length n. Once you create an array, you cannot change its length (although
		 * you can, of course, change an individual array element). If you frequently
		 * need to expand the length of arrays while your program is running, you should
		 * use array lists, int[] smallPrimes = { 2, 3, 5, 7, 11, 13 }; You can use this
		 * syntax to reinitialize an array without creating a new variable. int[]
		 * anonymous = { 17, 19, 23, 29, 31, 37 }; Note that an array of length 0 is not
		 * the same as null. smallPrimes = anonymous; It is an advantage to have such an
		 * array, especially in Java, so you can return a valid array and guarantee that
		 * your length check never fails. When you create an array of numbers, all
		 * elements are initialized with zero. Arrays of boolean are initialized with
		 * false. Arrays of objects are initialized with the special value null, which
		 * indicates that they do not (yet) hold any objects. This can be surprising for
		 * beginners
		 * 
		 * 
		 * You can copy one array variable into another, but then both variables refer
		 * to the same array:
		 * 
		 * int[] luckyNumbers = smallPrimes; luckyNumbers[5] = 12; // now smallPrimes[5]
		 * is also 12 If you actually want to copy all values of one array into a new
		 * array, use the copyOf method in the Arrays class: The additional elements are
		 * filled with 0 if the array contains numbers, false if the array contains
		 * boolean values. Conversely, if the length is less than the length of the
		 * original array, only the initial values are copied.
		 * 
		 * Arrays.sort(a);= This method uses a tuned version of the QuickSort algorithm
		 * that is claimed to be very efficient on most data sets. Math.random(n) 0 to <
		 * n floating point numbers
		 * 
		 * multi dmentionanl array:
		 * int[][] odds = new int[NMAX + 1][n]
		 * 
		 * ragged array: 
		 * int[][] odds = new int[NMAX + 1][];
		 * for (int n = 0; n <= NMAX; n++)
                odds[n] = new int[n + 1];
		 */

		// TODO Auto-generated constructor stub

	}

	public static void main(String[] args) {
		System.out.println("hi");

		// iterating
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);

		for (int e : a)
			System.out.println(e);

		System.out.println(Arrays.toString(a));

		for (int i = 0; i < a.length; i++)
			a[i] = i + 1;

		// copying
		int[] b = a;
		for (int i = 0; i < a.length; i++)
			a[i] = +1;

		System.out.println("b is: " + Arrays.toString(b));
		System.out.println("a is: " + Arrays.toString(a));

		int[] c = Arrays.copyOf(a, 10);
		for (int i = 0; i < a.length; i++)
			a[i] = a[i] + 1;

		System.out.println("a is: " + Arrays.toString(a));
		System.out.println("b is: " + Arrays.toString(b));
		System.out.println("c is: " + Arrays.toString(c));
		// int[] luckyNumbers = smallPrimes;
		// luckyNumbers[5] = 12; // now smallPrimes[5] is also 12

		// Sorting (Lottery Drawing example)
		/* Scanner in = new Scanner(System.in);

		System.out.print("How many numbers do you need to draw? ");
		int k = in.nextInt();

		System.out.print("What is the highest number you can draw? ");
		int n = in.nextInt();

		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = i + 1;

		int[] result = new int[k];

		for (int i = 0; i < result.length; i++) {

			// make a random index between 0 and n - 1
			int r = (int) (Math.random() * n);

			// pick the element at the random location
			result[i] = numbers[r];

			// move the last element into the random location
			numbers[r] = numbers[n - 1];
			n--;
		}

		Arrays.sort(result);
		System.out.println("Bet the following combination. It'll make");

		for (int r : result)
			System.out.println(r);*/

		double[][] balances;

		balances = new double[10][6];

		for (int j = 0; j < balances[0].length; j++)
			balances[0][j] = 10000;

		for (int i = 1; i < balances.length; i++) {
			for (int j = 0; j < balances[i].length; j++) {
				double oldBalance = balances[i - 1][j];
				double interest = oldBalance * 0.10;
				balances[i][j] = oldBalance + interest;
			}
		}
		
		for(double[] arr: balances)
		{
			System.out.println("interest is: " + Arrays.toString(arr));
			for(double value: arr)
			{
				System.out.printf("interest is: %.2f " ,  value);
				System.out.printf("interesttt is: %10.5f " ,  value);
			}
		}
		System.out.println("interest is: " + Arrays.deepToString(balances));
	}

}
