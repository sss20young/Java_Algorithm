import java.util.*;

class P_Level3_입국심사 {

    public static void main(String[] args) {
        int[] times = {7, 10};
        solution(6, times);
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        long sum = 0;
        
        Arrays.sort(times);
        
        long left = 0;
        long right = (long) times[times.length-1] * n; // int -> long
        while (left <= right) {
            long mid = (left + right) / 2;
            
            sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            
            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}