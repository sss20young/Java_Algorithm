import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new LinkedList<Integer>();
		String cmd;
		int number;
	
		Queue<Integer> solution = new LinkedList<Integer>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			switch (cmd) {
				case "push":
					number = Integer.parseInt(st.nextToken());
					queue.offer(number);
					break;
				case "pop":
					if(queue.isEmpty())
						solution.offer(-1);
					else
						solution.offer(queue.poll());
					break;
				case "size":
					solution.offer(queue.size());
					break;
				case "empty":
					if(queue.isEmpty())
						solution.offer(1);
					else
						solution.offer(0);
					break;
				case "front":
					if(queue.isEmpty())
						solution.offer(-1);
					else
						solution.offer(queue.peekFirst());
					break;
				case "back":
					if(queue.isEmpty())
						solution.offer(-1);
					else
						solution.offer(queue.peekLast()); // peekLast()를 사용하기 위해 Queue -> Deque로 변경
					break;
			}
		}
		
		int size = solution.size();
		for (int i = 0; i < size; i++) {
			System.out.println(solution.poll());
		}
	}
}
