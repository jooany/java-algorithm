import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length - 1; i++) {
            queue.offer(0);
        }
        queue.offer(truck_weights[0]);
        
        int totalWeight = truck_weights[0];
        int cnt = 1;
        int nextIndex = 1;
        
        while (!queue.isEmpty() && totalWeight != 0) {
            totalWeight -= queue.poll();
            
            if (nextIndex < truck_weights.length && totalWeight + truck_weights[nextIndex] <= weight) {
                totalWeight += truck_weights[nextIndex];
                queue.offer(truck_weights[nextIndex]);
                nextIndex++;
            } else {
                queue.offer(0);
            }
            
            cnt++;
        }
        
        return cnt;
    }
}