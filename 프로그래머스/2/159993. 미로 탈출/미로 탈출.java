import java.util.*;

class Solution {
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    int m;
    int n;
    
    public int solution(String[] maps) {
        int answer = 0;
        m = maps.length;
        n = maps[0].length();
        int[][] dist = new int[m][n];
        initDist(dist);
        
        
        int[] start = findIndex(maps, 'S');
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        dist[start[0]][start[1]] = 0;
        
            
        // 시작 지점 -> 레버 까지의 최단 길이
        int startToLever = bfs(maps, dist, queue, 'L');
        if (startToLever == 0) return -1;
        answer += startToLever;
        
        // 거리 배열 -1로 초기화
        int[] lever = findIndex(maps, 'L');
        initDist(dist);
        dist[lever[0]][lever[1]] = 0;
        
        queue.clear();
        queue.offer(lever);
            
        // 레버 -> 출구 까지의 최단 길이
        int leverToExit = bfs(maps, dist, queue, 'E');
        if (leverToExit == 0) return -1;
        answer += leverToExit;
        
        return answer;
    }
    
    private int[] findIndex(String[] maps, char target) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i].charAt(j) == target) {
                    return new int[]{i, j};
                }
            }
        }
        
        return new int[]{};
    }
    
    private int bfs(String[] maps, int[][] dist, Deque<int[]> queue, char target) {
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || maps[nx].charAt(ny) == 'X' || dist[nx][ny] >= 0) {
                    continue;
                }
                
                if (maps[nx].charAt(ny) == target) {
                    return dist[currX][currY] + 1;
                }
                
                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[currX][currY] + 1;
            }
        }
        
        return 0;
    }
    
    private void initDist(int[][] dist) {
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
        }
    }
}