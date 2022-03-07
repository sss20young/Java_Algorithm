import java.util.*;

class P_Level2_후보키 {
    
    static ArrayList<String> array;
    static int column;
    static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        solution(relation);
    }
    
    public static int solution(String[][] relation) {
        
        column = relation[0].length;
        for (int i = 1; i <= column; i++) { // 컬럼의 길이 중 i개 뽑기 (중복 X) -> 4Ci
            array = new ArrayList<>();
            dfs(0, i, 0, "");
            
            for (int j = 0; j < array.size(); j++) {
                if (isUniqueness(relation, array.get(j))
                   && isMinimality(relation, array.get(j), answer))
                    answer.add(array.get(j));
            }
        }
        
        return answer.size();
    }
    
    static void dfs(int start, int n, int count, String str) {
        if (start > column) return;
        
        if (count == n) {
            array.add(str);
            return;
        }
        dfs(start+1, n, count, str); // X
        dfs(start+1, n, count+1, str+" "+start); // O
    }
    
    static boolean isUniqueness(String[][] relation, String str) {
        
        HashSet<List<String>> set = new HashSet<>();
        
        for (String[] r: relation) {
            List<String> smallList = new LinkedList<>();
            String[] sss = str.split(" ");
            for (int i = 0; i < sss.length; i++) {
                if (!sss[i].isEmpty()) {
                    int index = Integer.parseInt(sss[i]);
                    smallList.add(r[index]);
                }
            }
            // set에 있는지 확인
            if (!set.contains(smallList))
                set.add(smallList);
            // 있으면
            else return false;
        }
        
        return true;
    }
    
    static boolean isMinimality(String[][] relation, String str, ArrayList<String> answer) {
        for (String s: answer) {
            String[] ss = s.split(" ");
            String[] sss = str.split(" ");
            
            int count = 0;
            for (int i = 0; i < sss.length; i++) {
                for (int j = 0 ; j < ss.length; j++) {
                    if (!sss[i].isEmpty() && !ss[j].isEmpty()) {
                        if (sss[i].equals(ss[j]))
                            count++;
                    }
                }
            }
            
            if (count == ss.length -1)
                return false;
        }
        
        return true;
    }
}