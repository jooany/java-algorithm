import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String[] split = convertToKNum(n, k).split("0");
        int cnt = 0;
        
        for (String s : split) {
            if (!"".equals(s) && isPrimeNumber(Long.parseLong(s))) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private String convertToKNum(int num, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        while (num >= k) {
            stack.push(num % k);
            num /= k;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
    
    private boolean isPrimeNumber(long n) {
        if(n == 2) return true;
        
        if (n < 2 || n % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}