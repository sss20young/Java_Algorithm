import java.util.*;

class P_Level1_실패율 {

    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution(5, stages);
    }

    public static int[] solution(int N, int[] stages) {
        
        Arrays.sort(stages);
        int[] n = new int[N];
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] <= N)
                n[stages[i]-1] += 1;
        }
        
        int challenger = stages.length;
        HashMap<Integer, Double> failRate = new HashMap<>();
        for (int i = 0; i < N; i++) {
            failRate.put(i+1, (double) n[i] / challenger);
            challenger -= n[i];
        }
        
        // 실패율 내림차순 정렬
        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(failRate.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
                public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                    if (o1.getValue() > o2.getValue())
                        return -1;
                    else if (o1.getValue() < o2.getValue())
                        return 1;
                    else
                        return 0;
            }
        });
        
        int[] answer = new int[N];
        int i = 0;
        for(Map.Entry<Integer, Double> entry : entryList) {
			answer[i] = entry.getKey();
            i++;
		}
        
        return answer;
    }
}