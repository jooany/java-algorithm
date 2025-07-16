import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int length = priorities.length;
        int answer = 0;
        
        // {인덱스, 중요도}
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        
        HashSet<Integer> indexes = new HashSet<>();
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            boolean hasGreater = false;
            for (int i = 0; i < length; i++) {
                if (indexes.contains(i)) continue;
                
                if (priorities[i] > curr[1]) {
                    hasGreater = true;
                    break;
                }
            }
            
            if (hasGreater) {
                queue.offer(curr);
            } else {
                answer++;
                
                indexes.add(curr[0]);
                
                if (curr[0] == location) {
                    return answer;
                }
            }
        }
        
        
        return answer;
    }
}