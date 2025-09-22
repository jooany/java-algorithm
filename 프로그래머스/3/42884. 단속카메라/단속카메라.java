import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });
        
        int end = -30001;
        int answer = 0;
        
        for (int[] route : routes) {
            if (route[0] <= end) continue;
            
            answer++;
            end = route[1];
        }
        
        return answer;
    }
}