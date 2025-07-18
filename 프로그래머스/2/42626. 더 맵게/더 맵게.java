import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scov : scoville) {
            pq.offer(scov);
        }
        
        if (pq.peek() >= K) {
            return 0;
        }
        
        while (pq.size() > 1 && pq.peek() < K) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            
            pq.offer(mix(min1 , min2));
            
            answer++;
        }
        
        return pq.peek() < K ? -1 : answer;
    }
    
    private int mix (int min1, int min2) {
        return min1 + min2 * 2;
    }
    
}