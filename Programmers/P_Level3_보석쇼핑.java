import java.util.*;

class P_Level3_보석쇼핑 {

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        solution(gems);
    }

    public static int[] solution(String[] gems) {
        
        // 투 포인터
        
        Set<String> set = new HashSet<>();
        for (String gem: gems) 
            set.add(gem);
        int size = set.size(); // 가져야할 보석의 개수
        
        Map<String, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int min = gems.length+1;
        int[] answer = new int[2];
        for (String gem: gems) { // end 이동
            if (map.containsKey(gem)) {
                map.put(gem, map.get(gem)+1);
            } else {
                map.put(gem, 1);
            }
            
            while (map.size() == size && start <= end) {
                
                // update
                if (end - start + 1 < min) { 
                    answer[0] = start+1;
                    answer[1] = end+1;
                    min = end - start + 1;
                }
                
                // start 이동
                if (start < gems.length) {
                    map.put(gems[start], map.get(gems[start])-1);
                    if (map.get(gems[start]) == 0) map.remove(gems[start]);
                    start++;
                } else break;
            }
            end++;
        }
        
        return answer;
        
        /* 정확성 테스트만 통과
        
        Set<String> set = new HashSet<>();
        for (String gem: gems) 
            set.add(gem);
        int size = set.size(); // 가져야할 보석의 개수
        
        int min = gems.length+1;
        int[] answer = new int[2];
        for (int i = 0; i < gems.length; i++) {
            
            Set<String> cart = new HashSet<>();
            int index = i;
            while (cart.size() != size && index < gems.length) {
                cart.add(gems[index]);
                index++;
            }
            index--;
            
            if (cart.size() == size && index-i+1 < min) {
                min = index-i+1; // update
                answer[0] = i+1;
                answer[1] = index+1;
            }
        }
        
        return answer;
        
        */
    }
}