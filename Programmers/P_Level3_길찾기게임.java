import java.util.*;

class P_Level3_길찾기게임 {
    
    List<Integer> preList = new LinkedList<>();
    List<Integer> postList = new LinkedList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        
        // copy
        int[][] copyNodeInfo = new int[nodeinfo.length][2];
        for (int i = 0; i < nodeinfo.length; i++) {
            copyNodeInfo[i][0] = nodeinfo[i][0];
            copyNodeInfo[i][1] = nodeinfo[i][1];
        }
        
        // y방향으로 내림차순, x방향 오름차순 정렬해서 저장
        Arrays.sort(copyNodeInfo, new Comparator<int[]>() { 
            @Override 
            public int compare(int[] o1, int[] o2) { 
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                else return o2[1] - o1[1];
            } 
        });

        Queue<Node> queue = new LinkedList<>(); 
        for (int i = 0; i < nodeinfo.length; i++) {
            for (int j = 0; j < nodeinfo.length; j++) {
                if (Arrays.equals(copyNodeInfo[i], nodeinfo[j])) {
                    Node node = new Node(j+1, nodeinfo[j][0], nodeinfo[j][1]);
                    queue.add(node);
                }
            }
        }
        
        // 이진 트리 셋팅
        Node rootNode = queue.poll();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            insertNode(rootNode, queue.poll());
        }
         
        // 순회
        preOrder(rootNode);
        postOrder(rootNode);
        
        int[][] answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }
        
        return answer;
    }
    
    void insertNode(Node parent, Node node) {
                    
        if (node.x < parent.x) {
            if (parent.leftNode == null)
                parent.leftNode = node;
            else
                insertNode(parent.leftNode, node);
        } 
        else { 
            if (parent.rightNode == null)
                parent.rightNode = node;
            else
                insertNode(parent.rightNode, node);
        }
    }
    
    void preOrder(Node node) {
        if (node == null) return;
        
        preList.add(node.data);
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }
    
    void postOrder(Node node) {
        if (node == null) return;
        
        postOrder(node.leftNode);
        postOrder(node.rightNode);
        postList.add(node.data);
    }
    
    class Node {
        int data; // 번호(몇 번째인지)
        int x;
        int y;
        Node leftNode;
        Node rightNode;
        
        Node(int data, int x, int y) {
            this.data = data;
            this.x = x;
            this.y = y;
        }
    }
}