import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int size = progresses.length;
        
        for (int i = 0; i < size; i++) {
            int days = (int) Math.ceil(((double) 100 - progresses[i]) / speeds[i]);
            
            if (!queue.isEmpty() && queue.peek() < days) {
                result.add(queue.size());
                queue.clear();
            }
            
            queue.offer(days);
        }
        
        if (!queue.isEmpty()) {
            result.add(queue.size());
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}