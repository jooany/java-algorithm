import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] nums = number.toCharArray();
        
        for (char c : number.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() < c) {
                stack.pollLast();
                k--;
            }
            
            stack.offerLast(c);
        }
        
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                stack.pollLast();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(String.valueOf(stack.pollFirst()));
        }
        
        return sb.toString();
    }
}