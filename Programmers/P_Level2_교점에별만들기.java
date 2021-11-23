import java.util.*;

class P_Level2_교점에별만들기 {
    static List<int[]> array = new ArrayList<>();
    static int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

    public static void main(String[] args) {
        solution(line);
    }
        
    public static String[] solution(int[][] line) {
        String[] answer;
                    
        for (int i = 0; i < line.length-1; i++) {
            for (int j = i+1; j < line.length; j++) {
                calc(line[i], line[j]);
            }
        }
        
        answer = draw();
        return answer;
    }
    
    public static void calc(int[] intA, int[] intB) {
        // int 범위 초과로 인해 long형으로 변환
        long[] a = new long[intA.length];
        long[] b = new long[intB.length];
        for (int i = 0; i < intA.length; i++) {
            a[i] = intA[i];
            b[i] = intB[i];
        }
        
        long under = a[0]*b[1] - a[1]*b[0];
        
        if (under == 0) { // 평행 또는 일치 (but, 일치 하는 직선은 주어지지 않음)
            
        } else {
            
            long x = (a[1]*b[2] - a[2]*b[1]);
            long y = (a[2]*b[0] - a[0]*b[2]);
            
            if (x % under == 0 && y % under == 0) {
                int intX = (int) (x / under);
                int intY = (int) (y / under);
                int[] intArray = {intX, intY};
                array.add(intArray);
            }
        }
    }
    
    public static String[] draw() {
        // x의 최소 최대, y의 최소 최대 찾기
        int xMax = array.get(0)[0];
        int yMax = array.get(0)[1];
        int xMin = array.get(0)[0];
        int yMin = array.get(0)[1];
        
        for (int i = 0; i < array.size(); i++) {
            xMax = Math.max(xMax, array.get(i)[0]);
            yMax = Math.max(yMax, array.get(i)[1]);
            xMin = Math.min(xMin, array.get(i)[0]);
            yMin = Math.min(yMin, array.get(i)[1]);
        }
        
        String[][] list = new String[yMax-yMin+1][xMax-xMin+1];

        for (int i = 0; i < yMax-yMin+1; i++) {
            for (int j = 0; j < xMax-xMin+1; j++) {
                list[i][j] = ".";
            }
        }
        for (int i = 0; i < array.size(); i++) {
            list[array.get(i)[1] - yMin][array.get(i)[0] - xMin] = "*";
        }

        String[] reverseList = new String[yMax-yMin+1];

        for (int i = list.length-1; i >= 0; i--) {
            reverseList[i] = "";
            
        }
        int k = 0;

        for (int i = list.length-1; i >= 0; i--) {
            for (int j = 0; j < list[0].length; j++) {
                reverseList[k] += list[i][j];
            }
            System.out.println(reverseList[k]);
            k++;
        }

        return reverseList;
    }
}