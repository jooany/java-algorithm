import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> queue = new ArrayDeque<>();
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (String originCity : cities) {
            String city = originCity.toUpperCase();
            
            if (!queue.contains(city)) {
                
                if (!queue.isEmpty() && queue.size() == cacheSize) {
                    queue.poll();
                }
                
                queue.offer(city);
                answer += 5;
                
            } else {
                queue.remove(city);
                queue.offer(city);
                answer += 1;
            }
        }
        
        return answer;
    }
}