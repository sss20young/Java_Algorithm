import java.util.*;

class P_Level2_프린터 {

    static ArrayList<Printer> array = new ArrayList<Printer>();
    static ArrayList<Printer> finArray = new ArrayList<Printer>();

    public static void main(String[] args) {
        int[] record = {1,1,9,1,1,1};
        int location = 0;
        solution(record, location);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        char start = 'A';
        for (int i = 0; i < priorities.length; i++) {
            array.add(new Printer((char)(start+i), priorities[i]));
        }

        iter();

        for (int i = 0; i < priorities.length; i++) {
            if (finArray.get(i).alphabet == start+location)  {
                answer = i+1;
            }
        }

        return answer;
    }

    public static void iter() {
        int size = array.size();
        for (int i = 0; i < size; i++) {
            int biggestIndex = getBiggestIndex();
            if (biggestIndex != 0) {
                changePosition(biggestIndex);
            }
            finArray.add(array.remove(0));
        }
    }

    public static int getBiggestIndex() {
        int index = 0;
        int biggest = array.get(0).prior;
        for (int i = 0; i < array.size(); i++) {
            if (biggest < array.get(i).prior) {
                index = i;
                biggest = array.get(i).prior;
            }
        }
        return index;
    }

    public static void changePosition(int position) {
        for (int i = 0; i < position; i++) {
            array.add(array.remove(0));
        }
    }

    static class Printer {
        char alphabet;
        int prior;

        Printer(char alphabet, int prior) {
            this.alphabet = alphabet;
            this.prior = prior;
        }
    }
}