import java.util.*;
import java.io.*;

public class Q_11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 1. 절댓값 순으로 오름차순 정렬 2. 절댓값이 같은 경우, 가장 작은 순
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2))
                    return o1 - o2;
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        for (int i = 0; i < N ;i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (pq.size() == 0)
                    sb.append("0" + "\n");
                else
                    sb.append(pq.poll() + "\n");
            } else
                pq.add(number);
                
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}