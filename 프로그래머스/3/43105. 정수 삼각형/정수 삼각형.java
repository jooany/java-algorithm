import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] result = triangle;
        
        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j < triangle[i].length - 1; j++) {
                result[i-1][j] += Math.max(result[i][j], result[i][j+1]);
            }
        }
        
        return result[0][0];
    }
}