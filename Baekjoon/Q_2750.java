import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2750 {
	public static void main(String[] args) throws IOException {
		
		// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
		int array[] = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		selectionsort(array);
		insertsort(array);
		bubblesort(array);
	}
	
	// 선택 정렬
	static void selectionsort(int[] array) {
		int temp = 0;
		int min;
		
		for (int i = 0; i < array.length-1; i++) {
			min = i;
			
			for (int j = i+1; j < array.length; j++) {
				if (array[min] > array[j]) {
					min = j; // 최소값 구하기
				}
			}
			
			if (i != min) {
				temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	// 삽입 정렬
	static void insertsort(int[] array) {
		int key;
		int j;
				
		for (int i = 1; i < array.length; i++) {
			key = array[i]; // key는 범위 중 가장 끝쪽에 있는 인덱스 요소
			
			for (j = i-1; j >= 0 && array[j] > key; j--) {
				// key값이 더 작으면 j가 뒤로 밀리고, 그렇지 않으면 j에 정착한다.
				array[j+1] = array[j];
			}
			array[j+1] = key;
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	// 버블 정렬
	static void bubblesort(int[] array) {
		int temp = 0;
		
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length-1-i; j++) {
				if (array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}	
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
