import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        // left, up, right, down
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        
        HashMap<String, Integer> dir = new HashMap<>();
        dir.put("left", 0);
        dir.put("up", 1);
        dir.put("right", 2);
        dir.put("down", 3);
        
        int[] answer = new int[]{0, 0};
        int widthMax = (board[0] - 1) / 2;
        int heightMax = (board[1] - 1) / 2;
        
        for (String input : keyinput) {
            int x = answer[0] + dx[dir.get(input)];
            int y = answer[1] + dy[dir.get(input)];
            
            if (Math.abs(x) > widthMax || Math.abs(y) > heightMax) {
                continue;
            }
            
            answer[0] = x;
            answer[1] = y;
        }
        
        return answer;
    }
}