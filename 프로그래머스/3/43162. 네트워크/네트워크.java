import java.util.*;

class Solution {
    int cpuCnt;
    boolean[] visited;
    int[][] cpus;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        cpuCnt = n;
        cpus = computers;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int index) {
        visited[index] = true;
        
        for (int i = 0; i < cpuCnt; i++) {
            if (!visited[i] && cpus[index][i] == 1) {
                dfs(i);
            }
        }
    }
}