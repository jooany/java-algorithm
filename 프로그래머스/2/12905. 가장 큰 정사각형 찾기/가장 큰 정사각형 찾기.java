class Solution {
    public int solution(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int max = board[0][0];
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 0) continue;
                
                board[i][j] = Math.min(
                    Math.min(board[i][j - 1], board[i - 1][j]),
                    board[i - 1][j - 1]
                ) + 1;
                
                max = Math.max(max,board[i][j]);
            }
        }
        
        return max * max;
    }
}