import java.util.*;

class P_Level2_괄호회전하기 {
    public static void main(String[] args) {
        solution("({[}])");
    }

    public static int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1, s.length()) + s.substring(0, 1);
            if (check(s)) answer++;
        }

        return answer;
    }
    
    static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            switch (c) {
                case '[':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ']':
                    if (stack.size() != 0) {
                        Character d = stack.pop();
                        if (!d.equals('['))
                            return false;
                    } else return false;
                    break;
                case '}':
                    if (stack.size() != 0) {
                        Character d = stack.pop();
                        if (!d.equals('{'))
                            return false;
                    } else return false;
                    break;
                case ')':
                    if (stack.size() != 0) {
                        Character d = stack.pop();
                        if (!d.equals('('))
                            return false;
                    } else return false;
                    break;
            }
        }
        
        if (stack.size() == 0)
            return true;
        
        return false;
    }
}