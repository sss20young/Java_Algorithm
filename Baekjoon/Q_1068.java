import java.util.*;
import java.io.*;

public class Q_1068 {
    static int count = 0;
    static HashMap<Integer, LinkedList<Integer>> hashmap; // 부모 노드, 자식 노드

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] pArray = new int[N];
        for (int i = 0; i < N; i++) {
            pArray[i] = Integer.parseInt(st.nextToken());
        }
        int D = Integer.parseInt(br.readLine());

        int start = 0;
        hashmap = new HashMap<>(); 
        for (int i = 0; i < N; i++) {
            if (pArray[i] == -1)
                start = i;
            else {
                if (!hashmap.containsKey(pArray[i])) {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(i);
                    hashmap.put(pArray[i], list); // add
                }
                else {
                    LinkedList<Integer> list = hashmap.get(pArray[i]);
                    list.add(i);
                    hashmap.put(pArray[i], list); // update
                }
            }
        }

        // root가 삭제되면 count = 0
        if (D != start) {
            dfs(start, D); // D 지우기
            dfsLeaf(start); // 리프노드 갯수 세기
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int n, int d) {
        LinkedList<Integer> children = hashmap.get(n);
        if (children == null) return;

        if (children.contains(d)) {
            int index = children.indexOf(d);
            children.remove(index);
            hashmap.put(n, children);
            return;
        }
        else {
            for (int i = 0; i < children.size(); i++) {
                dfs(children.get(i), d);
            }
        }
        return;
    }

    static void dfsLeaf(int n) {
        LinkedList<Integer> children = hashmap.get(n);
        if (children == null || children.size() == 0) {
            count++;
            return;
        }
        else {
            for (int i = 0; i < children.size(); i++) {
                dfsLeaf(children.get(i));
            }
        }
        return;
    }
}