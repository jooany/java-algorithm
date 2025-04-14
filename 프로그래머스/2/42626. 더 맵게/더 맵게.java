import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        
        for (int sv : scoville) {
            pq.add(sv);
        }
        
        while(pq.size() >= 2) {
            if (pq.peek() >= K) {
                return cnt;
            }
            
            pq.add(pq.poll() + pq.poll() * 2);
            
            cnt++;
        }
        
        if (pq.peek() >= K) {
            return cnt;
        }

        return -1;
    }
}