class P_Level2_쿼드압축후개수세기 {
    static int zeroCount = 0;
    static int oneCount = 0;

    public void main(String args[]) {
        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        solution(arr);
    }
    
    public static int[] solution(int[][] arr) {
        
        int len = arr.length;
        
        dfs(arr, len, 0, 0);
        
        int[] answer = new int[2];
        answer[0] = zeroCount;
        answer[1] = oneCount;
        return answer;
    }
    
    static void dfs(int[][] arr, int len, int startX, int startY) {
        int result = search(arr, startX, startY, len);
        if (result == 0) { // 탐색 함수
            zeroCount++;
        } else if (result == 1) {
            oneCount++;  
        } else {
            if (len != 1) {
                int newLen = len/2;
                dfs(arr, newLen, startX, startY);
                dfs(arr, newLen, startX, startY+newLen);
                dfs(arr, newLen, startX+newLen, startY);
                dfs(arr, newLen, startX+newLen, startY+newLen);

            }
        }
    }
    
    static int search(int[][] arr, int startX, int startY, int len) {
        int standard = arr[startX][startY];
        for (int i = startX; i < startX+len; i++) {
            for (int j = startY; j < startY+len; j++) {
                if (arr[i][j] != standard)
                    return -1;
            }
        }
        
        return standard;
    }
}