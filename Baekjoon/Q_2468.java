import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_2468 {
	static int N; // 2차원 배열의 행과 열의 개수
	static int array[][]; // 입력받을 배열
	static int check[][]; // 방문 여부
	static int count = 0; // 잠기지 않은 지역이 이어져있는 개수
	static int place = 0; // 잠기지 않은 지역 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		array = new int[N][N]; 
		ArrayList<Integer> area = new ArrayList<Integer>(); // 안전한 영역
		int max; // 지역 높이의 최대값
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max= array[0][0]; // 초기값 설정
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, array[i][j]);
			}
		}
		
		for (int h = 0; h <= max; h++) { // 높이가 0 ~ max 일 떄
			check = new int[N][N]; // 방문 여부 초기화
			
			// 높이가 달라질 때마다 count와 place 초기화
			count = 0;
			place = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (check[i][j] == 0 && array[i][j] > h) {
						visit(i, j, h);
						
						if (count > 0)
							place++;
						count = 0;
					}
				}
			}
			
			if (place > 0)
				area.add(place);
		}
		
		int size = area.size();
		
		int solution = 0; // 비가 오지 않을 경우
		for (int i = 0; i < size; i++) {
			solution = Math.max(solution, area.get(i));
		}
		
		System.out.println(solution);
	}
	
	public static void visit(int i, int j, int h) {
		if (array[i][j] > h) {
			check[i][j] = 1;
			count++;
			
			// 상 하 좌 우 방문
			if (i != 0) 
				if (array[i-1][j] > h && check[i-1][j] == 0) { // 상
					visit(i-1, j, h); // 방문
				}
			if (i != N-1)
				if (array[i+1][j] > h && check[i+1][j] == 0) { // 하
					visit(i+1, j, h); // 방문
				}
			if (j != 0)
				if (array[i][j-1] > h && check[i][j-1] == 0) { // 좌
					visit(i, j-1, h); // 방문
				}
			if (j != N-1)
				if (array[i][j+1] > h && check[i][j+1] == 0) { // 우
					visit(i, j+1, h); // 방문
				}
		}
	}
}
