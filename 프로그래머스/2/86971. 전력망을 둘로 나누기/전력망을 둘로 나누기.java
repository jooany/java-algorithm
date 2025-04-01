import java.util.*;

class Solution {
    private static int N, answer;
    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    
    public int solution(int n, int[][] wires) {
        N = n;
        answer = n - 1;
        visited = new boolean[n + 1];
        
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }
        
        dfs(1);
        
        return answer;
    }
    
    private static int dfs(int vertex) {
        visited[vertex] = true;
        
        int sum = 0;
        
        for (int adj : adjList[vertex]) {
            
            if (!visited[adj]) {
                
                int cnt = dfs(adj);
                answer = Math.min(answer, Math.abs(N - 2 * cnt));
                sum += cnt;
            }
        }
        
        return sum + 1;
    }
}