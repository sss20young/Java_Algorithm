import java.util.*;

class P_Level3_디스크컨트롤러 {

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        solution(jobs);
    }

    public static int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
        
        int count = 0;
        int time = 0;
        int index = 0;
        int sum = 0;
        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                priorityQueue.add(jobs[index]);
                index++;
            }
            
            if (priorityQueue.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] job = priorityQueue.poll();
                sum += job[1] + (time-job[0]);
                time += job[1];
                count++;
            }
        }
        
        return (int) (sum / jobs.length);
    }
}