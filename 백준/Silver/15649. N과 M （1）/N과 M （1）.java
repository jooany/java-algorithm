import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[] visited = new boolean[N + 1];
     
        process(N, M, new StringBuilder(""), visited);
    }
    
    // N 만큼의 for 문으로 재귀 호출한다.
    public static void process(int N, int M, StringBuilder sb, boolean[] visited) {
        
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            
            int len = sb.length();
            if (len == 0) {
                sb.append(i);
            } else {
                sb.append(" " + i);
            }
            
            // 총 M개일 때 출력, 아니면 다음으로
            if (sb.length() == 2 * M - 1) {
                System.out.println(sb);
            } else {
                process(N, M, sb, visited);
            }
            
            visited[i] = false;
            
            sb.setLength(len);
        }
    }
    
}