import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1182 {
	static int N, S;
	static int[] arr;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정수의 개수
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		if (S == 0) count--;
		
		System.out.print(count);
	}
	
	static void dfs(int i, int sum) { // arr의 i번째, 지금까지의 sum
		if (i == N) {
			if (sum == S) count++;
			return;
		}
		
		dfs(i+1, sum+arr[i]);
		dfs(i+1, sum);
	}
}
