import java.util.*;

class Solution {
    private static int[][] computer;
    private static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        computer = computers;
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int index) {
        visit[index] = true;
        
        for (int i = 0; i < computer[index].length; i++) {
            if (computer[index][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}