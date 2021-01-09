import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2468 {
	static int N;
	static int[][] array, visited;
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		int max_height = 1;
		// 건물의 최대 높이 구하기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, array[i][j]);
			}
		}
		
		int result = 1;
		int place = 0; // 잠기지 않은 지역 개수
		for (int h = 1; h < max_height; h++) { // 건물의 높이는 1 이상 max_height 이하의 정수
			// 높이가 달라질 때마다 visited와 place 초기화
			visited = new int[N][N];
			place = 0;
			
			for (int i = 0; i < N; i++) { // N X N BFS 순회
				for (int j = 0; j < N; j++) {
					if (array[i][j] <= h) // 높이 이하이면 방문한걸로 여김
						visited[i][j] = 1;
					else if (array[i][j] > h && visited[i][j] == 0) { // 방문하지 않았으면
						BFS(i, j, h);
						place++;
					}
				}
			}
			
			result = Math.max(result, place);
		}
		
		System.out.print(result);
	}
	
	static void BFS(int i, int j, int height) {
		visited[i][j] = 1;
		
		for (int k = 0; k < 4; k++) {
			if (i+x[k] >=0 && j+y[k] >= 0 && i+x[k] < N && j+y[k] < N) {
				if (array[i+x[k]][j+y[k]] > height && visited[i+x[k]][j+y[k]] == 0) {
					BFS(i+x[k], j+y[k], height);
				}
			}
		}
	}
}
