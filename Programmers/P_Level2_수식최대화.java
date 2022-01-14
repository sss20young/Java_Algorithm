import java.util.*;

class P_Level2_수식최대화 {

    static ArrayList<String> array;
    static String[] order = {"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};

    public static void main(String[] args) {
        solution("100-200*300-500+20");
    }

    public static long solution(String expression) {
        long answer = 0;
        
        // 1. expression을 연산과 피연산으로 나누기
        String[] operand = expression.split("\\+|\\-|\\*");

        // 2. 6개의 조합 다 해보기
        for (int i = 0; i < 6; i++) {
            array = new ArrayList<>();
            int index = -1;
            array.add(operand[0]);
            for (int j = 1; j < operand.length; j++) {
                index += operand[j-1].length() + 1;
                array.add(Character.toString(expression.charAt(index)));
                array.add(operand[j]);
            }
            
            calc(Character.toString(order[i].charAt(0)));
            calc(Character.toString(order[i].charAt(1)));
            calc(Character.toString(order[i].charAt(2)));
            
            // 3. 최대값 도출(절댓값)
            if (answer < Math.abs(Long.parseLong(array.get(0))))
                answer = Math.abs(Long.parseLong(array.get(0)));
        }

        return answer;
    }
    
    static void calc(String operator) {
        while (array.contains(operator)) {
            int leftIndex = array.indexOf(operator) - 1;
            int rightIndex = array.indexOf(operator) + 1;
            long result;
            if (operator.equals("+"))
                result = Long.parseLong(array.get(leftIndex)) + Long.parseLong(array.get(rightIndex));
            else if (operator.equals("-"))
                result = Long.parseLong(array.get(leftIndex)) - Long.parseLong(array.get(rightIndex));
            else
                result = Long.parseLong(array.get(leftIndex)) * Long.parseLong(array.get(rightIndex));
            array.remove(leftIndex);
            array.remove(leftIndex);
            array.remove(leftIndex);
            array.add(leftIndex, Long.toString(result));
        }
    }
}