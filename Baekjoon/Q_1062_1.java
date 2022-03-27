import java.util.*;
import java.io.*;

public class Q_1062_1 {

    static int N;
    static int sum = 0;
    static String[] array;
    static boolean[] alphabet = new boolean[26];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 5; // 디폴트인 "anta"와 "tica" -> 5개
        array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = br.readLine();
        }
        alphabet['a'-'a'] = true;
        alphabet['c'-'a'] = true;
        alphabet['i'-'a'] = true;
        alphabet['n'-'a'] = true;
        alphabet['t'-'a'] = true;

        if (K >= 0) {
            dfs(K, 1); // b부터 시작
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int K, int index) {

        if (K == 0) {
            check(array);
            return;
        } else if (index < 26) {

            for (int i = index; i < 26; i++) {
                if (alphabet[i] == false) {
                    alphabet[i] = true;
                    dfs(K-1, i); // O
                    alphabet[i] = false;
                } 
            }
        }
    }

    static void check(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length(); j++) {
                if (alphabet[array[i].charAt(j) - 'a'] == false) break;
                if (j + 1 == array[i].length()) {count++; }
            }
        }
        
        sum = Math.max(sum, count);
    }
}