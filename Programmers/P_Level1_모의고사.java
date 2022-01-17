import java.util.*;

public class P_Level1_모의고사 {
    

    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        solution(answers);
    }

    public static int[] solution(int[] answers) {
        
        int[] choooseOne = {1,2,3,4,5};
        int[] chooseTwo = {2,1,2,3,2,4,2,5};
        int[] chooseThree = {3,3,1,1,2,2,4,4,5,5};
        
        int one = score(answers, choooseOne);
        int two = score(answers, chooseTwo);
        int three = score(answers, chooseThree);
        
        int[] list = {one, two, three};
        int max = Arrays.stream(list).max().getAsInt();
        
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            if (max == list[i])
                temp.add(i+1);
        
        int[] answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = temp.get(i);
        
        return answer;
    }
    
    static int score(int[] answers, int[] choose) {

        int score = 0;
        
        for (int i = 0; i < answers.length; i++) {
            int r;
            
            if (i == 0) r = 0;
            else r = i%choose.length;

            if (answers[i] == choose[r])
                score++;
        }
        
        return score;
    }
}
