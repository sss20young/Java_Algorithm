class Solution {

    public void main(String args[]) {
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        solution(a);
    }

    public static int solution(int[] a) {
        int answer = 0;
        if (a.length == 1)
            answer = 1;
        else
            answer = 2;
        
        if (a.length >= 3) {
            int leftMin = a[0];
            
            int[] right = new int[a.length];
            right[a.length-1] = a[a.length-1];
            for (int i = a.length-2; i > 0; i--) {
                right[i] = Math.min(a[i], right[i+1]);
            }
            int rightMin = right[1];
            for (int i = 1; i < a.length-1; i++) {
                // 왼쪽 제일 작은 수
                leftMin = Math.min(leftMin, a[i-1]);
                
                // 오른쪽 제일 작은 수
                rightMin = right[i+1];
                
                if (leftMin < a[i]) {
                    if (rightMin > a[i]) {
                        answer++;
                    }
                } else {
                    answer++;
                }
                    
            }
        }
        
        return answer;
    }
}