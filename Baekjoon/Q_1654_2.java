import java.util.*;
import java.io.*;

public class Q_1654_2 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[K];
        long start = 1;
        long end = 0;
        for (int i = 0; i < K; i++) {
            array[i] = Integer.parseInt(br.readLine());
            end += array[i];
        }
        end /= K;

        long mid = (start + end) / 2;
        while (start <= end) {
            
            int sum = 0;
            for (int i = 0; i < K; i++) {
                 sum += array[i] / mid;
            }

            if (sum >= N) start = mid + 1;
            else end = mid - 1;
            
            mid = (start + end) / 2;
        }

        bw.write(mid + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
