import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2263 {
	static int[] inorderList, postorderList, inorderList_rootIndex;

	public static void main(String[] args) throws IOException {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	StringTokenizer st;
        
        	int n = Integer.parseInt(br.readLine()); // 정점의 개수
        
        	// 중위 순회
		inorderList = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inorderList[i] = Integer.parseInt(st.nextToken());
		}

		// 후위 순회
		postorderList = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			postorderList[i] = Integer.parseInt(st.nextToken());
		}

		// 중위 순회에서 root index
		inorderList_rootIndex = new int[n+1];
		for (int i = 0; i < n; i++) {
			inorderList_rootIndex[inorderList[i]] = i;
		}

		findRoot(0, n-1, 0, n-1);
        
	}
	
	static void findRoot(int in_start, int in_end, int post_start, int post_end) {
		if (in_start > in_end || post_start > post_end) return;
		
		int root = postorderList[post_end]; // 후위 순회를 통해 root 찾기 -> 후위 순회의 마지막 노드가 root 노드
		System.out.print(root + " ");
		
		int index = inorderList_rootIndex[root]; // 중위 순회에서 노드가 root인 노드의 index
		
		int left_length = index - in_start; // 중위 순회에서 루트 기준 왼쪽 인덱스 개수

		findRoot(in_start, index - 1, post_start, post_start + left_length - 1);
		findRoot(index + 1, in_end, post_start + left_length, post_end - 1);
	}
}
