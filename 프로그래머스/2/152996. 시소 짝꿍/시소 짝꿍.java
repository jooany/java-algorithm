import java.util.*;

class Solution {
    public long solution(int[] weights) {
        // 몸무게, 인원 수
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        
        long answer = 0;
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int weight = e.getKey();
            int cnt = e.getValue();
            
            if (cnt >= 2) {
                answer += (long) cnt * (cnt - 1) / 2;
            }
            
            if (map.containsKey(weight * 2)) {
                answer += (long) cnt * map.get(weight * 2);
            }
            
            if (weight * 3 % 2.0 == 0 && map.containsKey(weight * 3 / 2)) {
                answer += (long) cnt * map.get(weight * 3 / 2);
            }
            
            if (weight * 4 % 3.0 == 0 && map.containsKey(weight * 4 / 3)) {
                answer += (long) cnt * map.get(weight * 4 / 3);
            }
        }
        
        return answer;
    }
}