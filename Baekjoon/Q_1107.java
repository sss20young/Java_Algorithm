import java.io.*;
import java.util.*;

public class Q_1107 {
	static int[] errorNumber = new int[10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

        int destination = Integer.parseInt(br.readLine());
        int errorNumberCount = Integer.parseInt(br.readLine());
        if (errorNumberCount > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < errorNumberCount; i++) {
                errorNumber[Integer.parseInt(st.nextToken())] = 1;
            }
        }

        // 숫자 버튼 안누르고, (+,-)로만 이동
        int count = Math.abs(destination - 100);

        // 완전탐색
        boolean flag = true;
        for (int i = 0; i < 1000000; i++) {

            flag = true;

            String s = Integer.toString(i);
            for (int j = 0; j < s.length(); j++) {
                if (errorNumber[Integer.parseInt(s.substring(j, j+1))] == 1) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count = Math.min(count, s.length() + Math.abs(destination - i)); // 숫자 버튼 누른 갯수 + (+,-)로 이동한 갯수
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}