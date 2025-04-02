class Solution {
    private static int max = 0;
    private static int[][] dungeonTiredAmount;
    private static boolean[] visited;
        
    public int solution(int k, int[][] dungeons) {
        dungeonTiredAmount = dungeons;
        visited = new boolean[dungeons.length];
        
        backTracking(k, 0);
        
        return max;
    }
    
    private static void backTracking(int tiredAmount, int dungeonCount) {
        max = Math.max(max, dungeonCount);
        
        for (int i = 0; i < dungeonTiredAmount.length; i++) {
            if (!visited[i] && dungeonTiredAmount[i][0] <= tiredAmount) {
                visited[i] = true;
                backTracking(tiredAmount - dungeonTiredAmount[i][1], dungeonCount + 1);
                visited[i] = false;
            }
        }
    }
}