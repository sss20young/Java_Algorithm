import java.util.*;

public class P_Level3_줄서는방법 {
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        solution(3, 5);
    }
    
    public static ArrayList<Integer> solution(int n, long k) {
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        if (n >= 2) 
            calc(n, k);
        else
            answer.add(1);

        return answer;
    }
    
    static void  calc(int n, long k) {
        for (int i = n; i > 2; i--) {
            long factorial = factorial(i-1);
            long a = k / factorial;
            k = k % factorial;
            
            if (k == 0) {
                a = a - 1;
                answer.add(list.get((int) a));
                list.remove((int) a);
                int size = list.size();
                for (int j = size-1; j >= 0; j--) {
                    answer.add(list.get(j));
                    list.remove((int)j);
                }
                return;
            }
                
            answer.add(list.get((int) a));
            list.remove((int) a);
        }
        
        answer.add(list.get((int) 0));
        list.remove((int) 0);
        answer.add(list.get(0));
        list.remove(0);
    }
    
    static long factorial(long n) {
        if (n == 1)
            return 1;
        return n*factorial(n-1);
    }
}