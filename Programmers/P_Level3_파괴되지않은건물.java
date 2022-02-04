class P_Level3_파괴되지않은건물 {
    static int[][] result;
    static int[][] prefixSum;

    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        solution(board, skill);
    }
    
    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        result = board;
        prefixSum = new int[board.length+1][board[0].length+1];
        
        for (int i = 0; i < skill.length; i++) {
            if (skill[i][0] == 1) { // minus 
                prefixSum[skill[i][1]][skill[i][2]] += -1 * skill[i][5];
                prefixSum[skill[i][3]+1][skill[i][2]] += 1 * skill[i][5];
                prefixSum[skill[i][1]][skill[i][4]+1] += 1 * skill[i][5];
                prefixSum[skill[i][3]+1][skill[i][4]+1] += -1 * skill[i][5];
            } else { // plus
                prefixSum[skill[i][1]][skill[i][2]] += 1 * skill[i][5];
                prefixSum[skill[i][3]+1][skill[i][2]] += -1 * skill[i][5];
                prefixSum[skill[i][1]][skill[i][4]+1] += -1 * skill[i][5];
                prefixSum[skill[i][3]+1][skill[i][4]+1] += 1 * skill[i][5];
            }
        }
        
        calc();
        
        answer = counting();

        return answer;
    }
    
    static void calc() {
        
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = 1; j < prefixSum[0].length; j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i][j];
            }
        }
        
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum[0].length; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j];
            }
        }
    }
    
    static int counting() {
        int count = 0;
        
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] + prefixSum[i][j] > 0) 
                    count++;
            }
        }
        
        return count;
    }
}

// class Solution {
//     int[][] result;
    
//     public int solution(int[][] board, int[][] skill) {
//         int answer = 0;
        
//         result = board;
        
//         for (int i = 0; i < skill.length; i++) {
//             if (skill[i][0] == 1) // minus
//                 calc(1, skill[i][1], skill[i][2], skill[i][3], skill[i][4], skill[i][5]);
//             else // plus
//                 calc(2, skill[i][1], skill[i][2], skill[i][3], skill[i][4], skill[i][5]);
//         }
        
//         answer = counting();
        
//         return answer;
//     }
    
//     void calc(int plusOrMinus, int startX, int startY, int endX, int endY, int how) {
//         if (plusOrMinus == 1) {
//             for (int i = startX; i <= endX; i++) {
//                 for (int j = startY; j <= endY; j++) {
//                     result[i][j] = result[i][j] - how;
//                 }
//             }
//         } else {
//             for (int i = startX; i <= endX; i++) {
//                 for (int j = startY; j <= endY; j++) {
//                     result[i][j] = result[i][j] + how;
//                 }
//             }
//         }
//     }
    
//     int counting() {
//         int count = 0;
        
//         for (int i = 0; i < result.length; i++) {
//             for (int j = 0; j < result[0].length; j++) {
//                 if (result[i][j] > 0)
//                     count++;
//             }
//         }
        
//         return count;
//     }
// }