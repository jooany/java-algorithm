import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            dfs(i, computers, visited);
        }
        
        return answer;
    }
    
    private void dfs(int curr, int[][] computers, boolean[] visited) {
        if (!visited[curr]) answer++;
        
        visited[curr] = true;
        
        for (int next = 0; next < computers.length; next++) {
            if (next == curr || computers[curr][next] != 1 || visited[next]) continue;
            
            visited[next] = true;

            dfs(next, computers, visited);
        }
    }
}