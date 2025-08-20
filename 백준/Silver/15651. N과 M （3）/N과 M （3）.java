import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        recursive(0, new int[m + 1]);
        
        System.out.print(sb);
    }
    
    public static void recursive(int cnt, int[] result) {
        if (cnt == m) {
            for (int i = 1; i <= m; i++) {
                sb.append(result[i]).append(i == m ? "\n" : " ");
            }
            return;
        }
        
        for (int j = 1; j <= n; j++) {
            result[cnt + 1] = j;
            recursive(cnt + 1, result);
        }
    }
}