import java.util.*;

class Solution {
    private static int count = 0;
    private static int N;
    private static boolean[] col, diagonal1, diagonal2;
    
    public int solution(int n) {
        N = n;
        col = new boolean[n];
        diagonal1 = new boolean[n * 2];
        diagonal2 = new boolean[n * 2];
        
        solve(0);
        
        return count;
    }
    
    private static void solve(int row) {
        if (row == N) {
            count++;
            return;
        } 
        
        for (int j = 0; j < N; j++) {
            if (col[j] || diagonal1[row + j] || diagonal2[row - j + N]) {
                continue;
            }
            
            col[j] = diagonal1[row + j] = diagonal2[row - j + N] = true;
            solve(row + 1);
            col[j] = diagonal1[row + j] = diagonal2[row - j + N] = false;
        }
    }
    
}