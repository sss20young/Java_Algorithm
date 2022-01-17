public class P_Level2_카펫 {
    public static void main(String[] args) {
        solution(10, 2);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sumOfWAndH = (brown + 4) / 2;
        
        for (int w = 3; w < sumOfWAndH; w++) {
            if (w >= sumOfWAndH - w && brown == sumOfWAndH*2-4 && yellow == w*(sumOfWAndH-w) - brown) {
                answer[0] = w;
                answer[1] = sumOfWAndH-w;
                return answer;
            }
        }
        
        return answer;
    }
}