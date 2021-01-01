import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_11725 {
	static int N;
	static ArrayList<ArrayList<Integer>> array;
	static int[] visited, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 노드의 개수
	
		// 인접 행렬 X
		// array = new int[N+1][N+1];
		
		// 인접 리스트 O
		array = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) { // N+1개 생성
			array.add(new ArrayList<Integer>());
		}
		
		int x, y;
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			array.get(x).add(y);
			array.get(y).add(x);
		}
		
		visited = new int[N+1];
		result = new int[N+1];
		DFS(1);
		
		// 출력
		for (int i = 2; i <= N; i++) {
			System.out.println(result[i]);
		}
	}
	
	// DFS로 부모 찾기
	static void DFS(int n) {
		visited[n] = 1;
		
		for (int i : array.get(n)) {
			if (visited[i] == 0) {
				result[i] = n; // i번째의 부모는 n
				DFS(i);
			}
		}
	}
}
