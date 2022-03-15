import java.util.*;
import java.io.*;

public class Q_1202 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

        st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

        Jewelry[] list = new Jewelry[N];
        for (int i = 0; i < N; i++) { // 보석
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            list[i] = new Jewelry(weight, price);
        }
        Arrays.sort(list, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
				// 무게 오름차순 정렬
                if (o1.getWeight() == o2.getWeight()) {
                    return o2.getPrice() - o1.getPrice(); // 가격 내림차순 정렬
                }
				return o1.getWeight() - o2.getWeight();
			}
        });

        int[] bagArray = new int[K];
        for (int i = 0; i < K; i++) { // 가방
            bagArray[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagArray); // 오름차순 정렬

        long result = 0;
        PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1, o2) -> o2.getPrice() - o1.getPrice()); // 내림차순
        for (int i = 0, j = 0; i < K; i++) { // 가방

            while (j < N && list[j].getWeight() <= bagArray[i]) {
                pq.add(list[j]);
                j++;
            }
            if (!pq.isEmpty())
                result += pq.poll().getPrice();
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Jewelry {
    int weight;
    int price;

    Jewelry(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}