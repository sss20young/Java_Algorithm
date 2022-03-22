import java.util.*;
import java.io.*;

public class Q_14502 {

    static int N, M;
    static int[][] array;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxCount = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 벽 3개 세우기
        setThreeWall(0);

        bw.write(maxCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void setThreeWall(int depth) { // dfs

        if (depth == 3) {
            // 2. 바이러스 퍼지게 해서 남은 0 갯수 세기
            maxCount = Math.max(maxCount, spreadVirus(N, M));
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = 1;
                    setThreeWall(depth+1);
                    array[i][j] = 0;
                }
            }
        }
    }

    static int spreadVirus(int N, int M) { // bfs

        int[][] newArray = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArray[i][j] = array[i][j];
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newArray[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                if (point.x + dx[i] >= 0 && point.x + dx[i] < N && point.y + dy[i] >= 0 && point.y + dy[i] < M) {
                    if (newArray[point.x + dx[i]][point.y + dy[i]] == 0) {
                        newArray[point.x + dx[i]][point.y + dy[i]] = 2;
                        queue.add(new Point(point.x + dx[i], point.y + dy[i]));
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newArray[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
