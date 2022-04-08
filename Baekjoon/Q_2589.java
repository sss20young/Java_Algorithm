import java.io.*;
import java.util.*;

public class Q_2589 {
	
    static int N, M;
    static Character[][] array;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new Character[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == 'L')
                    bfs(new Point(i, j, 0));
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Point startPoint) {
        boolean[][] visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint.x][startPoint.y] = true;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            result = Math.max(result, p.count);
            for (int i = 0; i < 4; i++) {
                if (p.x+dx[i] >= 0 && p.x+dx[i] < N && p.y+dy[i] >= 0 && p.y+dy[i] < M 
                && visited[p.x+dx[i]][p.y+dy[i]] == false && array[p.x+dx[i]][p.y+dy[i]] == 'L') {
                    queue.add(new Point(p.x+dx[i], p.y+dy[i], p.count+1));
                    visited[p.x+dx[i]][p.y+dy[i]] = true;
                }
            }
        }
    }

    static class Point {
        int x, y, count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}