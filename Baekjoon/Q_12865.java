import java.util.*;
import java.io.*;

public class Q_12865 {
    	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

        st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
        int[] w = new int[N+1];
        int[] v = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - w[i] >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]] + v[i]);
            }
        }

        bw.write(dp[N][K] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
