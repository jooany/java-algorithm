class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            // i 노드를 방문하지 않았다면, 네트워크 + 1 하고 방문 표시한다.
            // i 노드부터 computers & DFS를 활용하여 연결된 것을 모두 탐색하고 방문 표시한다. (양방향 주의)
            
            if (visited[i]) continue;

            answer++;
            dfs(i, visited, computers);
        }
        
        return answer;
    }
    
    public void dfs(int i, boolean[] visited, int[][] computers) {
        visited[i] = true;
        
        for (int j = 0; j < computers.length; j++) {
            if (!visited[j] && computers[i][j] == 1) {
                dfs(j, visited, computers);
            }
        }
    }
}