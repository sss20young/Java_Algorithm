import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_10814 {
	static int[] array_age, sorted_age;
	static String[] array_name, sorted_name;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 첫째 줄에 수의 개수 N(1 ≤ N ≤ 100,000)이 주어진다.
        int N = Integer.parseInt(br.readLine());
		
        // 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이다.
        array_age = new int[N];
        array_name = new String[N];
        sorted_age = new int[N];
        sorted_name = new String[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			array_age[i] = Integer.parseInt(st.nextToken());
			array_name[i] = st.nextToken();
		}
		
		mergesort(0, N -1);
		
		for (int i = 0; i < N; i++) {
			sb.append(array_age[i] + " " + array_name[i]).append('\n');
		}
		
		System.out.println(sb);	
	}
	
	static void merge(int left, int mid, int right) {		
		int i = left, j = mid + 1, k = left;
		
		while(j <= right || i <= mid) {
			if (j <= right && i <= mid) {
				if (array_age[i] > array_age[j]) {
					sorted_age[k] = array_age[j];
					sorted_name[k] = array_name[j];
					j++;
				} else if (array_age[i] <= array_age[j]) {
					sorted_age[k] = array_age[i];
					sorted_name[k] = array_name[i];
					i++;
				}
			} else if (j <= right) { // right만 남은 상황
				sorted_age[k] = array_age[j];
				sorted_name[k] = array_name[j];
				j++;
			} else if (i <= mid) { // left만 남은 상황
				sorted_age[k] = array_age[i];
				sorted_name[k] = array_name[i];
				i++;
			}
			
			k++;
		}

		// 복제
		for (int l = left; l <= right; l++) {
			array_age[l] = sorted_age[l];
			array_name[l] = sorted_name[l];
		}
	}
	
	// 안정 정렬 중 병합 정렬
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
