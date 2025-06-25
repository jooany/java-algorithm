import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> queue = new ArrayDeque<>(); // {x, y, 거리}
        
        
        // 가정 ) 가장 짧은 거리는 가장 가까운 위치로 이동하여 도착하는 거리가 가장 짧을 것이다.
        // 1. 처음 위치를 큐에 넣고 방문처리한다.
        // 2.1 큐에서 위치 정보를 하나 뽑고 한 칸 이동할 수 있는 위치를 큐에 넣고 방문처리한다. 해당 위치에 거리도 저장한다.
        //     ^ 이미 방문했거나 범위를 벗어나면 큐에 넣지 않는다.
        // 3. n - 1, m - 1 에 도달하면 반환
        
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                // 벽 체크
                if (maps[nx][ny] == 0) {
                    continue;
                }
                
                // 방문 체크
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (nx == n - 1 && ny == m - 1) {
                    return curr[2] + 1;
                }
                
                queue.offer(new int[]{nx, ny, curr[2] + 1});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}