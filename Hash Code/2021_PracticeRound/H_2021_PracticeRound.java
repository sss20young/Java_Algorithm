import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class H_2021_PracticeRound {
	static String[] input_files = new String[] {"a_example", "b_little_bit_of_everything", "c_many_ingredients", "d_many_pizzas", "e_many_teams"};
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int typeOfIngredientsIndex; // typeOfIngredients의 index
	static int resultIndex;
	static ArrayList<ArrayList<Integer>> result;
	
	public static void main(String[] args) throws IOException {
		for (int input = 0; input < input_files.length; input++) {
			br = new BufferedReader(new FileReader("C:\\Algorithm\\Java_Algorithm\\Hash Code\\2021_PracticeRound\\input\\"+input_files[input]+".in"));
			
			Pizza pizza = new Pizza();

			makeSolution(pizza);
			
			printSolution(input);
				
			br.close();
		}
	}
	
	static class Pizza {
		public int theNumberOfPizzas; // 전체 피자 수
		public int theNumberOf2PersonTeam, theNumberOf3PersonTeam, theNumberOf4PersonTeam; // 인원 수 별 팀 수
		public int theNumberOfIngredients; // 하나의 피자에 들어가는 재료 수
		public ArrayList<ArrayList<String>> typeOfIngredients = new ArrayList<ArrayList<String>>();
		
		public Pizza() throws IOException {
			st = new StringTokenizer(br.readLine());
			this.theNumberOfPizzas = Integer.parseInt(st.nextToken());
			this.theNumberOf2PersonTeam = Integer.parseInt(st.nextToken());
			this.theNumberOf3PersonTeam = Integer.parseInt(st.nextToken());
			this.theNumberOf4PersonTeam = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < this.theNumberOfPizzas; i++) {
				st = new StringTokenizer(br.readLine());
				this.theNumberOfIngredients = Integer.parseInt(st.nextToken());

				this.typeOfIngredients.add(new ArrayList<String>());
				this.typeOfIngredients.get(i).add(Integer.toString(i));

				for (int j = 1; j <= this.theNumberOfIngredients; j++) {
					this.typeOfIngredients.get(i).add(st.nextToken());
				}
			}
		}
	}
	
	public static void makeSolution(Pizza pizza) {
		result = new ArrayList<ArrayList<Integer>>();

		// ingredients를 기준으로 내림차순 정렬
		Collections.sort(pizza.typeOfIngredients, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> s1, ArrayList<String> s2) {
                if (s1.size() < s2.size()) {
                    return 1;
                } else if (s1.size() > s2.size()) {
                    return -1;
                }
                return 0;
            }
        });

		typeOfIngredientsIndex = 0;
		resultIndex = 0;
		deliver(pizza, 4); // 4인 팀
		deliver(pizza, 3); // 3인 팀
		deliver(pizza, 2); // 2인 팀
	}

	// 각 팀에게 피자 전달
	public static void deliver(Pizza pizza, int theNumberOfPeople) {
		int theNumberOfPersonTeam = 0; // 인원 수 별 팀 수

		if (theNumberOfPeople == 4)
			theNumberOfPersonTeam = pizza.theNumberOf4PersonTeam;
		else if (theNumberOfPeople == 3)
			theNumberOfPersonTeam = pizza.theNumberOf3PersonTeam;
		else if (theNumberOfPeople == 2)
			theNumberOfPersonTeam = pizza.theNumberOf2PersonTeam;
		
		for (int i = 0; i < theNumberOfPersonTeam; i++) {
			if (typeOfIngredientsIndex + theNumberOfPeople - 1 < pizza.theNumberOfPizzas) { // 4개,3개,2개 이상의 피자가 남아 있는 경우에만 전달
				result.add(new ArrayList<Integer>());
				result.get(resultIndex).add(theNumberOfPeople);
				for (int j = 0; j < theNumberOfPeople; j++) {
					result.get(resultIndex).add(Integer.parseInt(pizza.typeOfIngredients.get(typeOfIngredientsIndex).get(0)));
					typeOfIngredientsIndex++;
				}
				resultIndex++;
			} else {
				break;
			}
		}
	}
	
	public static void printSolution(int input) throws IOException {
		bw = new BufferedWriter(new FileWriter("C:\\Algorithm\\Java_Algorithm\\Hash Code\\2021_PracticeRound\\output\\"+input_files[input]+".out", true));

		StringBuilder sb = new StringBuilder();
		sb.append(result.size()+"\n");

		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				sb.append(result.get(i).get(j) + " ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}
}