import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_1138 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] left_people = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			left_people[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i = N-1; i >= 0; i--) {
			result.add(left_people[i], i+1);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(result.get(i)+" ");
		}
	}
}
