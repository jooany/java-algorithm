import java.util.*;

class Solution {
    int solution(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        int[][] dp = new int[m][n];
        dp[0] = land[0];
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = 0;
                
                for (int k = 0; k < 4; k++) {
                    if (k == j) continue;
                    
                    max = Math.max(max, dp[i - 1][k]);
                }
                
                dp[i][j] = max + land[i][j];
            }
        }
        
        int answer = 0;
        
        for (int k = 0; k < 4; k++) {
            answer = Math.max(answer, dp[m - 1][k]);
        }

        return answer;
    }
    
}