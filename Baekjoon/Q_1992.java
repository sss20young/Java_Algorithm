import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1992 {
	static int N;
	static int[][] array;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		String s;
		
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				array[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		
		divide(0, N-1, 0, N-1);
		
		System.out.print(sb);
	}
	
	public static void divide(int i_start, int i_end, int j_start, int j_end) {
		if (check(i_start, i_end, j_start, j_end)) { // 해당 영역의 숫자들이 모두 같으면
			sb.append(array[i_start][j_start]);
		} else {
			int i_mid = (i_start + i_end) / 2;
			int j_mid = (j_start + j_end) / 2;
			
			sb.append('(');
			divide(i_start, i_mid, j_start, j_mid);
			divide(i_start, i_mid, j_mid+1, j_end);
			divide(i_mid+1, i_end, j_start, j_mid);
			divide(i_mid+1, i_end, j_mid+1, j_end);
			sb.append(')');
		}
	}
	
	// 모두 0인지 1인지 check
	public static boolean check(int i_start, int i_end, int j_start, int j_end) {
		int value = array[i_start][j_start];
		
		for (int i = i_start; i <= i_end; i++) {
			for (int j = j_start; j <= j_end; j++) {
				if (array[i][j] != value)
					return false;
			}
		}
		
		return true;
	}
}
