import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        for (char c : name.toCharArray()) {
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int min = name.length() - 1;
        
        for (int i = 0; i < name.length() - 1; i++) {
            int endA = i + 1;
            
            while (endA < name.length() && name.charAt(endA) == 'A') {
                endA++;
            }
            
            min = Math.min(min, 
                           Math.min(2 * i + name.length() - endA, i + 2 * (name.length() - endA))
                           );
        }
        
        return answer + min;
    }
}