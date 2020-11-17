import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_4796 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L, P, V;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken()); // L일동안만 사용 가능 
			P = Integer.parseInt(st.nextToken()); // 캠핑장을 연속하는 P
			V = Integer.parseInt(st.nextToken()); // V일짜리 휴가
			
			if (L == 0 && P == 0 && V == 0)
				break;
			
			int answer = 0;
			
			while (V > 0) {
				if (V - P > 0)
					answer = answer + L;
				else
					if (V > L)
						answer = answer + L;
					else
						answer = answer + V;
				
				V = V - P;
			}
			
			queue.add(answer);
		}
		
		int size = queue.size();
		for (int i = 1; i <= size; i++) {
			System.out.println("Case " + i + ": " + queue.poll());
		}
	}
}
