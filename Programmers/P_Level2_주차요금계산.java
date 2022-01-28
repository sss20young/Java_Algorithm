import java.util.*;

class P_Level2_주차요금계산 {

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees, records);
    }

    public static int[] solution(int[] fees, String[] records) {
        HashMap<String, String> hourMinute = new HashMap<>(); // <차량번호, 시:분>
        HashMap<String, Integer> minuteDifference = new HashMap<>(); // <차량번호, 분 차이>
        
        for (String record: records) {
            String[] list = record.split(" ");
            
            if (list[2].equals("IN"))
                hourMinute.put(list[1], list[0]);
            else {
                int minute = calcMinute(hourMinute.get(list[1]), list[0]);

                if (minuteDifference.containsKey(list[1]))
                    minuteDifference.put(list[1], minuteDifference.get(list[1]) + minute);
                else
                    minuteDifference.put(list[1], minute);
                hourMinute.remove(list[1]);
            }
        }
        
        for (Map.Entry<String, String> e: hourMinute.entrySet()) {
            int minute = calcMinute(e.getValue(), "23:59");
            if (minuteDifference.containsKey(e.getKey()))
                minuteDifference.put(e.getKey(), minuteDifference.get(e.getKey()) + minute);
            else 
                minuteDifference.put(e.getKey(), minute);
        }
                          
        // 정렬  
		Object[] keySet = minuteDifference.keySet().toArray();
		Arrays.sort(keySet);
        
        int[] answer = new int[minuteDifference.keySet().size()];
        int i = 0;
        for (Object key: keySet) {
            answer[i] = calcFee(fees[0], fees[1], fees[2], fees[3], minuteDifference.get(key));
            i++;
        }
        
        return answer;
    }
                          
    static int calcMinute(String in, String out) {
        
        int inHour = Integer.parseInt(in.split(":")[0]);
        int inMinute = Integer.parseInt(in.split(":")[1]);
        int outHour = Integer.parseInt(out.split(":")[0]);
        int outMinute = Integer.parseInt(out.split(":")[1]);

        return Math.abs((inHour * 60 + inMinute) - (outHour * 60 + outMinute));
    }
    
    static int calcFee(int defaultTime, int defaultFee, int splitTime, int splitFee, int minute) {
        if (minute > defaultTime)
            return defaultFee + (int) Math.ceil((double) (minute - defaultTime) / splitTime) * splitFee;
        else
            return defaultFee;
    }
}