import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1398 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		long n; // 테스트 케이스를 받아 처리할 변수 // 10^15으로 타입은 long형
		int ans[] = new int[T];
		
		// 1, 10, 25 / 100, 1000, 2500 / 10000, 100000, 250000 / ...
		int coin[] = {1, 10, 25};
		int dp[] = new int[100];
		for (int i = 1; i <= 99; i++) {
			dp[i] = i;
			for (int j : coin) {
				if (i - j >= 0) {
					dp[i] = Math.min(dp[i], dp[i-j] + 1);
				}
			}
		}
		
//		이 경우, 59일 때 예외가 발생함
//		for (int i = 1; i <= 99; i++) {
//			if (i < 10)
//				dp[i] = i;
//			else if (i < 25)
//				dp[i] = i/10 + dp[i%10];
//			else 
//				dp[i] = i/25 + dp[i%25];
//		}
		
		
		for (int i = 0; i < T; i++) {
			n = Long.parseLong(br.readLine()); // string to long
			
			while (n > 0) {
				ans[i] = ans[i] + dp[(int)(n%100)];
				n = n/100;
			}
		}
		
		for (int i = 0; i < T; i++) {
			System.out.println(ans[i]);
		}
	}
}
