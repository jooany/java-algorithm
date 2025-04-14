import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        
        for (int sv : scoville) {
            pq.add(sv);
        }
        
        while(pq.size() >= 2 && pq.peek() < K) {
            pq.add(pq.poll() + pq.poll() * 2);
            
            cnt++;
        }

        return pq.peek() >= K ? cnt : -1;
    }
}