import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_2606 {
	static int v;
	static int[][] array;
	static int[] visited;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		v = Integer.parseInt(br.readLine()); // 컴퓨터의 수 == 노드 혹은 정점
		int e = Integer.parseInt(br.readLine()); // 직접 연결되어 있는 컴퓨터 쌍의 수 == 엣지 혹은 링크
		
		array = new int[v+1][v+1];
		int x, y;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			array[x][y] = array[y][x] = 1;
		}
		
		visited = new int[v+1];
		DFS(1);
		
		System.out.print(result.size() - 1); // 1 제외
		
	}
	
	static void DFS(int node) {
		visited[node] = 1;
		result.add(node);
		
		for (int i = 1; i <= v; i++) {
			if (array[node][i] == 1 && visited[i] == 0) {
				DFS(i);
			}
		}
		
	}
}
