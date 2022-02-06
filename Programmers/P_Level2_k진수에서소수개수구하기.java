class P_Level2_k진수에서소수개수구하기 {

    public static void main(String[] args) {
        solution(437674, 3);
    }

    public static int solution(int n, int k) {
        int answer = 0;
        
        String kString = "";
        // k진수로 바꾸기
        while (n != 0) {
            int r = n % k;
            n = n / k;
            kString = r + kString; 
        }
        
        int j;
        for (int i = 0; i < kString.length(); i = j) {
            for (j = i+1; j < kString.length() && kString.charAt(j) != '0'; j++);

            if (isPrime(Long.parseLong(kString.substring(i, j)))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(long number) {
        if (number == 0 || number == 1) return false;
        
        for (int i = 2; i <= Math.sqrt(number); i++) { // 불필요한 반복 줄이기
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}