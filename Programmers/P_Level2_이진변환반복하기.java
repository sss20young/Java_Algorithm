class P_Level2_이진변환반복하기 {

    public void main(String args[]) {
        solution("110010101001");
    }

    public static int[] solution(String s) {
        
        int count = 0;
        int zero = 0;
        
        while (!s.equals("1")) {
            zero += countZero(s) ; // s에서 0의 개수
            String deleteZeroFromS = s.replace("0", "");
            int len = deleteZeroFromS.length();
            s = toBinary(len); // length -> 이진 변환
            count++;
        }
        
        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = zero;
        
        return answer;
    }
    
    static int countZero(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                count++;
        }
        
        return count;
    }
    
    static String toBinary(int n) {
        String result = "";
        
        while (n != 0) {
            result = n % 2 + result;
            n = n / 2;
        }
        return result;
    }
}