import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_5639 {
	static int[][] array = new int[1000000][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int root = Integer.parseInt(br.readLine()); // root node
		
		String line = null;
		int node;
		
		// while (!(line = br.readLine()).equals("")) { // -> 런타임 에러
		while ((line = br.readLine()) != null && line.length() != 0) {
			node = Integer.parseInt(line);
			adjacencyMatrix(root, node);
		}
		
		postorderTraversal(root);
	}
	
	// 인접 행렬 생성
	static void adjacencyMatrix (int start, int input) {
		if (input < start) {
			if (array[start][0] == 0)
				array[start][0] = input;
			else 
				adjacencyMatrix(array[start][0], input);
		} else {
			if (array[start][1] == 0)
				array[start][1] = input;
			else
				adjacencyMatrix(array[start][1], input);
		}
	}
	
	// 후위 순회
	static void postorderTraversal (int node) {
		if (array[node][0] != 0) {
			postorderTraversal(array[node][0]);
		}
		if (array[node][1] != 0) {
			postorderTraversal(array[node][1]);
		}
		System.out.println(node);
	}
}
