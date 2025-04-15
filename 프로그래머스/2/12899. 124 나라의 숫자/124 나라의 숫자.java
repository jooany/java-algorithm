import java.util.*;

class Solution {
    public String solution(int n) {
        int[] numbers = new int[]{4,1,2};
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        while (true) {
            stack.push(numbers[n % 3]);
            
            if (n <= 3) break;
            
            if (n % 3 == 0) {
                n = n / 3 - 1;
            } else {
                n /= 3;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop().toString());
        }
        
        return sb.toString();
    }
}