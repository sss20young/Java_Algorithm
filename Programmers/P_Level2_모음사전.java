import java.util.*;

class P_Level2_모음사전 {

    public static void main(String[] args) {
        solution("EIO");
    }

    public static int solution(String word) {
        int answer = 0;
        
        char[] array = {'A', 'E', 'I', 'O', 'U'};
        int[] increase = {781, 156, 31, 6, 1};
        
        char[] wordArray = word.toCharArray();
        int size = wordArray.length;
        
        for (int i = 0; i < size; i++) {
            int index = Arrays.binarySearch(array, wordArray[i]);
            answer += index * increase[i];
        }
        answer += size;

        return answer;
    }
}