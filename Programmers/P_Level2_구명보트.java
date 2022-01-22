import java.util.*;

public class P_Level2_구명보트 {

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        solution(people, 100);
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();        
        for (int p: people) {
            list.add(p);
        }
        Collections.sort(list, Collections.reverseOrder());

        // 시간초과로 인해, list remove 대신 count 사용하기
        int count = 0;
        int firstIndex = 0;
        int lastIndex = list.size()-1;
        while(count != people.length){
            int a = list.get(firstIndex);
            list.set(firstIndex, 300); // 240까지 입력으로 주어지기에 존재하지 않는 값으로 셋팅
            firstIndex++;
            count++;
            
            if(list.size() != 0 && list.get(lastIndex) != 300 && a+list.get(lastIndex)<=limit) {
                list.set(lastIndex, 300);
                count++;
                lastIndex--;
            }
            answer++;
        }
        return answer;
    }
}