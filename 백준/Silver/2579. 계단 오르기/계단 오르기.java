import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] steps = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }
        
        /*        
        [k][c] k번째 계단에서, k-1번째 계단을 밟았으면 0, 안밟았으면 1
        
        // 이전 계단을 밟되, 그 계단이 그 전 계단을 밟지 않아야 한다.
        [k][0] = [k-1][1] + steps[k];
        
        // 2 계단 이전을 밟는다. 그 계단 최댓값을 더한다.
        [k][1] = Math.max([k-2][0], [k-2][1]) + steps[k];
        */
        
        if (n == 1) {
            System.out.println(steps[1]);
            return;
        }
        
        if (n == 2) {
            System.out.println(steps[1] + steps[2]);
            return;
        }
        
        int[][] dp = new int[n + 1][2];
        
        dp[1][0] = steps[1];
        dp[1][1] = steps[1];
        dp[2][0] = steps[1] + steps[2];
        dp[2][1] = steps[2];
        
        for (int k = 3; k <= n; k++) {
            dp[k][0] = dp[k-1][1] + steps[k];
            dp[k][1] = Math.max(dp[k-2][0], dp[k-2][1]) + steps[k];
        }
        
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}