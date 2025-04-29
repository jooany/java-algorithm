import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] numbers = number.toCharArray();

        for (int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && k != 0 && stack.peek() < numbers[i]) {
                stack.pop();
                k--;
            }
            
            stack.push(numbers[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        
        return k > 0 ? sb.substring(0, sb.length() - k) : sb.toString();
    }
}