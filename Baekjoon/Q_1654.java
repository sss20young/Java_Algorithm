import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1654 {
	static int K, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		long array[] = new long[K];
		long max = 1;
		for (int i = 0; i < K; i++) {
			array[i] = Long.parseLong(br.readLine());
			max = (int) Math.max(array[i], max);
		}

		long start = 1;
		long end = max;
		
		System.out.print(BinarySearch(array, start, end));
	}
	
	public static long BinarySearch(long[] array, long start, long end) {
		long count;
		long mid = 0;
		
		while (start <= end) {
			mid = (start + end)/2;
			count = 0;
			
			for (int i = 0; i < K; i++) {
				count = count + (int)array[i]/mid;
			}
						
			if (count < N) {
				end = mid - 1;
			} else if (count >= N) {
				start = mid + 1;
			}
		}
		
		return end;
	}
}
