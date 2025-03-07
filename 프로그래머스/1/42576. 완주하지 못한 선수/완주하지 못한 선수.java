import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            if (map.get(c) == 1) {
                map.remove(c);
                continue;
            }
            
            map.put(c, map.get(c) - 1);
        }
        
        return map.entrySet()
            .stream()
            .map(Map.Entry::getKey)
            .findFirst()
            .get();
    }
}