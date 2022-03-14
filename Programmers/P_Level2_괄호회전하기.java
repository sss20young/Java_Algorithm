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
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }        
                
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = queue.poll();

            switch (c) {
                case '[':
                    deque.addLast(c);
                    break;
                case '{':
                    deque.addLast(c);
                    break;
                case '(':
                    deque.addLast(c);
                    break;
                case ']':
                    if (deque.size() != 0) {
                        Character d = deque.removeLast();
                        if (!d.equals('['))
                            return false;
                    } else return false;
                    break;
                case '}':
                    if (deque.size() != 0) {
                        Character d = deque.removeLast();
                        if (!d.equals('{'))
                            return false;
                    } else return false;
                    break;
                case ')':
                    if (deque.size() != 0) {
                        Character d = deque.removeLast();
                        if (!d.equals('('))
                            return false;
                    } else return false;
                    break;
            }
        }
        
        if (queue.size() == 0 && deque.size() == 0)
            return true;
        
        return false;
    }
}