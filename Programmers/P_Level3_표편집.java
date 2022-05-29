import java.util.*;

public class P_Level3_표편집 {

    public static void main(String[] args) {
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        solution(8, 2, cmd);
    }
    

    public static String solution(int n, int k, String[] cmd) {
        
        /* 정확성 테스트만 통과
        
        LinkedList<Integer> array = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            array.add(i);
        }
        int index = k; // 가리키는 위치
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].substring(0,1).equals("U")) {
                int target = Integer.valueOf(cmd[i].substring(2));
                index -= target;
            } else if (cmd[i].substring(0,1).equals("D")) {
                int target = Integer.valueOf(cmd[i].substring(2));
                index += target;
            } else if (cmd[i].substring(0,1).equals("C")) {
                int number = array.get(index);
                array.remove(index); // 현재 선택된 행을 삭제
                // stack에 넣기
                stack.add(index+" "+number);
                if (index == array.size()) index--;
                
            } else if (cmd[i].substring(0,1).equals("Z")) {
                String p = stack.pop();
                String[] info = p.split(" ");
                array.add(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
                
                if (index >= Integer.parseInt(info[0])) index++;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        int j = 0;
        for (int i = 0; i < array.size(); i++) {
            answer.append("O");
        }
        while (!stack.isEmpty()) {
            answer.insert(Integer.parseInt(stack.pop().split(" ")[0]), "X");
        }
        
        return answer.toString();
        
        */
    
        int size = n;
        Stack<Integer> stack = new Stack<>();
        
        for (String singleCmd: cmd) {
            char c = singleCmd.charAt(0);
            if (c == 'U') {
                int target = Integer.valueOf(singleCmd.substring(2));
                k -= target;
            } else if (c == 'D') {
                int target = Integer.valueOf(singleCmd.substring(2));
                k += target;
            } else if (c == 'C') {
                stack.push(k);
                size--;
                if (k == size) k--;
            } else if (c == 'Z') {      
                if (k >= stack.pop()) k++;
                size++;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < size; i++) {
            answer.append("O");
        }
        while (!stack.isEmpty()) {
            answer.insert(stack.pop(), "X");
        }
        
        return answer.toString();
    }
}
