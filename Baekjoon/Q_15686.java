import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_15686 {
	static int N;
	static int[][] arr;
	static ArrayList<Index> house_location = new ArrayList<Index>();// 집 위치
	static ArrayList<Index> chicken_location = new ArrayList<Index>(); // 치킨집 위치
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					house_location.add(new Index(i, j)); // 집에 저장
				else if (arr[i][j] == 2)
					chicken_location.add(new Index(i, j)); // 치킨집에 저장
			}
		}
		
		boolean[] visited = new boolean[chicken_location.size()];
		combination(chicken_location, visited, 0, M);

		System.out.println(min);
	}
	
	// 백트래킹을 이용한 조합 nCr
	static void combination(ArrayList<Index> n, boolean[] visited, int start, int r) { // n개 중 r개 선택
		if(r == 0) {
			getMin(visited);
			return;
		} else {
			for(int i = start; i < n.size(); i++) {
				visited[i] = true;
				combination(n, visited, i + 1, r - 1);
				visited[i] = false;
			}
		}
	}
	
	static void getMin(boolean[] visited) {
		int distance_sum = 0;
		
		for (int i = 0; i < house_location.size(); i++) {
			Index house_sth = house_location.get(i);
			int each_min_distance = Integer.MAX_VALUE;
			
			for (int j = 0; j < chicken_location.size(); j++) {
				if (visited[j] == true) {
					Index chicken_sth = chicken_location.get(j);
					int distance = Math.abs(chicken_sth.x - house_sth.x) + Math.abs(chicken_sth.y - house_sth.y);
					each_min_distance = Math.min(each_min_distance, distance);
				}	
			}
			distance_sum += each_min_distance;
		}
		
		min = Math.min(min, distance_sum);
	}
}

class Index {
	int x, y;
	
	Index(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
