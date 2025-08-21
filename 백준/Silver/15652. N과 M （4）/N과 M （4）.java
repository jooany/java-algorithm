import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] result = new int[m + 1];
        result[0] = 1;
        
        recursive(result, 0);
        
        System.out.print(sb);
    }
    
    public static void recursive(int[] result, int cnt) {
        if (cnt == m) {
            for (int i = 1; i <= m; i++) {
                sb.append(result[i]).append(i == m ? "\n" : " ");
            }
            return;
        }
        
        for (int j = result[cnt]; j <= n; j++) {
            result[cnt + 1] = j;
            recursive(result, cnt + 1);
        }
    }
}