import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = s.length();
        for (int i = 2; i < n; i++) {
            char c = s.charAt(i); 
            if (c == '{' || c == '}' || c == ',') continue;
            
            int j;
            for (j = i; j < n - 2; j++) {
                char cc = s.charAt(j);
                if (cc == ',' || cc == '}') break;
            }
            
            int k = Integer.parseInt(s.substring(i, j));
            map.put(k, map.getOrDefault(k, 0) + 1);
            
            i = j;
        }
        
        return map.entrySet()
            .stream()
            .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
            .map(e -> e.getKey())
            .mapToInt(Integer::intValue)
            .toArray();
    }
}