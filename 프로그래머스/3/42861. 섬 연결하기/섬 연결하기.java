import java.util.*;

class Solution {
    private static int[] parents;
    
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        int answer = 0;
        for (int[] cost : costs) {
            int root1 = find(cost[0]);
            int root2 = find(cost[1]);
        
            if (root1 != root2) {
                parents[root2] = root1;
                answer += cost[2];
            }
        }
        
        return answer;
    }
    
    private static int find(int island) {
        if (parents[island] == island) {
            return island;
        }
        
        return find(parents[island]);
    }
}