import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();

        recursive(sb, 0, n, m, visited);
    }
    
    public static void recursive(StringBuilder sb, int cnt, int n, int m, boolean[] visited) {
        
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            int length = sb.length();
            
            if (length == 0) {
                sb.append(i);
            } else {
               sb.append(" " + i);
            }
            
            if (cnt + 1 == m) {
                System.out.println(sb);
            } else {
                recursive(sb, cnt + 1, n, m, visited);
            }
            
            visited[i] = false;
            sb.setLength(length);
        }
        
    }
}