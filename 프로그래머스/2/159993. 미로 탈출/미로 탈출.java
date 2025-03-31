import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        
        boolean[][] visited = new boolean[n][m];
        Deque<Node> queue = new ArrayDeque<>();
        
        // 시작 노드 찾기
        Node start = null;
        
        for (int i = 0; i < n; i++) {
            if (maps[i].contains("S")) {
                start = new Node(i, maps[i].indexOf('S'), 0, 'S');
                break;
            }
        }
        
        queue.offer(start);
        visited[start.x][start.y] = true;
                
        // 시작 -> 레버까지의 최단경로 찾기
        Node lever = null;
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            
            if (curr.display == 'L') {
                lever = curr;
                queue.clear();
                break;
            }
            
            for (int i = 0; i < dx.length; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                // 방문했거나 범위 밖이거나 벽인 경우 탐색하지 않는다.
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || maps[nx].charAt(ny) == 'X') {
                    continue;
                }
                
                queue.offer(new Node(nx, ny, curr.dist + 1, maps[nx].charAt(ny)));
                visited[nx][ny] = true;
            }
        }
        
        if (lever == null) {
            return -1;
        }
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        
        queue.offer(new Node(lever.x, lever.y, lever.dist, lever.display));
        visited[lever.x][lever.y] = true;
        
        Node exit = null;
        // 레버 -> 출구까지의 최단경로 찾기
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            
            if (curr.display == 'E') {
                exit = curr;
                queue.clear();
                break;
            }
            
            for (int i = 0; i < dx.length; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                
                // 방문했거나 범위 밖이거나 벽인 경우 탐색하지 않는다.
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || maps[nx].charAt(ny) == 'X') {
                    continue;
                }
                
                queue.offer(new Node(nx, ny, curr.dist + 1, maps[nx].charAt(ny)));
                visited[nx][ny] = true;
            }
        }
        
        return exit == null ? -1 : exit.dist;
    }
    
    private static class Node {
        int x, y, dist;
        char display;
        
        Node (int x, int y, int dist, char display) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.display = display;
        }
    }
}