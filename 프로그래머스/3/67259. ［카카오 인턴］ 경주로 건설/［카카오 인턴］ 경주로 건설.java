import java.util.*;

class Solution {
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dist = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    
        for (int i = 0; i < 4; i++) {
            dist[0][0][i] = 0;
        }
        
        queue.offer(new Node(0, 0, 0, -1));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            
            if (curr.x == n - 1 && curr.y == n - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
                    continue;
                }

                // 첫 이동이거나, 같은 방향으로 이동하는 경우 직선 도로 비용
                int adjacentCost = (curr.dir == -1 || i == curr.dir) ? 100 : 600;

                if (dist[nx][ny][i] > curr.cost + adjacentCost) {
                    dist[nx][ny][i] = curr.cost + adjacentCost;
                    queue.offer(new Node(nx, ny, dist[nx][ny][i], i));
                }
            }
        }

        return Arrays.stream(dist[n-1][n-1]).min().getAsInt();
    }


    private static class Node {
        int x, y, cost, dir;

        Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
}
