import java.util.*;
import java.io.*;

public class Q_1541 {
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();

        // 1. split
        String splited[] = s.split("-");
        ArrayList<String> splitedList = new ArrayList<>();
        for (int i = 0; i < splited.length; i++) {
            if (splited[i].contains("+")) { // 2. 계산
                String splitByPlus[] = splited[i].split("\\+"); // 역슬래쉬 2개를 꼭 붙여준다.
                int result = 0;
                for (int j = 0; j < splitByPlus.length; j++)
                    result = result + Integer.parseInt(splitByPlus[j]);
                splitedList.add(String.valueOf(result));
            } else
                splitedList.add(splited[i]);
        }

        // 3. 계산
        int sum = Integer.parseInt(splitedList.get(0));
        for (int i = 1; i < splitedList.size(); i++) {
            sum  = sum - Integer.parseInt(splitedList.get(i));
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
