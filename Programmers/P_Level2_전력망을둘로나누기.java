class P_Level2_전력망을둘로나누기 {
    static int max = 0;
    static int count = 0;
    static int[][] connect;

    public static void main(String[] args) {
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        solution(9, wires);
    }
    
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            max = Math.max(Math.max(max, wires[i][0]), wires[i][1]);
        }
        
        // setting
        connect = new int[max+1][max+1];
        for (int i = 0; i < wires.length; i++) {
            connect[wires[i][0]][wires[i][1]] = 1;
            connect[wires[i][1]][wires[i][0]] = 1;
        }
        
        for (int i = 0; i < n-1; i++) {
            // 끊기
            connect[wires[i][0]][wires[i][1]] = 0;
            connect[wires[i][1]][wires[i][0]] = 0;
            
            // 세서 최솟값 찾기
            int min = count();
            answer = Math.min(answer, min);
            
            // 원래대로
            connect[wires[i][0]][wires[i][1]] = 1;
            connect[wires[i][1]][wires[i][0]] = 1;
        }
            
        return answer;
    }
    
    static int count() {
        
        int[] visited = new int[max+1];
        
        // left
        count = 0;
        for (int i = 1; i < max+1; i++) {
            if (visited[i] == 0) {
                dfs(i, visited);
                break;
            }
        }
        int left = count;
        
        // right        
        count = 0;
        for (int i = 1; i < max+1; i++) {
            if (visited[i] == 0) {
                dfs(i, visited);
                break;
            }
        }
        int right = count;

        return Math.abs(left - right);
    }
    
    static void dfs(int start, int[] visited) {
        visited[start] = 1;
        count++;
        
        for (int i = 1; i < max+1; i++) {
            if (connect[start][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                dfs(i, visited);
            }
        }
    }
}