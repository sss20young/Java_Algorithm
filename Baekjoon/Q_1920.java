import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_1920 {
	static int solution[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A); // 이분탐색을 위해 A배열을 정렬
		
		int M = Integer.parseInt(br.readLine());
		int guess[] = new int[M];
		solution = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			guess[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			binarySearch(A, guess[i], i);
		}
		
		for (int i = 0; i < M; i++) {
			System.out.println(solution[i]);
		}
	}
	
	public static void binarySearch(int[] array, int target, int count) { // 이분탐색

		int start = 0;
		int end = array.length - 1;
		int mid= (end + start)/2;

		while(end - start >= 0){

			if(array[mid] == target) {
				solution[count] = 1;
				return;
			} else if(array[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = (end + start)/2;
		} 

		solution[count] = 0;
		return;
	}
}
