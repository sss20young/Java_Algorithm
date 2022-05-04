class P_Level2_거리두기확인하기 {
    static int size = 5;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx2 = {0, -2, 0, 2};
    static int[] dy2 = {-2, 0, 2, 0};
    static int[] dx3 = {-1, -1, 1, 1};
    static int[] dy3 = {-1, 1, 1, -1};

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        solution(places);
    }
    
    public static int[] solution(String[][] places) {
        
        String[][] waitingRoom = new String[size][size];
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String s = places[i][j];
                for (int k = 0 ; k < size; k++) {
                    waitingRoom[j][k] = s.substring(k, k+1);
                }
            }
            
            if (findP(waitingRoom))
                answer[i] = 1;
            else answer[i] = 0;
        }
        
        
        return answer;
    }
    
    static boolean findP(String[][] waitingRoom) {
        for (int i = 0; i <  size; i++) {
            for (int j = 0 ; j < size; j++) {
                if (waitingRoom[i][j].equals("P"))
                    if (!bfs(waitingRoom, i, j))
                        return false;
            }
        }
        
        return true;
    }
    
    static boolean bfs(String[][] waitingRoom, int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < 5 && y + dy[i] >= 0 && y + dy[i] < 5) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (waitingRoom[newX][newY].equals("P"))
                    return false;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (x + dx2[i] >= 0 && x + dx2[i] < 5 && y + dy2[i] >= 0 && y + dy2[i] < 5) {
                int newX = x + dx2[i];
                int newY = y + dy2[i];
                if (waitingRoom[newX][newY].equals("P")) {
                    if (!waitingRoom[x + dx[i]][y + dy[i]].equals("X")) // 파티션
                        return false;
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (x + dx3[i] >= 0 && x + dx3[i] < 5 && y + dy3[i] >= 0 && y + dy3[i] < 5) {
                int newX = x + dx3[i];
                int newY = y + dy3[i];
                if (waitingRoom[newX][newY].equals("P")) {
                    if (!waitingRoom[newX][y].equals("X")) // 파티션
                        return false;
                    if (!waitingRoom[x][newY].equals("X")) // 파티션
                        return false;
                }
            }
        }
        
        return true;
    }
}