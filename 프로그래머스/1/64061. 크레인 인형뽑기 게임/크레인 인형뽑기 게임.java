import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        Deque<Integer> resultStack = new ArrayDeque<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = board.length - 1; j >= 0 && board[j][i] > 0; j--) {
                Deque<Integer> stack = map.computeIfAbsent(i + 1, k -> new ArrayDeque<>());
                stack.push(board[j][i]);
            }
        }
        
        for (int m = 0; m < moves.length; m++) {
            if (map.containsKey(moves[m]) && !map.get(moves[m]).isEmpty()) {
                int doll = map.get(moves[m]).pop();
                
                if (!resultStack.isEmpty() && resultStack.peek() == doll) {
                    resultStack.pop();
                    answer += 2;
                } else {
                    resultStack.push(doll);
                }
            }
        }
        
        return answer;
    }
}