import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q_10866 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>(); // 결과 출력을 위한 변수
		
		String cmd;
		int number;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			switch (cmd) {
				case "push_front":
					number = Integer.parseInt(st.nextToken());
					deque.addFirst(number);
					break;
				case "push_back":
					number = Integer.parseInt(st.nextToken());
					deque.addLast(number);
					break;
				case "pop_front":
					if (deque.isEmpty())
						result.add(-1);
					else
						result.add(deque.pollFirst());
					break;
				case "pop_back":
					if (deque.isEmpty())
						result.add(-1);
					else
						result.add(deque.pollLast());
					break;
				case "size":
					result.add(deque.size());
					break;
				case "empty":
					if (deque.isEmpty())
						result.add(1);
					else
						result.add(0);
					break;
				case "front":
					if (deque.isEmpty())
						result.add(-1);
					else
						result.add(deque.peekFirst());
					break;
				case "back":
					if (deque.isEmpty())
						result.add(-1);
					else
						result.add(deque.peekLast());
					break;
			}
		}
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
