import java.util.*;

class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = n - 1;
        
        // 커서 이동
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            answer = Math.min(answer, 2*i + n - next);
            answer = Math.min(answer, i + 2*(n - next));
        }
        
        // 알파벳 고르기
        for (char c : name.toCharArray()) {
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        return answer;
    }
}