import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[][] rgb = new int[cnt + 1][3];
        int[][] dp = new int[cnt + 1][3];
        StringTokenizer st;
        
        for (int i = 1; i <= cnt; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 첫 번째 집 초기화
        dp[1][0] = rgb[1][0];
        dp[1][1] = rgb[1][1];
        dp[1][2] = rgb[1][2];
        
        for (int i = 2; i <= cnt; i++) {
            dp[i][0] = rgb[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = rgb[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = rgb[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        
        int result = Math.min(Math.min(dp[cnt][0], dp[cnt][1]), dp[cnt][2]);
        System.out.println(result);
    }
}