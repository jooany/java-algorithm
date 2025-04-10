import java.util.*;

class Solution {
    String ss;
    int convertCnt, removedZeroCnt;
    
    public int[] solution(String s) {
        ss = s;
        
        while (!"1".equals(ss)) {
            if (ss.contains("0")) {
                int originalLength = ss.length();
                ss = ss.replace("0", "");
                removedZeroCnt += originalLength - ss.length();
            }
            
            int length = ss.length();
            Deque<Integer> stack = new ArrayDeque<>();
            
            while (length > 1) {
                stack.push(length % 2);
                length /= 2;
            }
            
            stack.push(length);
            
            StringBuilder sb = new StringBuilder();
            
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            
            ss = sb.toString();
            convertCnt++;
        }
        
        return new int[]{convertCnt, removedZeroCnt};
    }
}