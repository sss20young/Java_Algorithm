import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q_18352 {
    static int N, M, K, X;
    static PriorityQueue<Graph> priorityQueue = new PriorityQueue<>();
    static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        ArrayList<ArrayList<Graph>> array = new ArrayList<ArrayList<Graph>>();
        for (int i = 0; i <= N; i++) {
            array.add(new ArrayList<Graph>());
        }

        int start, end;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            array.get(start).add(new Graph(end, 1));
        }

        int[] distance = new int[N+1];
        int[] visited = new int[N+1];
        Arrays.fill(distance, INF); // distance를 INF로 채우기
        priorityQueue.offer(new Graph(X, 0));
        distance[X] = 0;
        while(!priorityQueue.isEmpty()) {
            // STEP 1: 집합에 들어있는 노드로부터 아직 방문하지 않은 노드까지의 거리를 구한다.
            int w = priorityQueue.poll().end;
            if (visited[w] == 1)
                continue;

            visited[w] = 1;
            
            // dijkstra 알고리즘
            for (Graph g : array.get(w)) {
                if (distance[g.end] > distance[w] + g.weight) { 
                    distance[g.end] = distance[w] + g.weight;
                    // STEP 2: 최소값을 갖는 노드를 찾아 priorityQueue에 넣는다.
                    priorityQueue.add(new Graph(g.end, distance[g.end]));
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K)
                count++;
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                result[index] = i;
                index++;
            }
        }

        Arrays.sort(result);

        if (count == 0) // 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력
            System.out.println(-1);

        else {
            for (int i = 0; i < count; i++) {
                System.out.println(result[i]);
            }
        }
    }

    // array 배열에 시작노드부터 end노드까지의 weight를 표현하기 위함
    static class Graph implements Comparable<Graph> {
        int end;
        int weight;

        Graph(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Graph g) {
            return this.weight - g.weight;
        }
    }
}