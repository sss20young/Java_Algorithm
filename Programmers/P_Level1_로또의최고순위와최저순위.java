class P_Level1_로또의최고순위와최저순위 {

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        solution(lottos, win_nums);

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        
        int correct = 0;
        int zeroCount = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++)
                if (lottos[i] == win_nums[j])
                    correct++;
            
            if (lottos[i] == 0)
                zeroCount++;
        }
        
        int[] answer = new int[2];
        answer[0] = 7 - (correct+zeroCount);
        answer[1] = 7 - correct;
        
        if (answer[0] > 6) answer[0] = 6;
        if (answer[1] > 6) answer[1] = 6;
        
        return answer;
    }
}