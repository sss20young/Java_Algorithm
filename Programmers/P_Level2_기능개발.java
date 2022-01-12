import java.util.*;

public class P_Level2_기능개발 {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        solution(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int q = (100 - progresses[i]) / speeds[i];
            int r = (100 - progresses[i]) % speeds[i];
            if (r == 0)
                queue.add(q);
            else queue.add(q+1);
        }
        
        int standard = queue.poll();
        int count = 1;
        int next;
                
        while (!queue.isEmpty()) {
            if (standard >= (next = queue.poll()))
                count++;
            else {
                list.add(count);
                count = 1;
                standard = next;
            }
        }
        list.add(count);
        
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) 
            answer[i] = list.get(i);

        return answer;
    }
}