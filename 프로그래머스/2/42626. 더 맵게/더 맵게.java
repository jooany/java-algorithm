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
        
        // 만약 K보다 작아지지 않는다면, 무제한으로 돌게 된다.
        while (!pq.isEmpty() && pq.peek() < K && pq.size() > 1) {
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