import java.util.*;

class P_Level3_퍼즐조각채우기 {
    static List<int[][]> list = new ArrayList<>();
    static List<int[][]> tableList = new ArrayList<>();
    static int[][] figure;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int startX = 0;
    static int startY = 0;

    static int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
    static int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
    public static void main(String[] args) {
        solution(game_board, table);
    }

    static public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
                
        // 1. game_board에 있는 도형 찾기
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                if (game_board[i][j] == 0) {
                    figure = new int[6][6];
                    startX = i;
                    startY = j;
                    findBlock(game_board, table, i, j, figure, 1);
                    list.add(figure);
                }
            }
        }
        
        // 2. table에 있는 도형 찾기
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1) {
                    figure = new int[6][6];
                    startX = i;
                    startY = j;
                    findBlock(game_board, table, i, j, figure, 0);
                    tableList.add(figure);
                }
            }
        }
        
        // 3. table에 있는 도형 90도 회전해서 일치하는 도형 찾기
        for (int i = 0;  i < list.size(); i++) {
            loop:
            for (int j = 0; j < tableList.size(); j++) {
                int[][] rotate = tableList.get(j);
                for (int k = 0; k < 4; k++) { // table에 있는 도형 회전
                    rotate = rotate(rotate);
                    if (Arrays.deepEquals(list.get(i), rotate)) {
                        tableList.remove(j);
                        j = 0;
                        answer += numbering(list.get(i));
                        break loop;
                    }
                }
            }
        }
        
        return answer;
    }
    
    public static void findBlock(int[][] game_board, int[][] table, int x, int y, int[][] figure, int check) {
        if (check == 1)
            game_board[x][y] = check;
        else
            table[x][y] = check;

        if (x-startX < 0) { // move down
            for (int i = 5; i >= 1; i--) {
                for (int j = 5; j >= 0; j--) {
                    figure[i][j] = figure[i-1][j];
                    figure[i-1][j] = 0;
                }
            }
            startX--;
        }
        if (y-startY < 0) { // move right
            for (int i = 5; i >= 0; i--) {
                for (int j = 5; j >= 1; j--) {
                    figure[i][j] = figure[i][j-1];
                    figure[i][j-1] = 0;
                }
            }
            startY--;
        }
        figure[x-startX][y-startY] = 1;

        if (check == 1) {
            for (int i = 0; i < 4; i++){
                if (x+dx[i] >= 0 && x+dx[i] < game_board[0].length && y+dy[i] >=0 && y+dy[i] < game_board[0].length) {
                    if (game_board[x+dx[i]][y+dy[i]] == 0) {

                        findBlock(game_board, table, x+dx[i], y+dy[i], figure, check);
                    }
                }
            }
        } else {
            for (int i = 0; i < 4; i++){
                if (x+dx[i] >= 0 && x+dx[i] < table[0].length && y+dy[i] >=0 && y+dy[i] < table[0].length) {
                    if (table[x+dx[i]][y+dy[i]] == 1) {

                        findBlock(game_board, table, x+dx[i], y+dy[i], figure, check);
                    }
                }
            }
        }
    }

    public static int[][] rotate(int[][] two) {

        int n = two.length;
        int m = two[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = two[n-1-j][i];
            }
        }

        // 세로 줄 줄이기
        int count = 0;
        while(count != -1) {
            count = 0;
            for (int j = 0; j < rotate[0].length; j++) {
                if (rotate[0][j] == 0)
                    count++;
                else  {
                    count = -1;
                    break;
                }

                if (count == 6) {
                    for (int k = 0; k < rotate[0].length; k++) { // up
                        for (int l = 0; l < rotate.length-1; l++) {
                            rotate[l][k] = rotate[l+1][k];
                            rotate[l+1][k] = 0;
                        }
                    }
                }
            }
        }

        // 가로 줄 줄이기
        count = 0;
        while(count != -1) {
            count = 0;
            for (int i = 0; i < rotate[0].length; i++) {
                if (rotate[i][0] == 0)
                    count++;
                else  {
                    count = -1;
                    break;
                }

                if (count == 6) {
                    for (int k = 0; k < rotate[0].length-1; k++) { // up
                        for (int l = 0; l < rotate.length; l++) {
                            rotate[l][k] = rotate[l][k+1];
                            rotate[l][k+1] = 0;
                        }
                    }
                }
            }
        }

        return rotate;
    }

    public static int numbering(int[][] one) {
        int count = 0;
        for (int i = 0; i < one.length; i++) {
            for (int j = 0; j < one[i].length; j++) {
                if (one[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
}