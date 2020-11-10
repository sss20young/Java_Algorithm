import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2630 {
	static int N;
	static int array[][];
	static int blue_count, white_count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		array = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Divide_And_Conquer(0, 0, N, N);
		
		System.out.println(white_count);
		System.out.println(blue_count);
	}
	
	public static void Divide_And_Conquer(int width_start, int height_start, int width_end, int height_end) {
		
		int cnt = 0;
		for (int i = height_start; i < height_end; i++) {
			for (int j = width_start; j < width_end; j++) {
				if (array[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		if (cnt == (height_end-height_start)*(width_end-width_start))
			blue_count++;
		else if (cnt == 0)
			white_count++;
		else {
			Divide_And_Conquer(width_start, height_start, width_start+(width_end-width_start)/2, height_start+(height_end-height_start)/2); // 1사분면
			Divide_And_Conquer(width_start+(width_end-width_start)/2, height_start, width_end, height_start+(height_end-height_start)/2); // 2사분면
			Divide_And_Conquer(width_start+(width_end-width_start)/2, height_start+(height_end-height_start)/2, width_end, height_end); // 3사분면
			Divide_And_Conquer(width_start, height_start+(height_end-height_start)/2, width_start+(width_end-width_start)/2, height_end); // 4사분면
		} 
	}
}
