import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1780 {
	static int[][] array;
	static int[] count = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, N-1, 0, N-1);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(count[i]);
		}
	}
	
	public static void divide(int i_start, int i_end, int j_start, int j_end) {
		if (check(i_start, i_end, j_start, j_end)) {
			int value = array[i_start][j_start] + 1;
			count[value] += 1;
			return;
		} else if (i_start < i_end && j_start < j_end){
			int length = (i_end - i_start + 1) / 3;
			
			for (int i = 0; i < 3; i++) { // 9등분
				for (int j = 0; j < 3; j++) {
					divide(i_start+length*i, i_start+length*(i+1)-1, j_start+length*j, j_start+length*(j+1)-1);
				}
			}
		}
	}
	
	// 모두 -1인지 혹은 모두 0인지 혹은 모두 1인지 check
	public static boolean check(int i_start, int i_end, int j_start, int j_end) {
		int value = array[i_start][j_start]; // 영역의 시작점
		
		for (int i = i_start; i <= i_end; i++) {
			for (int j = j_start; j <= j_end; j++) {
				if (array[i][j] != value)
					return false;
			}
		}
		
		return true;
	}
}
