import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken()); // 밑
		long B = Integer.parseInt(st.nextToken()); // 지수
		long C = Integer.parseInt(st.nextToken()); // 나누는 수
		
		System.out.println(divide(A, B, C));
	}
	
	public static long divide(long A, long B, long C) {
		if (B == 0) return 1;
		if (B == 1) return A % C;
		
		long divide2 = divide(A, B/2, C); // 지수를 2로 나누기
		long d2 = divide2 * divide2 % C;
		
		if (B % 2 == 0) { // 지수가 짝수이면
			return d2;
		} else { // 지수가 홀수이면
			return d2 * A % C;
		}
	}
}
