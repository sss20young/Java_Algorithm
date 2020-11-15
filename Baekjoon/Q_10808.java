import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q_10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> dict = new HashMap<String, Integer>();
		
		for (int ASCII = 97; ASCII <= 122; ASCII++) { // a: 97 ~ z: 122
			String str = new Character((char)ASCII).toString(); // ASCII Code -> String
			dict.put(str, 0);
		}
		
		String S = br.readLine();
		
		for (int i = 0; i < S.length(); i++) {
			dict.replace(String.valueOf(S.charAt(i)), dict.get(String.valueOf(S.charAt(i)))+1);
		}
		
		for (int ASCII = 97; ASCII <= 122; ASCII++) {
			String str = new Character((char)ASCII).toString();
			System.out.print(dict.get(str)+" ");
		}
	}
}
