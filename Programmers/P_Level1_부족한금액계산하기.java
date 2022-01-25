class P_Level1_부족한금액계산하기 {

    public static void main(String[] args) {
        solution(3, 20, 4);
    }

    public static long solution(int price, int money, int count) {
        long answer = -1;
        
        long need = 0;
        for (int i = 1; i <= count; i++) {
            need += price*i;
        }
        
        if (money >= need) // 모자라지 않으면
            answer = 0;
        else // 모자라면
            answer = need - money;
        
        return answer;
    }
}