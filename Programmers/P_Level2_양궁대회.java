class P_Level2_양궁대회 {
    static int max = 0;
    static int[] maxResult = new int[11];

    public static void main(String[] args) {
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        solution(9, info);
    }
    
    public static int[] solution(int n, int[] info) {
        int[] answer = {-1};
        
        int[] result = new int[11];
        DFS(0, n, result, 0, 0, info);
        
        if (max == 0)
            return answer;
        
        return maxResult;
    }
    
    static void DFS(int start, int count, int[] a, int lion, int apeach, int[] info) {
        
        // deep copy
        int[] result = new int[11];
        for (int i = 0; i < 11; i++) {
            result[i] = a[i];
        }
        
        if (start == 10) {
            if (count != 0) {
                result[10] = count;
                count = 0;
            }
            
            if (lion-apeach == max) {
                if (compare(result, maxResult))
                    maxResult = result;
            }
            
            if (lion-apeach > max) {
                max = lion-apeach;
                maxResult = result;
            }
            
            return;
        }
        
        // 점수 안따기
        if (info[start] > 0)
            DFS(start+1, count, result, lion, apeach + 10-start, info);
        else
            DFS(start+1, count, result, lion, apeach, info);
        
        // 점수 따기
        if (info[start] < count) {
            count = count - info[start] - 1;
            result[start] = info[start] + 1;
            DFS(start+1, count, result, lion + 10-start, apeach, info);
        } 
        
    }
    
    static boolean compare(int[] present, int[] prev) {
        for (int i = 10; i >= 0; i--) {
            if (present[i] != prev[i]) {
                if (present[i] > prev[i]) return true;
                else return false;
            }
        }
        
        return false;
    }
}