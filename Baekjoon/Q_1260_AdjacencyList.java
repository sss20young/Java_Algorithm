import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1260_AdjacencyList {
	static ArrayList<Integer> dfs_result = new ArrayList<Integer>();
	static ArrayList<Integer> bfs_result = new ArrayList<Integer>();
	static int[] visited; // 방문 여부 체크
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
		
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) { // N+1개 생성
			array.add(new ArrayList<Integer>());
		}
		
		int x, y;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			array.get(x).add(y);
			array.get(y).add(x);
		}
		
		for (int i = 1; i <= N; i++)
			Collections.sort(array.get(i));
		
		visited = new int[N+1];
		DFS(array, V);
		
		visited = new int[N+1]; // 방문 초기화
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
	
	public static void DFS(ArrayList<ArrayList<Integer>> arr, int start) {
		visited[start] = 1;
		dfs_result.add(start);
		
		// 모든 노드 방문했는지 확인
		for (int i = 0; i < arr.get(start).size(); i++) {
			if (visited[arr.get(start).get(i)] == 0)
				DFS(arr, arr.get(start).get(i));
		}
	}
	
	public static void BFS(ArrayList<ArrayList<Integer>> arr, int start) {
		visited[start] = 1;
		queue.offer(start);

		while(!queue.isEmpty()) {
			int x = queue.poll();
			bfs_result.add(x);
			
			// 모든 노드 방문했는지 확인
			for (int i = 0; i < arr.get(x).size(); i++) {
				if (visited[arr.get(x).get(i)] == 0 && !queue.contains(arr.get(x).get(i))) {
					queue.offer(arr.get(x).get(i));
					visited[arr.get(x).get(i)] = 1;
				}
			}
		}
	}
}
