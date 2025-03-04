import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                continue;
            }
            
            if (stack.size() == 0) {
                return false;
            }
            
            stack.pop();
        }
        
        return stack.isEmpty();
    }
}