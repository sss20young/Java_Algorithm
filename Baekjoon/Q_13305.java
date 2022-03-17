import java.util.*;
import java.io.*;

public class Q_13305 {
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine()); // 도시 갯수
        st = new StringTokenizer(br.readLine());
        long[] liter = new long[N-1];
        for (int i = 0; i < N-1; i++)
            liter[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] value = new long[N];
        for (int i = 0; i < N; i++)
            value[i] = Long.parseLong(st.nextToken());

        long sum = 0;
        long minValue = value[0];
        for (int i = 0; i < N-1; i++) {
            minValue = Math.min(value[i], minValue);
            sum += minValue * liter[i];
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
