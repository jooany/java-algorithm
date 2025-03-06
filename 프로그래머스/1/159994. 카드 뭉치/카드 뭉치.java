import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> q1 = new ArrayDeque<>(List.of(cards1));
        Deque<String> q2 = new ArrayDeque<>(List.of(cards2));
        
        for (String s : goal) {
            if (s.equals(q1.peek())) {
                q1.poll();
            } else if (s.equals(q2.peek())) {
                q2.poll();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}