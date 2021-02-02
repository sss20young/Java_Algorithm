import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H_2020_QualificationRound2 {
	static String[] input_files = new String[] {"a_example", "b_read_on", "e_so_many_books", "f_libraries_of_the_world"}; // TODO: "c_incunabula", "d_tough_choices"
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static BasicInfo basicInfo;
	
	public static void main(String[] args) throws IOException {
		for (int input = 0; input < input_files.length; input++) {
			br = new BufferedReader(new FileReader("C:\\Algorithm\\Java_Algorithm\\Hash Code\\2020_QualificationRound\\input\\"+input_files[input]+".txt"));
			
			basicInfo = new BasicInfo();
			
			Library[] librariesArray = new Library[basicInfo.libraries];
			for (int i = 0; i < basicInfo.libraries; i++) {
				librariesArray[i] = new Library(i);
			}
			
			makeSolution(librariesArray, basicInfo);
			
			printSolution(librariesArray, input);
				
			br.close();
		}
	}
	
	static class BasicInfo {
		public int books;
		public int libraries;
		public int days;
		public int[] scores;
		public int[] check;
		public int libraries_count;

		public BasicInfo() throws IOException {
			st = new StringTokenizer(br.readLine());
			this.books = Integer.parseInt(st.nextToken());
			this.libraries = Integer.parseInt(st.nextToken());
			this.days = Integer.parseInt(st.nextToken());
			this.check = new int[books];
			
			st = new StringTokenizer(br.readLine());
			this.scores = new int[this.books];
			for (int i = 0; i < books; i++) {
				this.scores[i] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static class Library {
		public int has_books;
		public int signup_process_days;
		public int ship_books_per_day;
		public int index;
		public ArrayList<Integer> what_books = new ArrayList<Integer>();
		public int[] temporary;
		public ArrayList<Integer> scanned_books = new ArrayList<Integer>();
		
		public Library(int index) throws IOException {
			st = new StringTokenizer(br.readLine());
			this.has_books = Integer.parseInt(st.nextToken());
			this.signup_process_days = Integer.parseInt(st.nextToken());
			this.ship_books_per_day = Integer.parseInt(st.nextToken());
			this.index = index;
			
			st = new StringTokenizer(br.readLine());
			temporary = new int[has_books];
			for (int i = 0; i < this.has_books; i++) {
				temporary[i] = Integer.parseInt(st.nextToken());
			}
			
			bubblesort(temporary); // scores 값이 높은 순으로 정렬
			
			for (int i = 0; i < this.has_books; i++) {
				what_books.add(temporary[i]);
			}
		}
	}

	// scores 값이 높은 순으로 정렬
	public static void bubblesort(int[] array) {
		int temp = 0;
		
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length-1-i; j++) {
				if (basicInfo.scores[array[j]] < basicInfo.scores[array[j+1]]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}	
			}
		}
	}
	
	public static void makeSolution(Library[] librariesArray, BasicInfo basicInfo) {
		// TODO: 도서관이 가지고 있는 책들 중 score값이 높고, has_books가 많고, ship_books_per_day가 높고, signup_process_days 낮은 순으로 정렬해야함
		Arrays.sort(librariesArray, (o1, o2) -> Integer.compare(o1.signup_process_days, o2.signup_process_days)); // signup_process_days이 작은 순으로 정렬
		
		// int[][] array = new int[basicInfo.libraries][basicInfo.days]; // OutofMemoryError: Java heap space
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < basicInfo.libraries; i++) {
			array.add(new ArrayList<Integer>());
		}
		
		// signup_process_days 넣기
		int day = 0;
		int k = 0;
		for (int i = 0; i < basicInfo.libraries; i++) {
			for (int j = 0; j < basicInfo.libraries; j++) { // 2차원 배열 탐색
				for (k = day; k < day+librariesArray[i].signup_process_days; k++) {
					if (k >= basicInfo.days) break;
					
					if (array.get(j).size() <= k && i == j) { // array[j][k] == 0
						array.get(j).add(-1); // // array[j][k] == -1
						if (k == day) { // signup_process 된 libraries count
							basicInfo.libraries_count++;
						}
					} 
					if (day > 0 && array.get(j).size() > day-1) {
						if (array.get(j).get(day-1) == -1)
							continue;
					} else if (array.get(j).size() <= k) {
						array.get(j).add(-2);
					}
				}
			}
			
			day = k;
		}
		
		// ship_books_per_day 넣기
		int what_books_index;
		
		for (int j = 0; j < basicInfo.days; j++) { // 2차원 배열을 세로로 탐색!
			for (k = 0; k < basicInfo.libraries; k++) {
				if (array.get(k).size() <= j) {
					for (int l = 0; l < librariesArray[k].ship_books_per_day; l++) {
						if (!librariesArray[k].what_books.isEmpty()) {
							what_books_index = librariesArray[k].what_books.remove(0);
							
							if (basicInfo.check[what_books_index] == 0) { // 이미 ship_book 되어서 겹치는 책 포함하지 않기(check)
								if (array.get(k).size() <= j) {
									array.get(k).add(basicInfo.scores[what_books_index]); // 스코어 값 넣어주기
								} else {
									int sum = array.get(k).get(j) + basicInfo.scores[what_books_index]; // 스코어 값 더해서 넣어주기
									array.get(k).add(j, sum);
 								}
								librariesArray[k].scanned_books.add(what_books_index);
								basicInfo.check[what_books_index] = 1;
							} else {
								l--;
							}
						}
					}
				}
			}
		}
		
		// for (int i = 0; i < basicInfo.libraries; i++) {
		// 	for (int j = 0; j < array.get(i).size(); j++) {
		// 		System.out.print(array.get(i).get(j));
		// 	}
		// 	System.out.println();
		// }
	}
	
	// 각 Library에서 submission 값 저장해서 출력
	public static void printSolution(Library[] librariesArray, int input) throws IOException {
		bw = new BufferedWriter(new FileWriter("C:\\Algorithm\\Java_Algorithm\\Hash Code\\2020_QualificationRound\\output\\"+input_files[input]+".txt", true));

		StringBuilder sb = new StringBuilder();
		sb.append(basicInfo.libraries_count+"\n");
		
		for (int i = 0; i < basicInfo.libraries_count; i++) {
			sb.append(librariesArray[i].index + " " + librariesArray[i].scanned_books.size()+"\n");
			for (int j = 0; j < librariesArray[i].scanned_books.size(); j++) {
				sb.append(librariesArray[i].scanned_books.get(j) + " ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}

	public H_2020_QualificationRound() {
	}
}