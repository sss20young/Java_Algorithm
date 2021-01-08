import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1260_AdjacencyMatrix {
	static ArrayList<Integer> dfs_result = new ArrayList<Integer>();
	static ArrayList<Integer> bfs_result = new ArrayList<Integer>();
	static int[] visited;
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int array[][] = new int[N+1][N+1];
		int x, y;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			array[x][y] = array[y][x] = 1;
		}
		
		visited = new int[N+1];
		DFS(array, V);
		
		visited = new int[N+1];
		BFS(array, V);
		
		// 출력
		for (int i = 0; i < dfs_result.size(); i++) {
			System.out.print(dfs_result.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < bfs_result.size(); i++) {
			System.out.print(bfs_result.get(i) + " ");
		}
	}
	
	public static void DFS(int[][] arr, int start) {
		visited[start] = 1;
		dfs_result.add(start);
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[start][i] == 1 && visited[i] == 0)
				DFS(arr, i);
		}
	}
	
	public static void BFS(int[][] arr, int start) {
		visited[start] = 1;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			bfs_result.add(x);
			
			// 모든 노드 방문했는지 확인
			for (int i = 1; i < arr.length; i++) {
				if (arr[x][i] == 1 && visited[i] == 0 && !queue.contains(i)) {
					queue.offer(i);
					visited[i] = 1;
				}
			}
		}
	}
}
