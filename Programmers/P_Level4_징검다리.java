import java.util.*;

class P_Level4_징검다리 {

    public static void main(String[] args) {
        int[] rocks = {2, 14, 11, 21, 17};
        solution(25, rocks, 2);
    }

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        while (left <= right) {
            int count = 0;
            int mid = (left + right) / 2;
            int standard = 0;
            
            for (int rock: rocks) {
                if (rock - standard >= mid) {
                    standard = rock;
                } else {
                    count++; // remove
                }
            }
            
            if (distance - standard < mid) 
                count++;
            
            if (n >= count) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return answer;
    }
}