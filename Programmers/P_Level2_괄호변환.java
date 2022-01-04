import java.util.*;

class P_Level2_괄호변환 {

    public static void main(String[] args) {
        solution("()))((()");
    }

    public static String solution(String p) {
        return recursive(p);
    }
    
    public static String recursive(String str) {
        
        // 1. 빈 문자열인 경우, 빈 문자열을 반환
        if (str.length() == 0)
            return "";
        
        // 2. 분리
        UV uv = divide(str);

        // 3. D & C
        if (validate(uv.u)) {
            return uv.u + recursive(uv.v);
        } else {
            return change(uv.u, uv.v);
        }
    }

    public static UV divide(String w) {

        int count = 0;
        int index = 0;

        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                index = i+1;
                break;
            }
        }
        
        String u, v;

        if (w.length() > index) {
            u = w.substring(0, index);
            v = w.substring(index);
        } else {
            u = w;
            v = "";
        }

        return new UV(u,v);
    }

    public static boolean validate(String s) {
        Queue<Character> check = new LinkedList<Character>();

        if (s.charAt(0) == '(') {
            check.add('(');

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '(') 
                    check.add('(');
                else {
                    if (check.isEmpty())
                        return false;
                    check.poll();
                }
            }

            return true;
        }

        return false;
    }

    public static String change(String u, String v) {
        String result = "(";
        result += recursive(v);
        result += ")";
        
        if (u.length() > 2)
            u = u.substring(1, u.length()-1);
        else
            u = "";

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(')
                result += ")";
            else
                result +="(";
        }

        return result;
    }

    public static class UV {
        String u;
        String v;

        UV(String u, String v) {
            this.u = u;
            this.v = v;
        }
    }
}