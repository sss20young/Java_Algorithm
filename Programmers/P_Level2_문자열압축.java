class P_Level2_문자열압축 {

    public static void main(String[] args) {
        solution("xababcdcdababcdcd");
    }

    public static int solution(String s) {
        int answer = s.length(); // 0개 단위로 잘랐을 경우
        
        for (int i = 1; i <= s.length(); i++) {
            
            int startIndex = 0;
            int nextStartIndex = startIndex + i;
            
            // 압축하기
            String result = "";
            while (nextStartIndex+i-1 < s.length()) { // 다음이 있을 때
                String splitString = s.substring(startIndex, nextStartIndex);
                
                if (splitString.equals(s.substring(nextStartIndex, nextStartIndex+i))) { // 다음이 같으면
                    int count = 2;
                    while(startIndex+count*i+i-1 < s.length() && 
                         splitString.equals(s.substring(startIndex+count*i, startIndex+(count+1)*i))) {
                        count++;
                    }
                    startIndex = startIndex + i*count;
                    // 몇 개인지 세서
                    result += count+splitString;
                } else { // 다음이 다르면
                    startIndex = startIndex + i;
                    result += splitString;
                }
                nextStartIndex = startIndex + i;
            }
            
            // 남은거 이어붙이기
            if (startIndex < s.length())
                result += s.substring(startIndex, s.length());
            
            // 최솟값 찾기
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}