import java.util.*;
import java.io.*;

public class Q_1931 {
    
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
        // 끝나는 시간 기준 오름차순
        Collections.sort(list, new Comparator<MeetingRoom>() {
            @Override
            public int compare(MeetingRoom o1, MeetingRoom o2) {
                if (o1.end == o2.end)
                    return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });

        int time = 0;
        int maxCount = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).start >= time) {
                maxCount++;
                time = list.get(i).end;
            }
        }

        bw.write(maxCount + "\n");
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
