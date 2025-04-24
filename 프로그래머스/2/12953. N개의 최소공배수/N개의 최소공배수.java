import java.util.*;

class Solution {
    public int solution(int[] arr) {
        // <숫자, 개수>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
            HashMap<Integer, Integer> currMap = new HashMap<>();
            
            while (num % 2 == 0) {
                currMap.put(2, currMap.getOrDefault(2, 0) + 1);
                num /= 2;
            }
            
            for (int i = 3; i <= Math.sqrt(num); i += 2) {
                while (num % i == 0) {
                    currMap.put(i, currMap.getOrDefault(i, 0) + 1);
                    num /= i;
                }
            }
            
            if (num > 2) {
                currMap.put(num, currMap.getOrDefault(num, 0) + 1);
            }
            
            for (Map.Entry<Integer, Integer> e : currMap.entrySet()) {
                int key = e.getKey();
                int value = e.getValue();
                
                if (map.containsKey(key) && map.get(key) >= value) continue;
                
                map.put(key, value);
            }
        }
        
        int answer = 1;
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            answer *= Math.pow(e.getKey(), e.getValue());
        }
        
        return answer;
    }
}