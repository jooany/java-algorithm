import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 귤의 크기, 귤의 개수
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        int min = 0;
        
        List<Map.Entry<Integer, Integer>> entries = map.entrySet()
            .stream()
            .sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed())
            .collect(Collectors.toList());
        
        for (Map.Entry<Integer, Integer> e : entries) {
            if (k == 0) break;
            
            min++;
            
            int v = e.getValue();
            
            while (v > 0 && k > 0) {
                v--;
                k--;
            }
        }
        
        return min;
    }
}