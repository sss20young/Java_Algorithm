import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K_2020_RoundG_1 { // class명은 Solution으로 제출 
	static BufferedReader br;
    static String[] array;
    static int[] count;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int T = Integer.parseInt(br.readLine());
        array = new String[T];
        count = new int[T];
        for (int i = 0; i < T; i++) {
            array[i] = br.readLine();

            int length = array[i].length();
            for (int j = 0; j < length; j++) {
                if (array[i].charAt(j) == 'K')
                    findKick(i, j, length);
            }
        }

        for (int i = 1; i <= T; i++) {
            System.out.println("Case #"+ i + ": "+count[i-1]);
        }
    }

    public static void findKick(int i, int j, int length) {
        if (j+4 < length) { // index 범위 안벗어나도록 check
            if (array[i].charAt(j+1) == 'I')
                if (array[i].charAt(j+2) == 'C')
                    if (array[i].charAt(j+3) == 'K')
                        for (int k = j+4; k < length; k++) {
                            if (array[i].charAt(k) == 'S')
                                findStart(i, k, length);
                        }
        }
    }

    public static void findStart(int i, int j, int length) {
        if (j+4 < length) { // index 범위 안벗어나도록 check
            if (array[i].charAt(j) == 'S')
                if (array[i].charAt(j+1) == 'T')
                    if (array[i].charAt(j+2) == 'A')
                        if (array[i].charAt(j+3) == 'R')
                            if (array[i].charAt(j+4) == 'T')
                                count[i] += 1;

        }
    }
}	