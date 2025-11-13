import java.util.*;

class Solution {
    final static int[] dx = {1, 0, -1, 0};
    final static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx][ny] == 0) continue;
                
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
        
    }
}