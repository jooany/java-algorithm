import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        // 인접 리스트 + 초기화 필수
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : costs) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            
            if (visited[node]) continue;
            visited[node] = true;
            answer += cost;
            
            for (int[] next : graph[node]) {
                if (visited[next[0]]) continue;
                
                pq.offer(next);
            }
        }
        
        return answer;
    }
}