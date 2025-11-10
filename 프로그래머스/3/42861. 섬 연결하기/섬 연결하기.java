import java.util.*;

class Solution {
    int[] parents;
    
    public int solution(int n, int[][] costs) {
        parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        int answer = 0;
        for (int[] edge : costs) {
            int root1 = find(edge[0]);
            int root2 = find(edge[1]);
            
            if (root1 != root2) {
                parents[root2] = root1;
                
                answer += edge[2];
            }
        }
        
        return answer;
    }
    
    private int find(int a) {
        if (parents[a] == a) return a;
        
        return find(parents[a]);
    }
}