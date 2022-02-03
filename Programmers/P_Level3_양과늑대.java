import java.util.*;

class P_Level3_양과늑대 {
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static int max = 0;

    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        solution(info, edges);
    }
    
    public static int solution(int[] info, int[][] edges) {
                
        // 이진 트리 생성
        for (int[] e: edges) {
            if (!tree.containsKey(e[0]))
                tree.put(e[0], new ArrayList<>());
            tree.get(e[0]).add(e[1]);
        }
        
        // 탐색
        List<Integer> list = new ArrayList<>();
        list.add(0);
        DFS(0, 0, 0, info, list);
        
        return max;
    }
    
    static void DFS(int start, int s, int w, int[] info, List<Integer> list) {
        if (info[start] == 0) s++;
        else if (info[start] == 1) w++;
                    
        if (s <= w)
            return;
        
        if (max < s)
            max = s;
        
        List<Integer> next = new ArrayList<>();
		next.addAll(list);
        if (tree.containsKey(start))
            next.addAll(tree.get(start));
        next.remove(Integer.valueOf(start));
        
        // 다음 노드
        for (int n: next) {
            DFS(n, s, w, info, next);
        }
        
        return;
    }
}