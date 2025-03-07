import java.util.*;

class Solution {
    private static final Map<String, String> messageMap = Map.of(
        "Enter", "%s님이 들어왔습니다.",
        "Leave", "%s님이 나갔습니다."
    );
    
    public String[] solution(String[] record) {
        // (키: uid, 값: 닉네임)
        Map<String, String> map = new HashMap<>();
        
        for (String s : record) {
            String[] split = s.split(" ");
            
            if (!split[0].equals("Leave")) {
                map.put(split[1], split[2]);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String s : record) {
            String[] split = s.split(" ");
            
            if (!messageMap.containsKey(split[0])) {
                continue;
            }
            
            result.add(String.format(messageMap.get(split[0]), map.get(split[1])));
        }
        
        return result.toArray(new String[0]);
    }
}