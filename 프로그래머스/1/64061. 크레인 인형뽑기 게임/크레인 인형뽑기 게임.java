import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayList<ArrayDeque<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < board[0].length; i++) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] == 0) continue;
                
                stack.push(board[j][i]);
            }
            
            list.add(stack);
        }
        
        ArrayDeque<Integer> bucket = new ArrayDeque<>();
        
        for (int i = 0; i < moves.length; i++) {
            ArrayDeque<Integer> stack = list.get(moves[i] - 1);
            
            if (stack.isEmpty()) continue;
            
            int doll = stack.pop();
            
            if (!bucket.isEmpty() && bucket.peek() == doll) {
                answer += 2;
                bucket.pop();
                continue;
            } 
            
            bucket.push(doll);
        }
        
        
        return answer;
    }
}