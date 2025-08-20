import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

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
        
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            
            result[cnt + 1] = i;
            recursive(cnt + 1, result);
            
            visited[i] = false;
        }
    }
}