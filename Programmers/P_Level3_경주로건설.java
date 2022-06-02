class P_Level3_경주로건설 {
    
    // 하 우 상 좌 순으로 탐색 -> 우 하 좌 상 순으로 변경
    int[] dy = {1, 0, -1, 0};
    int[] dx = {0, 1, 0, -1};
    int result = Integer.MAX_VALUE; // 최댓값 넣기
    
    public int solution(int[][] board) {
        
        int size = board.length;
        int[][] newBoard = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        
        boolean visited[][] = new boolean[size][size];
        visited[0][0] = true;
        if (board[1][0] != 1) {
            visited[1][0] = true;
            dfs(board, 1, 0, 100, 1, visited); // 하 시작
            visited[1][0] = false;
        }
        
        if (newBoard[0][1] != 1) {
            visited[0][0] = true;
            visited[0][1] = true;
            dfs(newBoard, 0, 1, 100, 0, visited); // 우 시작
            visited[0][1] = false;
        }
        
        return result;
    }
    
    void dfs(int[][] board, int x, int y, int cost, int direction, boolean visited[][]) {
        
        // board에 최소 cost 넣기
        if (board[x][y] != 0) {
            board[x][y] = Math.min(board[x][y], cost);
        } else {
            board[x][y] = cost;
        }
        
        if (x == board.length-1 && y == board[0].length-1) { // 마지막 도달
            result = Math.min(result, board[x][y]);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board.length
               && board[newX][newY] != 1 && visited[newX][newY] == false) {
                
                if (direction == i) { // 방향이 같으면
                    if (board[newX][newY] == 0 || board[newX][newY] > cost+100) {
                        visited[newX][newY] = true;
                        dfs(board, newX, newY, cost+100, i, visited);
                        visited[newX][newY] = false;
                    }
                } else {
                    if (board[newX][newY] == 0 || board[newX][newY] > cost+100+500) {
                        visited[newX][newY] = true;
                        dfs(board, newX, newY, cost+100+500, i, visited);
                        visited[newX][newY] = false;
                    }
                }
            }
        }
    }
}