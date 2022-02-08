import java.util.*;

class P_Level3_다단계칫솔판매 {

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        solution(enroll, referral, seller, amount);
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> name = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            name.put(enroll[i], i);
        }
        
        // 트리 만들기
        HashMap<String, String> tree = new HashMap<>(); // 본인, 본인을 추천한 사람
        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-")) 
                tree.put(enroll[i], "center");
            else tree.put(enroll[i], referral[i]);
        }
        
        // 각각 계산해서 저장
        for (int i = 0; i < seller.length; i++) {
            int price = amount[i] * 100;
            answer[name.get(seller[i])] += (int) (price* 0.9); // 90%
            
            price = (int) (price * 0.1); // 10%
            String upper = tree.get(seller[i]);
            
            while(!upper.equals("center")) {
                answer[name.get(upper)] += price - (int) (price * 0.1);
                price = (int) (price * 0.1);
                
                if (price == 0) 
                    break;
                
                upper = tree.get(upper);
            }
        }
        
        return answer;
    }
}