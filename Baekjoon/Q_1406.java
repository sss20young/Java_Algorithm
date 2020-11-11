import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String str = br.readLine();
		
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
				
		for (int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		String cmd, character;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();
			switch (cmd) {
				case "L":
					if (!left.isEmpty())
						right.push(left.pop());
					break;
				case "D":
					if (!right.isEmpty())
						left.push(right.pop());
					break;
				case "B":
					if (!left.isEmpty()) 
						left.pop();
					break;
				case "P":
					character = st.nextToken();
					left.push(character.charAt(0));
					break;
			}
		}
		
		int size = right.size();
		
		for (int i = 0; i < size; i++) {
			left.push(right.pop());
		}
		
		for(Character chr : left) {
			bw.write(chr);
		}
		
		bw.flush();
		bw.close();
		
	}
}
