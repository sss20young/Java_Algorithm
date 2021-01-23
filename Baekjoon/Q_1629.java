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
	
	// 첫번째 방법
	public static long divide(long A, long B, long C) {
		if (B == 0) return 1;
		if (B == 1) return A % C;
		
		long divide2 = divide(A, B/2, C); // 지수를 2로 나누기
		
		if (B % 2 == 0) { // 지수가 짝수이면
			return divide2 * divide2 % C;
		} else { // 지수가 홀수이면
			return (divide2 * divide2 % C) * A % C; // divide2 * divide2 * A % C -> long 범위 초과
		}
	}
	
	// 두번째 방법
	public static long divide_1(long A, long B, long C) {
		if (B == 0) return 1;
		if (B == 1) return A % C;
		
		if (B % 2 == 0) { // 지수가 짝수이면
			long divide2 = divide_1(A, B/2, C); // 지수를 2로 나누기
			return divide2 * divide2 % C;
		} else { // 지수가 홀수이면
			return divide_1(A, B-1, C) * A % C;
		}
	}
}
