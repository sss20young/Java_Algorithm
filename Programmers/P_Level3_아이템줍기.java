import java.util.*;

class P_Level3_아이템줍기 {
    static int[][] table = new int[101][101];
    static int count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Integer> queueX = new LinkedList<>();
    static Queue<Integer> queueY = new LinkedList<>();

    public static void main(String[] args) {
        int[][] rectangle = {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
        solution(rectangle, 9, 7, 6, 1);
    }
    
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for (int i = 0; i < rectangle.length; i++) {
            draw(rectangle[i]);
        }
        
        // 두방향 중 최솟값 구하기
        BFS(characterX*2, characterY*2, itemX*2, itemY*2);
        int first = count;
        for (int i = 0; i < 4; i++) {
            dx[i] = dx[i]*(-1);
            dy[i] = dy[i]*(-1);
        }
        count = 0;
        BFS(characterX*2, characterY*2, itemX*2, itemY*2);
        int second = count;
        
        return Math.min(first, second) / 2;
    }
    
    static void draw(int[] rectangle) {
        // 외부
        int i = rectangle[0]*2;
        for (int j = rectangle[1]*2; j <= rectangle[3]*2; j++) {
            if (table[i][j] != -1)
                table[i][j] = 1;
        }
        i = rectangle[2]*2;
        for (int j = rectangle[1]*2; j <= rectangle[3]*2; j++) {
            if (table[i][j] != -1)
                table[i][j] = 1;
        }
        int j = rectangle[1]*2;
        for (i = rectangle[0]*2; i <= rectangle[2]*2; i++) {
            if (table[i][j] != -1)
                table[i][j] = 1;
        }
        j = rectangle[3]*2;
        for (i = rectangle[0]*2; i <= rectangle[2]*2; i++) {
            if (table[i][j] != -1)
                table[i][j] = 1;
        }
        
        // 내부
        for (i = rectangle[0]*2+1; i < rectangle[2]*2; i++) {
            for (j = rectangle[1]*2+1; j < rectangle[3]*2; j++) {
                table[i][j] = -1;
            }
        }
    }
    
    static void BFS(int startX, int startY, int endX, int endY) {
                
        if (startX == endX && startY == endY) return;
        else table[startX][startY] = 0;
        
        for (int i = 0; i < 4; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];
            if (nextX >= 0 && nextY >= 0 && nextX <= 100 && nextY <= 100 && 
                table[nextX][nextY] == 1) {
                queueX.add(nextX);
                queueY.add(nextY);
                count++;
                break;
            }
        }
        
        while(!queueX.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();
            BFS(x, y, endX, endY);
        }
    }
}