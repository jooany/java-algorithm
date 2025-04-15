import java.util.*;

class Solution {
    // 상, 우, 좌, 하
    private static int[] dx = new int[] {0, 1, -1, 0};
    private static int[] dy = new int[] {1, 0, 0, -1};
    private static int min = Integer.MAX_VALUE;
    private static char[][] gameBoard;
    private static boolean[][] visited;
    
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        gameBoard = new char[n][m];
        visited = new boolean[n][m];
        int startX = 0;
        int startY = 0;
        
        for (int i = 0; i < n; i++) {
            gameBoard[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (gameBoard[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(startX, startY, 0));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            if (gameBoard[curr.x][curr.y] == 'G') {
                min = Math.min(min, curr.moves);
                break;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = curr.x;
                int ny = curr.y;
                
                while (true) {
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];
                    
                    if (tx < 0 || ty < 0 || tx >= gameBoard.length || ty >= gameBoard[0].length) break;
                    if (gameBoard[tx][ty] == 'D') break;

                    nx = tx;
                    ny = ty;
                }
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, curr.moves + 1));
                }
            }
        }
        
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    
    private static class Node {
        int x, y, moves;
        
        Node (int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }
}