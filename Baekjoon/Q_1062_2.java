import java.util.*;
import java.io.*;

public class Q_1062_2 {

    static int N;
    static int sum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 5; // 디폴트인 "anta"와 "tica" -> 5개
        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = br.readLine().replaceAll("[acint]", "");
        }

        if (K >= 0) {
            dfs(array, K, "acint", 98); // b부터 시작
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(String[] array, int K, String known, int index) {

        if (K == 0) {
            int exSum = 0;
            
            for (int i = 0; i < array.length; i++) {

                    int count = 0;
                    for (int j = 0; j < array[i].length(); j++) {
                        for (int k = 0; k < known.length(); k++) {
                            if (array[i].charAt(j) == known.charAt(k)) count++;
                        }
                    }
                    if (count == array[i].length()) exSum++;
            }
            sum = Math.max(sum, exSum);
            
        } else if (index < 123) {

            char present = (char) (index);
            char next = (char) (index+1);
            if (next != 'a' && next != 'c' && next != 'i' && next != 'n' && next != 't') {
                dfs(array, K, known, index+1); // X
                dfs(array, K-1, known+Character.toString(present), index+1); // O
            } else {
                dfs(array, K, known, index+2); // X
                dfs(array, K-1, known+Character.toString(present), index+2); // O
            }
        }
    }
}