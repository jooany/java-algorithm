import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        
        process(dp, x, 0);
        
        System.out.println(dp[1]);
    }
    
    public static void process(int[] dp, int n, int cnt) {
        if (dp[n] < cnt) return;
        
        dp[n] = cnt;
        
        if (n == 1) return;
        
        if (n % 3 == 0) {
            process(dp, n / 3, dp[n] + 1);
        }
        
        if (n % 2 == 0) {
            process(dp, n / 2, dp[n] + 1);
        }
        
        process(dp, n - 1, dp[n] + 1);
    }
}