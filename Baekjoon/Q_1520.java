import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1520 {
	static int N, M;
	static int[][] array, dp;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int result = 0;
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(DFS(0,0));
	}
	
	public static int DFS(int i, int j) {
		if (i == N-1 && j == M-1)
			return 1;
		
		if (dp[i][j] != -1) { // 이미 방문함
			return dp[i][j];
		}
		
		dp[i][j] = 0;
		
		int dx, dy;
		for (int k = 0; k < 4; k++) {
			dx = i + x[k];
			dy = j + y[k];
			
			if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
				if (array[dx][dy] < array[i][j]) {
					dp[i][j] += DFS(dx, dy);
					
				}
			}
		}
		
		return dp[i][j];
	}
}
