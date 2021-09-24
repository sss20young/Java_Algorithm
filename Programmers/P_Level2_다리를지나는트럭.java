import java.util.*;

class P_Level2_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int seconds = 0;
        int[] x = new int[bridge_length];
        int i = 0;
        
        while (i < truck_weights.length) {
            
            // 이동
            if (x[bridge_length - 1] != 0)
                x[bridge_length - 1] = 0;
            
            for (int a = 1; a < bridge_length; a++) {
                x[bridge_length -a] = x[bridge_length -1 -a];
                x[bridge_length -1 -a] = 0;
            }


            if (sum(x) + truck_weights[i] <= weight) {
                x[0] = truck_weights[i];
                i++;
            }

            seconds++;
        }

        // 마지막 트럭 건너는 것 포함
        return seconds + bridge_length;
    }
    
    public int sum(int[] a) {
        int sum = 0;
        
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        
        return sum;
    }
}