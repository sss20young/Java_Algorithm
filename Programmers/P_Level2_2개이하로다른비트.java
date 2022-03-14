class P_Level2_2개이하로다른비트 {

    public static void main(String[] args) {
        long[] numbers = {2,7};
        solution(numbers);        
    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = calc(numbers[i]);
        }
        
        return answer;
    }
    
    static long calc(long number) {
        if (number % 2 == 0) { // 짝수
            return number + 1;
        } else { // 홀수
            String standard = Long.toBinaryString(number);
            StringBuilder sb = new StringBuilder();
            sb.append(standard);
            if (sb.lastIndexOf("0") >= 0) { // 가장 뒤에있는 0 찾아서
                int index = sb.lastIndexOf("0");
                standard = standard.substring(0, index) 
                    + "10"
                    + standard.substring(index+2, standard.length());
                return Long.parseLong(standard, 2);
            } else {
                sb.insert(1, "0");
                return Long.parseLong(sb.toString(), 2);
            }
        }
    }
}