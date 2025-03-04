import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                stack.push('(');
                continue;
            } 
            
            if (stack.isEmpty() || stack.pop() == c) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}