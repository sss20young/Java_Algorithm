import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1991 {
	static int[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		array = new int[N][2]; // 2는 left, right를 뜻함
		int node, left, right;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			node = st.nextToken().charAt(0) - 'A'; // char -> int
			
			left = st.nextToken().charAt(0);
			if (left != '.')
				array[node][0] = left - 'A';
			else
				array[node][0] = 0;
			
			right = st.nextToken().charAt(0);
			if (right != '.')
				array[node][1] = right - 'A';
			else
				array[node][1] = 0;				
		}
		
		preorderTraversal(0);
		System.out.println();
		inorderTraversal(0);
		System.out.println();
		postorderTraversal(0);
	}		
	
	// 전위 순회
	static void preorderTraversal(int node) {
		System.out.print((char)(node + 'A'));
		if (array[node][0] != 0)
			preorderTraversal(array[node][0]);
		if (array[node][1] != 0)
			preorderTraversal(array[node][1]);
	}
	
	// 중위 순회
	static void inorderTraversal(int node) {
		if (array[node][0] != 0)
			inorderTraversal(array[node][0]);
		System.out.print((char)(node + 'A'));
		if (array[node][1] != 0)
			inorderTraversal(array[node][1]);
	}
	
	// 후위 순회
	static void postorderTraversal(int node) {
		if (array[node][0] != 0)
			postorderTraversal(array[node][0]);
		if (array[node][1] != 0)
			postorderTraversal(array[node][1]);
		System.out.print((char)(node + 'A'));

	}
}
