import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            dfs(i, graph, visited);
        }
        
        return answer;
    }
    
    private void dfs(int curr, List<Integer>[] graph, boolean[] visited) {
        if (!visited[curr]) answer++;
        
        visited[curr] = true;
        
        for (Integer next : graph[curr]) {
            if (visited[next]) continue;
            
            visited[next] = true;

            dfs(next, graph, visited);
        }
    }
}