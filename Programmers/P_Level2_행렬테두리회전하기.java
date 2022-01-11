public class P_Level2_행렬테두리회전하기 {
    static int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
    static int[] answer;

    public static void main(String[] args) {
        solution(3, 3, queries);
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        
        int[][] table = init(rows, columns);
        for (int i = 0; i < queries.length; i++) {
            table = change(table, queries[i], i);
        }
        
        return answer;
    }
    
    static int[][] init(int rows, int columns) {
        int[][] table = new int[rows][columns];
        int count = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                table[i][j] = count;
                count++;
            }
        }
        
        return table;
    }
    
    static int[][] change(int[][] table, int[] query, int number) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
            
        int w = y2 - y1; // 가로 길이
        int h = x2 - x1; // 세로 길이
        
        int startPoint = table[x1][y1];
        int min = table[x1][y1];
        
        for (int i = 0; i < h; i++) {
            int xPoint = x1+i;
            int yPoint = y1;            
            table[xPoint][yPoint] = table[xPoint+1][yPoint];
            min = Math.min(min, table[xPoint][yPoint]);
        }
        
        for (int i = 0; i < w; i++) {
            int xPoint = x2;
            int yPoint = y1+i;
            table[xPoint][yPoint] = table[xPoint][yPoint+1];
            min = Math.min(min, table[xPoint][yPoint]);
        }
        
        for (int i = 0; i < h; i++) {
            int xPoint = x2-i;
            int yPoint = y2;            
            table[xPoint][yPoint] = table[xPoint-1][yPoint];
            min = Math.min(min, table[xPoint][yPoint]);
        }
        
        for (int i = 0; i < w - 1; i++) {
            int xPoint = x1;
            int yPoint = y2-i;            
            table[xPoint][yPoint] = table[xPoint][yPoint-1];
            min = Math.min(min, table[xPoint][yPoint]);
        }

        table[x1][y1+1] = startPoint;
        answer[number] = min;
        
        return table;
    }
}