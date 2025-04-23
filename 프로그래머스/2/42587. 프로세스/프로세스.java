import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
        }
        
        // Entry<인덱스, 중요도>
        Deque<Map.Entry<Integer, Integer>> queue = map.entrySet()
            .stream()
            .collect(Collectors.toCollection(ArrayDeque<Map.Entry<Integer, Integer>>::new));
        
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> curr = queue.poll();
            
            boolean hasGreaterThanCurr = false;
            
            for (int i = 0; i < queue.size(); i++) {
                if (queue.peek().getValue() > curr.getValue()) {
                    hasGreaterThanCurr = true;
                }
                
                queue.offer(queue.poll());
            }
            
            if (hasGreaterThanCurr) {
                queue.offer(curr);
            } else {
                cnt++;
                
                if (curr.getKey() == location) {
                    return cnt;
                }
            }
        }
        
        return cnt;
    }
}