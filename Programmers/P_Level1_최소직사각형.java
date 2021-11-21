public class P_Level1_최소직사각형 {

    public static int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
    public static void main(String[] args) {
        solution(sizes);
    }
    
    public static int solution(int[][] sizes) {
        int answer = 0;
        
        int w = 0;
        int h = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            w = Math.max(sizes[i][0], w);
            h = Math.max(sizes[i][1], h);
        }
        
        if (w > h) {
            for (int i = 0; i < sizes.length; i++) {
                if (sizes[i][0] < sizes[i][1]) { // switch
                    int temp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = temp;
                }
            }
        } else {
            for (int i = 0; i < sizes.length; i++) {
                if (sizes[i][0] > sizes[i][1]) { // switch
                    int temp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = temp;
                }
            }
        }
        
        w = 0;
        h = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            w = Math.max(sizes[i][0], w);
            h = Math.max(sizes[i][1], h);
        }
        
        answer = w * h;
        return answer;
    }
}
