import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        int totalWeight = 0;
        int time = 0;
        int idx = 0;
        
        while (true) {
            time++;
            
            if (queue.size() == bridge_length) {
                totalWeight -= queue.poll();
            }
            
            if (idx < truck_weights.length && totalWeight + truck_weights[idx] <= weight) {
                totalWeight += truck_weights[idx];
                queue.offer(truck_weights[idx]);
                idx++;
            } else {
                queue.offer(0);
            }
            
            if (queue.isEmpty() || totalWeight == 0) {
                break;
            }
        }
        
        return time;
    }
}