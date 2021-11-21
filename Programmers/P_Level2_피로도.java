class P_Level2_피로도 {
    static int visited[];
    static int preAnswer = 0;
    static int count = 0;

    static int[][] dungeons = {{80,20},{50,40},{30,10}};

    public static void main(String[] args) {
        solution(80, dungeons);
    }
    
    public static int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        for (int i = 0; i < dungeons.length; i++) {
            
            // 방문 초기화
            visited = new int[dungeons.length+1];
            visited[0] = 1;
            
            preAnswer = 0;
            visited[i+1] = 1;
            DFS(dungeons, i+1, k, 0, count);
            
            if (answer < preAnswer)
                answer = preAnswer;
        }
        
        return answer;
    }
    
    public static void DFS(int[][] dungeons, int start, int kInput, int output, int count) {
        count++;

        if (kInput >= dungeons[start-1][0]) {
            kInput -= dungeons[start-1][1];
            output++;
        }

        if (count == dungeons.length)
            if (output > preAnswer)
                preAnswer = output;
        
        for (int i = 1; i <= dungeons.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                DFS(dungeons, i, kInput, output, count);
                visited[i] = 0;
            }
        }
    }
}