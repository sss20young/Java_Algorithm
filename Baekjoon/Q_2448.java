import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2448 {
	static char[][] array;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		array = new char[N][N/3*6-1];
		// 배열 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N/3*6-1; j++) {
				array[i][j] = ' ';
			}
		}
		
		int j_start = ((N/3)*6-1)/2; // 시작점
		DrawStars(0, N-1, j_start);
		
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N/3*6-1; j++) {
				sb.append(array[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void DrawStars(int i_start, int i_end, int j) { // j는 삼각형 그리는 시작 위치
		if (i_end - i_start == 2) { // 삼각형 그리기
			array[i_start][j] = '*';
			array[i_start+1][j-1] = '*';
			array[i_start+1][j+1] = '*';
			array[i_start+2][j-2] = '*';
			array[i_start+2][j-1] = '*';
			array[i_start+2][j] = '*';
			array[i_start+2][j+1] = '*';
			array[i_start+2][j+2] = '*';
			return;
		} else if (i_start < i_end) { // 3등분 나누기
			int i_length = (i_end - i_start) / 2;
			int j_length = (i_end - i_start +1) / 2;
			
			DrawStars(i_start, i_start + i_length, j);
			DrawStars(i_start + i_length + 1, i_end, j-j_length);
			DrawStars(i_start + i_length + 1, i_end, j+j_length);
		}
	}
}
