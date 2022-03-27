import java.util.*;
import java.io.*;

public class Q_1946 {
        
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        result = new int[T];
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Grade> pq = new PriorityQueue<>(new Comparator<Grade>() { // 1차 점수 오름차순 정렬
                @Override
                public int compare(Grade g1, Grade g2) {
                    return g1.first - g2.first;
                }
            });

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                pq.add(new Grade(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            count(i, pq);
        }

        for (int i = 0; i < T; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void count(int index, PriorityQueue<Grade> pq) { // 2차 점수 비교

        int max = 0;
        int count = 0;
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Grade g = pq.poll();
            if (g.first == 1 || g.second < max) {
                max = g.second;
                count++;
            }
        }

        result[index] = count;
    }

    static class Grade {
        int first, second;

        Grade (int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
