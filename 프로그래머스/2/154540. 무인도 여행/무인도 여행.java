import java.util.*;

class Solution {
    private final static int[] dx = {0, 1, 0, -1};
    private final static int[] dy = {1, 0, -1, 0};
    private boolean[][] visited;
    private List<Integer> result;
    private int n;
    private int m;
    private String[] map;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        result = new ArrayList<>();
        map = maps;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    result.add(dfs(i, j));
                }
            }
        }
        
        return result.isEmpty() ? new int[]{-1} : result.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }
    
    private int dfs(int i, int j) {
        visited[i][j] = true;
        int sum = map[i].charAt(j) - '0';
        
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx].charAt(ny) != 'X') {
                sum += dfs(nx, ny);
            }
        }
        
        return sum;
    }
}