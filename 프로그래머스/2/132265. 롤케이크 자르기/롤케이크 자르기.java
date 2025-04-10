import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> all = new HashMap<>();
        HashSet<Integer> partner = new HashSet<>();
        
        for (int t : topping) {
            all.put(t, all.getOrDefault(t, 0) + 1);
        }
        
        for (int t: topping) {
            
            if (all.get(t) == 1) {
                all.remove(t);
            } else {
                all.put(t, all.get(t) - 1);
            }
            
            partner.add(t);
            
            if (partner.size() > all.size()) {
                break;
            }
            
            if (partner.size() == all.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}