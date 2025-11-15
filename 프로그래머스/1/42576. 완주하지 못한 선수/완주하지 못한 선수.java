import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + 1);
            } else {
                map.put(p, 1);
            }
        }
        
        for (String c : completion) {
            
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                
                if (cnt == 1) {
                    map.remove(c);
                } else {
                    map.put(c, cnt - 1);
                }
            }
        }
        
        return map.entrySet()
            .stream()
            .map((e) -> e.getKey())
            .findFirst()
            .orElse(null);
    }
}