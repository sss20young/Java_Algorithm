import java.io.*;

public class Q_10775 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine()); // 게이트
        int P = Integer.parseInt(br.readLine()); // 비행기
        int[] gArray = new int[P]; // 비행기가 착륙할 게이트 범위
        for (int i = 0; i < P; i++) {
            gArray[i] = Integer.parseInt(br.readLine());
        }

        // 유니온 파인드
        parent = new int[G+1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        
        int count = 0;
        for (int i = 0; i < P; i++) {
            int g = gArray[i]; 
            int emptyGate = find(g);
            if (emptyGate == 0)
                break;
            count++;
            union(emptyGate, emptyGate - 1);
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int g) {
        if (parent[g] != g)
            parent[g] = find(parent[g]);
        return parent[g];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y)
            parent[x] = y;
    }
}