import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2178 {
	static int N, M;
	static int[][] array, visited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[] x = { -1, 1, 0, 0 };
	static int[] y = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][M+1];
		String line;
		for (int i = 1; i <= N; i++) {
			line = br.readLine();
			for (int j = 1; j <= M; j++) {
				array[i][j] = Character.getNumericValue(line.charAt(j-1));
			}
		}
		
		visited = new int[N+1][M+1];
		BFS(1,1);
		
		System.out.print(array[N][M]);
	}
	
	static void BFS(int i, int j) {
		visited[i][j] = 1;
		queue.offer(new int[] {i, j});
		
		while (!queue.isEmpty()) {
			int[] map = queue.poll();
			
			for (int k = 0; k < 4; k ++) {
				if (map[0] + x[k] > 0 && map[0] + x[k] <= N && map[1] + y[k] > 0 && map[1] + y[k] <= M)
					if (array[map[0]+x[k]][map[1]+y[k]] == 1 && visited[map[0]+x[k]][map[1]+y[k]] == 0) {
						queue.add(new int[] {map[0] + x[k], map[1] + y[k]});
						visited[map[0] + x[k]][map[1] + y[k]] = 1;
						array[map[0]+x[k]][map[1]+y[k]] = array[map[0]][map[1]] + 1;
					}
				
			}
		}
	}
}
