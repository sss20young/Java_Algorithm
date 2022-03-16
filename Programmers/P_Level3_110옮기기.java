import java.util.*;

class P_Level3_110옮기기 {

    public static void main(String[] args) {
        String[] s = {"1110","100111100","0111111010"};
        solution(s);
    }

    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0;  i < s.length; i++) {
            answer[i] = move(s[i]);
        }
        
        return answer;
    }
    
    static String move(String s) {
        Stack<Character> stack = new Stack<>();
        
        // 모든 110 찾기
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (stack.size() >= 2) {
                    Character a = stack.pop();
                    Character b = stack.pop();
                    if (a == '1' && b == '1') {
                        count++;
                    } else {
                        stack.push(b);
                        stack.push(a);
                        stack.push(s.charAt(i));
                    }
                } else stack.push(s.charAt(i));
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (count == 0)
            return s;
        
        StringBuilder sb = new StringBuilder();
        int stackSize = stack.size();
        for (int i = stackSize; i > 0; i--) {
            if (stack.pop() == '0') {
                while ( count != 0) {
                    sb.insert(0, "110");
                    count--;
                }
                sb.insert(0, "0");
                break;
            } else {
                sb.insert(0, "1");
            }
            
            // stackSize가 0일 때, 실행되지 않음 -> for문 밖으로 위치
            // if (i == 1 && count != 0) {
            //     while (count != 0) {
            //         sb.insert(0, "110");
            //         count--;
            //     }
            //     break;
            // }
        }
        
        while (count != 0) {
            sb.insert(0, "110");
            count--;
        }
        stackSize = stack.size();
        for (int i = 0 ; i < stackSize; i++)
            sb.insert(0, String.valueOf(stack.pop()));
                    
        return sb.toString();
    }
}