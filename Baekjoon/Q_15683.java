import java.util.*;
import java.io.*;

public class Q_15683 {

    static int N, M;
    static int minCount = Integer.MAX_VALUE;
    static int[][] direction = {{-1}, 
                                {0}, {1}, {2}, {3}, // 0: 좌, 1: 상, 2: 우,  3: 하
                                {0, 2}, {1, 3}, 
                                {0, 1}, {1, 2}, {2, 3}, {3, 0},
                                {0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}, 
                                {0, 1, 2, 3, 4}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(array, new Point(0, 0), 0);

        bw.write(minCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int[][] array, Point start, int dir) {

        // deep copy
        int[][] newArray = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArray[i][j] = array[i][j];
            }
        }

        // 감시 가능 구역 -1로 set
        if (dir != 0) {
            int size = direction[dir].length;
            for (int k = 0; k < size; k++) {
                if (direction[dir][k] == 0) {
                    for (int j = start.y-1; j >= 0; j--) {
                        if (j >= 0 && j < M) {
                            if (newArray[start.x][j] == 6) break;
                            if (newArray[start.x][j] == 0)
                                newArray[start.x][j] = -1;
                        }
                    }
                } else if (direction[dir][k] == 1) {
                    for (int i = start.x-1; i >= 0; i--) {
                        if (i >= 0 && i < N) {
                            if (newArray[i][start.y] == 6) break;
                            if (newArray[i][start.y] == 0)
                                newArray[i][start.y] = -1;
                        }
                    }
                } else if (direction[dir][k] == 2) {
                    for (int j = start.y+1; j < M; j++) {
                        if (j >= 0 && j < M) {
                            if (newArray[start.x][j] == 6) break;
                            if (newArray[start.x][j] == 0)
                                newArray[start.x][j] = -1;
                        }
                    }
                } else {
                    for (int i = start.x+1; i < N; i++) {
                        if (i >= 0 && i < N) {
                            if (newArray[i][start.y] == 6) break;
                            if (newArray[i][start.y] == 0)
                                newArray[i][start.y] = -1;
                        }
                    }
                }
            }
        }

        // 사각지대 최소 갯수 세기
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newArray[i][j] == 0) count++;
            }
        }
        minCount = Math.min(minCount, count);

        // dfs로 CCTV 종류 별 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                switch(newArray[i][j]) {
                    case 1:
                        newArray[i][j] = -1;
                        dfs(newArray, new Point(i, j), 1);
                        dfs(newArray, new Point(i, j), 2);
                        dfs(newArray, new Point(i, j), 3);
                        dfs(newArray, new Point(i, j), 4);
                        break;
                    case 2:
                        newArray[i][j] = -1;
                        dfs(newArray, new Point(i, j), 5);
                        dfs(newArray, new Point(i, j), 6);
                        break;
                    case 3:
                        newArray[i][j] = -1;
                        dfs(newArray, new Point(i, j), 7);
                        dfs(newArray, new Point(i, j), 8);
                        dfs(newArray, new Point(i, j), 9);
                        dfs(newArray, new Point(i, j), 10);
                        break;
                    case 4:
                        newArray[i][j] = -1;
                        dfs(newArray, new Point(i, j), 11);
                        dfs(newArray, new Point(i, j), 12);
                        dfs(newArray, new Point(i, j), 13);
                        dfs(newArray, new Point(i, j), 14);
                        break;
                    case 5:
                        newArray[i][j] = -1;
                        dfs(newArray, new Point(i, j), 15);
                        break;
                }
            }
        }

        return;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
