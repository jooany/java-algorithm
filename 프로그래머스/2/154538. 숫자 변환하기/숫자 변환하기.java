import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // int[]{숫자, 횟수}
        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(new int[]{x, 0});
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int num = curr[0];
            int cnt = curr[1];
            
            if (num == y) return cnt;
            
            if (num * 3 <= y && !visited.contains(num * 3)) {
                queue.offer(new int[]{num * 3, cnt + 1});
                visited.add(num * 3);
            }
            
            if (num * 2 <= y && !visited.contains(num * 2)) {
                queue.offer(new int[]{num * 2, cnt + 1});
                visited.add(num * 2);
            }
            
            if (num + n <= y && !visited.contains(num + n)) {
                queue.offer(new int[]{num + n, cnt + 1});
                visited.add(num + n);
            }
        }
        
        return -1;
    }
}