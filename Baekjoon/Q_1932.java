import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1932 {
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[][] array = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp(array);
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, array[n-1][i]);
		}
		
		System.out.println(result);
	}
	
	static void dp(int[][] dp) {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j-1 >= 0)
					dp[i][j] = dp[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
				else
					dp[i][j] = dp[i][j] + dp[i-1][j];
				
			}
		}
	}
}
