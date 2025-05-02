import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int length = triangle.length;
        int[][] dp = new int[length][length];
        dp[length - 1] = triangle[length - 1];
        
        for (int i = length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                dp[i - 1][j] = triangle[i - 1][j] + Math.max(dp[i][j], dp[i][j + 1]);
            }
        }
        
        return dp[0][0];
    }
}