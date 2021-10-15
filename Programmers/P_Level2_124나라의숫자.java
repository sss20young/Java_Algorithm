class P_Level2_124나라의숫자 {
    static String answer = "";
    static String[] array = { "4", "1", "2" };

    public static void main(String[] args) {
        solution(10);
    }

    public static String solution(int n) {

        while(n >= 1) {
            n = divide(n);
        }

        return answer;
    }

    static int divide(int n) {
        int b = n % 3;
        answer = array[b] + answer;

        n = n / 3;
        if (b == 0)
            n = n - 1;

        return n;
    }
}