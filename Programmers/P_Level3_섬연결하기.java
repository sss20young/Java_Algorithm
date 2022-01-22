import java.util.*;

class P_Level3_섬연결하기 {
    static int parentNode[];

    public static void main(String[] args) {
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        solution(4, costs);
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, Comparator.comparingInt(o1 -> o1[2]));
        parentNode = new int[n];   
        for (int i = 0; i < n; i++) {
            parentNode[i] = i;
        }
        
        int count = 0;
        int index = 0;
        while(count != n-1) {            
            // 싸이클이 발생하지 않는지 확인
            if (getParentNode(costs[index][0]) != getParentNode(costs[index][1])) {
                
                if (getParentNode(costs[index][0]) > getParentNode(costs[index][1]))
                    parentNode[getParentNode(costs[index][0])] = getParentNode(costs[index][1]);
                else
                    parentNode[getParentNode(costs[index][1])] = getParentNode(costs[index][0]);
                
                answer += costs[index][2];
                count++;
            }
            index++;
        }
        
        return answer;
    }
    
    static int getParentNode(int node) {
        if (parentNode[node] == node)
            return node;
        else 
            return parentNode[node] = getParentNode(parentNode[node]);
    }
}