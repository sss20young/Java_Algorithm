import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10989 {
	static int MAX = 0;

	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
        int N = Integer.parseInt(br.readLine());
		
	// 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 10,000보다 작거나 같은 정수이다.
        int[] array = new int[N];
        int[] result;
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
			MAX = Math.max(array[i], MAX);
		}
				
		result = new int[N];
		
		countingsort(array, result);
		
		for (int i : result) {
			sb.append(i).append('\n');
		}
		
		System.out.println(sb);	
	}
	
	// 카운팅 정렬
	static int[] countingsort(int[] array, int[] result) {
		int[] counting = new int[MAX+1];
		
		// STEP 1
		for (int i = 0; i < array.length; i++) {
			counting[array[i]]++;
		}
		
		// STEP 2
		for (int i = 1; i < counting.length; i++) {
			counting[i] = counting[i-1] + counting[i];
		}	

		// STEP 3
		for (int i = array.length-1; i >= 0; i--) {
			counting[array[i]] = counting[array[i]] - 1;
			result[counting[array[i]]] = array[i];
		}
		
		return result;
	}
}
