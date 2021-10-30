import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumCosttoCutaStick1547 {

	public MinimumCosttoCutaStick1547() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cuts[] = new int[] { 1, 3, 4, 5 };
		int size = 7;
		System.out.println("Minimum Obtainable Value is " + minCost(size, cuts));
	}

	public static int minCost(int n, int[] cuts) {
		var c = new ArrayList<Integer>();
		for (int cut : cuts)
			c.add(cut);
		c.addAll(Arrays.asList(0, n));
		Collections.sort(c);

		c.stream().forEach(x -> System.out.print(x + ","));
		int[][] dp = new int[c.size()][c.size()];

		for (int i = 0; i <= c.size() - 1; ++i) {
			System.out.println("i:" + i);
			{
				for (int j = i - 1; j >=0; --j) {
					System.out.println("j:" + j);
					for (int k = i - 1; k > j; --k) {
						System.out.println("dpO:" + dp[i][j]);
						System.out.println("k:" + k);
						dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j],
								c.get(i) - c.get(j) + dp[i][k] + dp[k][j]);
						System.out.println("dpn:" + dp[i][j]);
						System.out.println("");
					}
				}
			}
		}
		return dp[c.size() - 1][0];

	}

}
