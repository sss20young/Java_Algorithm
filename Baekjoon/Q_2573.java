import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2573 {
	static int N, M, place;
	static int[][] array, array2, visited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		array2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				array2[i][j] = array[i][j]; // deep copy
			}
		}
		
		
		int year = 0;
		place = 1; // 한 덩어리의 빙산이 주어짐
		
		while (place < 2) {
			
			int[] exist = Exist();
			
			if (exist[0] == 0 && exist[1] == 0) { // 만일 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력
				year = 0;
				break;
			}
			
			visited = new int[N][M]; // 방문 초기화
			BFSMelting(exist[0], exist[1]);
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					array[i][j] = array2[i][j]; // deep copy
				}
			}
			
			year++;
			
			// 덩어리 개수 세기
			CountingLump();
		}
		
		// 출력
		System.out.print(year);
	}
	
	public static void BFSMelting(int i, int j) {
		visited[i][j] = 1;
		queue.offer(new int[] { i, j });
		
		int[] position;
		int dx, dy;
		while(!queue.isEmpty()) {
			position = queue.poll();
			for (int k = 0; k < 4; k++) {
				dx = position[0] + x[k];
				dy = position[1] + y[k];
				if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
					if (array[dx][dy] > 0 && visited[dx][dy] == 0) {
						queue.add(new int[] { dx, dy });
						visited[dx][dy] = 1;
					}
					if (array[dx][dy] == 0 && array[position[0]][position[1]] > 0 && array2[position[0]][position[1]] > 0) {
						array2[position[0]][position[1]] -= 1;
					}
				}
			}
		}
	}
	
	public static void BFS(int i, int j) {
		visited[i][j] = 1;
		queue.offer(new int[] { i, j });
		
		int[] position;
		int dx, dy;
		while(!queue.isEmpty()) {
			position = queue.poll();
			for (int k = 0; k < 4; k++) {
				dx = position[0] + x[k];
				dy = position[1] + y[k];
				if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
					if (array[dx][dy] > 0 && visited[dx][dy] == 0) {
						queue.add(new int[] { dx, dy });
						visited[dx][dy] = 1;
					}
				}
			}
		}
	}
	
	public static void CountingLump() {
		visited = new int[N][M];
		place = 0;
		
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if (array[i][j] > 0 && visited[i][j] == 0) {
					BFS(i, j);
					place++;
				}
			}
		}
	}
	
	public static int[] Exist() {
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if (array[i][j] > 0 ) {
					return new int[] {i, j};
				}
			}
		}
		
		return new int[] {0, 0};
	}
}
