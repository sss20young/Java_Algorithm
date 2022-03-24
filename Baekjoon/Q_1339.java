import java.util.*;
import java.io.*;

public class Q_1339 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = br.readLine();
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < N; i++) {
            int size = array[i].length()-1;
            for (int j = 0; j < array[i].length(); j++) {
                alphabet[array[i].charAt(j) - 65] += Math.pow(10, size);
                size--;
            }
        }

        Arrays.sort(alphabet);

        int sum = 0;
        int number = 9;
        for (int i = 25; i >= 0; i--) {
            sum += alphabet[i] * number;
            number--;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

// [ 반례 있음 ]
// 10
// ABB
// BB
// BB
// BB
// BB
// BB
// BB
// BB
// BB
// BB
// 정답값 : 1790
// 출력값 : 1780

// public class Q_1339 {
    
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//         int N = Integer.parseInt(br.readLine());
//         String[] array = new String[N];
//         int maxSize = 0;
//         for (int i = 0; i < N; i++) {
//             array[i] = br.readLine();
//             maxSize = Math.max(maxSize, array[i].length());
//         }

//         Arrays.sort(array, (o1, o2) -> o2.length() - o1.length()); // 내림차순 정렬
//         // 자릿수 맞추기
//         for (int i = 0; i < N; i++) {
//             int plusZero = maxSize - array[i].length();
//             for (int j = 0; j < plusZero; j++) {
//                 array[i] = "0" + array[i];
//             }
//         }

//         // 1. 변경할 알파벳 선택
//         int number = 9;
//         for (int i = 0; i < maxSize; i++) {
//             for (int j = 0; j < N; j++) {
//                 if (array[j].charAt(i) - '0' > 9) { // 문자인 경우,
//                     // 2. 배열 안에 있는 알파벳 숫자로 변경
//                     char target = array[j].charAt(i);
//                     for (int k = 0; k < N; k++) {
//                         array[k] = array[k].replace(target, (char) (number + '0'));
//                     }
//                     number--;
//                 }
//             }
//         }

//         // 3. 계산
//         long sum = 0;
//         for (int i = 0; i < N; i++) {
//             sum += Long.parseLong(array[i]);
//         }

//         bw.write(sum + "\n");
//         bw.flush();
//         bw.close();
//         br.close();
//     }
// }
