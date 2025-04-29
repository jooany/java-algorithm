import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] numbers = number.toCharArray();

        for (int i = 0; i < numbers.length; i++) {
            if (!stack.isEmpty() && stack.peek() < numbers[i]) {
                while(!stack.isEmpty() && k != 0 && stack.peek() < numbers[i]) {
                    stack.pop();
                    k--;
                }
            }
            
            stack.push(numbers[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        
        if (k != 0) {
            return sb.toString().substring(0, sb.length() - k);
        }
        
        return sb.toString();
    }
}