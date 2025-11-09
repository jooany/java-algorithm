import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int remain = k;
        
        for (char c : number.toCharArray()) {
            
            while (remain > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                remain--;
            }
            
            sb.append(c);
        }
        
        if (remain > 0) {
            sb.setLength(sb.length() - remain);
        }
        
        return sb.toString();
    }
}