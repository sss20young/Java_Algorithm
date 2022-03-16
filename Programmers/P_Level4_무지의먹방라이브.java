import java.util.*;

class P_Level4_무지의먹방라이브 {

    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        solution(food_times, 5);
    }

    public static int solution(int[] food_times, long k) {
        
        ArrayList<Food> food = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) {
            food.add(new Food(i+1, food_times[i]));
        }
        
        // 오름차순 정렬
        Collections.sort(food, (o1, o2) -> o1.time - o2.time);
        
        int len = food_times.length;
        int i = 0;
        long remainTime = food.get(i).time;
        long minusTime = 0;
        while (len*remainTime <= k && i < food_times.length) {
            k -=  len*remainTime;
            len--;
            i++;
            minusTime += remainTime;
            if (i >= food_times.length) return -1;
            remainTime = food.get(i).time - minusTime;
        }
        
        k = k % len;
        food.subList(i, food_times.length).sort((o1, o2) -> o1.index - o2.index); // index 오름차순 정렬
        
        return food.get((int) k+i).index;
    }

    static class Food {
        int index;
        int time;

        Food(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}