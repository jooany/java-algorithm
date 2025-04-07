import java.util.*;

class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] command : commands) {
            
            for (int i = command[0] - 1; i < command[1]; i++) {
                pq.offer(array[i]);
            }
            
            for (int j = 1; j < command[2]; j++) {
                pq.poll();
            }
            
            answer.add(pq.poll());
            
            pq.clear();
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}