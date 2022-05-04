import java.util.*;

class P_Level1_숫자문자열과영단어 {
    
    public static void main(String[] args) {
        solution("one4seveneight");
    }

    public static int solution(String s) {
        
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        Map<String, Integer> map2 = new HashMap<>();
        map.put("0", 0);
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        
        int start = 0;
        int index = 1;
        String answer = "";
        while (start < s.length()) {
            String slice = s.substring(start, start+index);
            if (map.containsKey(slice)) {
                answer += map.get(slice);
                start = start+index;
                index = 1;
            } else if (map2.containsKey(slice)) {
                answer += map2.get(slice);
                start = start+index;
                index = 1;
            }
            else
                index++;
        }
        
        return Integer.valueOf(answer);
    }
}