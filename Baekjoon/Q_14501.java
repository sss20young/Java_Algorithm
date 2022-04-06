import java.io.*;
import java.util.*;

public class Q_14501 {
	
    static int N;
	static List<Schedule> array;
    static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        array = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            array.add(new Schedule(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dfs(1, 0);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int day, int sumOfPrice) {

        result = Math.max(result, sumOfPrice);
        
        if (day <= N) {
            dfs(day+1, sumOfPrice); // X
            if (day + array.get(day-1).period <= N+1)
                dfs(day + array.get(day-1).period, sumOfPrice + array.get(day-1).price); // O
        }
    }

    static class Schedule {
        int startDay;
        int period;
        int price;

        Schedule(int startDay, int period, int price) {
            this.startDay = startDay;
            this.period = period;
            this.price = price;
        }
    }
}