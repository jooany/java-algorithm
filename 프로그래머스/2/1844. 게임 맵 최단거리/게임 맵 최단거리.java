import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        queue.offer(new Node(0, 0, 1));
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // 도착 지점이면 바로 반환 (조기 종료)
            if (curr.x == n - 1 && curr.y == m - 1) {
                return curr.dist;
            }
            
            for (int[] d : direction) {
                int nx = curr.x + d[0];
                int ny = curr.y + d[1];

                // 범위를 벗어나거나 벽(0)이면 스킵
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx][ny] == 0) {
                    continue;
                }
                
                // 현재 거리 + 1이 기존 거리보다 작으면 갱신하고 큐에 추가
                if (curr.dist + 1 < dist[nx][ny]) {
                    dist[nx][ny] = curr.dist + 1;
                    queue.offer(new Node(nx, ny, dist[nx][ny]));
                }
            }
        }
        
        return -1; // 도달할 수 없는 경우
    }
    
    private static class Node {
        int x, y, dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
