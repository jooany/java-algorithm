import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;        
        int length = s.length();
        
        A:for (int i = 0; i < length; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            
            for (int j = i; j < i + length; j++) {
                char c = j  < length ? s.charAt(j) : s.charAt(j - length);
                
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                    continue;
                }
                
                if (stack.isEmpty() || stack.peek() != getPairOne(c)) {
                    continue A;
                }
        
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private char getPairOne(char c) {
        return switch (c) {
            case ')' -> '(';
            case ']' -> '[';
            default -> '{';
        };
    }
}