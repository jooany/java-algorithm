import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
                        
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - 1 - stack.pop();
        }
        
        return answer;
    }
}