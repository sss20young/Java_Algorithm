import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2751 {
	static int array[], sorted[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
		int N = Integer.parseInt(br.readLine());

		// 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
		array = new int[N];
		sorted = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		mergesort(0, array.length - 1); // 0 ~ array.length-1 인덱스

		for (int i : array) {
			sb.append(i).append('\n');
		}

		System.out.println(sb);		
	}
	
	static void merge(int left, int mid, int right) {		
		int i = left, j = mid + 1, k = left;
		
		while(j <= right || i <= mid) {
			if (j <= right && i <= mid) {
				if (array[i] > array[j]) {
					sorted[k] = array[j];
					j++;
				} else if (array[i] <= array[j]) {
					sorted[k] = array[i];
					i++;
				}
			} else if (j <= right) { // right만 남은 상황
				sorted[k] = array[j];
				j++;
			} else if (i <= mid) { // left만 남은 상황
				sorted[k] = array[i];
				i++;
			}
			
			k++;
		}

		// 복제
		for (int l = left; l <= right; l++) {
			array[l] = sorted[l];
		}
	}
	
	// 합병 정렬
	static void mergesort(int left, int right) {
		int mid;
		
		if (left < right) {
			mid = (left + right) / 2;
			mergesort(left, mid);
			mergesort(mid+1, right);
			merge(left, mid, right);
		}
	}
}
