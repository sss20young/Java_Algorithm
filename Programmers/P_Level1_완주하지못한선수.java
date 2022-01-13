import java.util.*;

class P_Level1_완주하지못한선수 {
    static String[] participant = {"leo", "kiki", "eden"};
    static String[] completion = {"eden", "kiki"};
    public static void main(String[] args) {
        solution(participant, completion);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();

        for (String p: participant)
            map.put(p, map.getOrDefault(p, 0)+1);
        for (String c: completion)
            map.put(c, map.get(c)-1);
        
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            if (e.getValue() == 1)
                answer = e.getKey();
        }

        return answer;
    }
}