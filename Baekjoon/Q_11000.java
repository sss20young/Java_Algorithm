import java.util.*;
import java.io.*;

public class Q_11000 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        ArrayList<MeetingRoom> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new MeetingRoom(start, end));
        }

        Collections.sort(list, (o1, o2) -> o1.start - o2.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).end);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= list.get(i).start)
                pq.poll();
            pq.add(list.get(i).end);
        }
        
        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class MeetingRoom {
        int start;
        int end;

        MeetingRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
