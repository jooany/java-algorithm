import java.util.*;

class Solution {
    static int[][] dungeonInfo;
    static boolean[] visited;
    static int result = 0;
    
    public int solution(int k, int[][] dungeons) {
        dungeonInfo = dungeons;
        visited = new boolean[dungeons.length];
        
        /*
        최소 필요 피로도 내림차순, 소모 피로도 기준 오름차순 정렬
        */
        Arrays.sort(dungeonInfo, (a, b) -> {
           if (a[0] == b[0]) {
               return a[1] - b[1];
           } else {
               return b[0] - a[0];
           }
        });
        
        dfs(k, 0);
        
        return result;
    }
    
    private void dfs(int currK, int visitedCnt) {
        if (result < visitedCnt) {
            result = visitedCnt;
        }
        
        for (int i = 0; i < dungeonInfo.length; i++) {
            if (visited[i] || currK < dungeonInfo[i][0]) continue;
            
            visited[i] = true;
            
            dfs(currK - dungeonInfo[i][1], visitedCnt + 1);
            
            visited[i] = false;
        }
    }
}