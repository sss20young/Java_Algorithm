import java.util.*;
import java.io.*;

public class Q_16637 {

    static int N;
    static long max = Long.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(String.valueOf(s.charAt(i)));
        }

        dfs(list, 0);

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(LinkedList<String> list, int index) {

        // deep copy
        LinkedList<String> newList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i));
        }

        // 계산
        long result = Long.parseLong(list.get(0));
        int idx = 1;
        for (int i = 0; i < (list.size()-1)/2; i++) {
            result = calc(list.get(idx), result, Long.parseLong(list.get(idx+1)));
            idx += 2;
        }
        max = Math.max(max, result);
    
        // X (괄호 없음)
        if (index < list.size())
            dfs(newList, index+2);

        // O (괄호 있음)
        if (index+2 < list.size()) {
            long result2 = calc(list.get(index+1), Long.parseLong(list.get(index)), Long.parseLong(list.get(index+2)));
            newList.add(index, Long.toString(result2));
            for (int i = 0; i < 3; i++) {
                newList.remove(index+1);
            }
            dfs(newList, index+2);
        }
    }

    static long calc(String operator, Long operand1, Long operand2) {
        long result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
        }

        return result;
    }
}
