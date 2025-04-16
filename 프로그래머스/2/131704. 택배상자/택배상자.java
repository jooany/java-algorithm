import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> mainContainer = new ArrayDeque<>(); 
        for (int n = 1; n <= order.length; n++) {
            mainContainer.offer(n);
        }
        
        Deque<Integer> subContainer = new ArrayDeque<>();
        int cnt = 0;
        
        for (int i = 0; i < order.length; i++) {
            if (mainContainer.isEmpty() && subContainer.isEmpty()) {
                break;
            }
            
            int target = order[i];
            
            if (mainContainer.isEmpty() || mainContainer.peek() > target) {
                if (target != subContainer.pop()) break;
                
                cnt++;
            } 
            
            while (!mainContainer.isEmpty() && mainContainer.peek() <= target) {
                if (target == mainContainer.peek()) {
                    mainContainer.poll();
                    cnt++;
                    break;
                }

                subContainer.push(mainContainer.poll());
            }
        }
        
        return cnt;
    }
}