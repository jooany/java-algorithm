import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int b = (brown - 4) / 2;
        
        // yellow의 세로
        int yelloHeight = (int) ((b - Math.sqrt(Math.pow(b, 2) - 4 * yellow)) / 2);
        
        return new int[]{yellow / yelloHeight + 2, yelloHeight + 2};
    }
}