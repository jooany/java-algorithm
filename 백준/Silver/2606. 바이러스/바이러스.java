import java.util.*;
import java.io.*;

public class Main{
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int pairCnt = Integer.parseInt(br.readLine());
        
        ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            list[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        int com1, com2;
        for (int i = 0; i < pairCnt; i++) {
            st = new StringTokenizer(br.readLine());
            com1 = Integer.parseInt(st.nextToken());
            com2 = Integer.parseInt(st.nextToken());
            
            list[com1].add(com2);
            list[com2].add(com1);
        }
        
        boolean[] visited = new boolean[cnt + 1];
        
        dfs(1, list, visited);
        
        System.out.print(result - 1);
    }
    
    private static void dfs(int number, ArrayList<Integer>[] list, boolean[] visited) {
        if (visited[number]) return;
        
        visited[number] = true;
        result++;
        
        ArrayList<Integer> linkedComputers = list[number];
        for (int com : linkedComputers) {
            dfs(com, list, visited);
        }
    }
}