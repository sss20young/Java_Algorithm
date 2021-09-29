import java.util.*;

class P_Level2_오픈채팅방 {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }

    public static String[] solution(String[] record) {

        HashMap<String, String> nickname = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<>();

        for (String one_record: record) {

            String[] split = one_record.split(" ");

            if (split[0].equals("Enter")) {
                nickname.put(split[1], split[2]);
                list.add(split);
            } else if (split[0].equals("Leave")) {
                list.add(split);
            } else if (split[0].equals("Change")) {
                nickname.put(split[1], split[2]);
            }
        }

        int alpha = list.size();
        String[] answer = new String[alpha];        

        for (int i = 0; i < alpha; i++) {
            String[] message = list.get(i);
            answer[i] = nickname.get(message[1]) + "님이 " + toKorean(message[0]);
        }
        
        return answer;
    }

    public static String toKorean(String str) {
        if (str.equals("Enter"))
            return "들어왔습니다.";
        else
            return "나갔습니다.";
    }
}