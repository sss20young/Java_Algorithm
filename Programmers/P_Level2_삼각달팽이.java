class P_Level2_삼각달팽이 {

    public static void main(String[] args) {
        solution(6);
    }

    public static int[] solution(int n) {
            
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        
        int[][] array = new int[n][n];
        int count = n-1;
        int minus = 0;
        int x = 0;
        int y = 0;
        int[][] change = {{1, 0}, {0, 1}, {-1, -1}};
        for (int i = 1; i <= sum; i++) {
            array[x][y] = i;
            count--;
            
            x += change[minus%3][0];
            y += change[minus%3][1];
            
            if (count == 0) {
                minus++;
                count = n - minus;
            }
        }
        
        int[] answer = new int[sum];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] != 0) {
                    answer[index] = array[i][j];
                    index++;
                }
                else
                    break;
            }
        }
        
        return answer;
    }
}