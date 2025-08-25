class Solution {
    private static final int mod = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][]dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        
        for (int[] p : puddles) {
            dp[p[1]][p[0]] = -1;
        }
        
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (dp[y][x] == -1) {
                    dp[y][x] = 0;
                    continue;
                }
                
                if (y > 1) {
                    dp[y][x] += dp[y - 1][x] % mod;
                }
                
                if (x > 1) {
                    dp[y][x] += dp[y][x - 1] % mod;
                }
                
                dp[y][x] %= mod;
            }
        }
        
        return dp[n][m];
    }
}