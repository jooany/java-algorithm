import java.util.*;

class Solution {
    int convertCnt, removedZeroCnt;
    
    public int[] solution(String s) {
        
        while (!"1".equals(s)) {
            int zeroCnt = s.replace("1", "").length();  
            removedZeroCnt += zeroCnt;
            
            s = Integer.toBinaryString(s.length() - zeroCnt);
            
            convertCnt++;
        }
        
        return new int[]{convertCnt, removedZeroCnt};
    }
}