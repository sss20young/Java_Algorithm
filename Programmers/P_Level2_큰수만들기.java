class P_Level2_큰수만들기 {

    public static void main(String[] args) {
        solution("1231234", 3);
    }
    
    public static String solution(String number, int k) {
        String answer = "";
        int start = 0;
        int end = k;

        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = start; j <= end; j++) {
                
                if (max < Character.getNumericValue(number.charAt(j))) {
                    max = Character.getNumericValue(number.charAt(j));
                    start = j+1;
                }
            }
            end++;
            answer += max;
        }

        return answer;
    }
}