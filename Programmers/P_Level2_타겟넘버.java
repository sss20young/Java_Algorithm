class P_Level2_타겟넘버 {
    static int answer = 0;

    public static void main(String[] args) {
        int[] numbers= {4, 1, 2, 1};
        solution(numbers, 3);
    }
    
    public static int solution(int[] numbers, int target) {
        
        dfs(0, numbers, target, 0);
        
        return answer;
    }
    
    static void dfs(int start, int[] numbers, int target, int result) {
        
        if (start == numbers.length)
            if (target == result) 
                answer++;

        if (start+1 > numbers.length)
            return;
                
        dfs(start+1, numbers, target, result-numbers[start]);
        dfs(start+1, numbers, target, result+numbers[start]);
    }
}