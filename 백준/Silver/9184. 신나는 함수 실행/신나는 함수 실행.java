import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        int a,b,c;
        int[][][] dp = new int[21][21][21];
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            if (a == -1 && b == -1 && c == -1) break;
            
            int result = w(a, b, c, dp);
            System.out.println(String.format("w(%d, %d, %d) = %d", a, b, c, result));
        }
    }
    
    public static int w(int a, int b, int c, int[][][] dp) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20, dp);
        }
        
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        
        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c-1, dp) + w(a, b-1, c-1, dp) - w(a, b-1, c, dp);
        } else {
            dp[a][b][c] = w(a-1, b, c, dp) + w(a-1, b-1, c, dp) + w(a-1, b, c-1, dp) - w(a-1, b-1, c-1, dp);
        }
        
        return dp[a][b][c];
    }
}