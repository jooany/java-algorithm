import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> reserves = new HashSet<>();
        LinkedHashSet<Integer> losts = new LinkedHashSet<>();
        
        for (int r : reserve) {
            reserves.add(r);
        }
        
        Arrays.sort(lost);
        
        for (int l : lost) {
            if (reserves.contains(l)) {
                reserves.remove(l);
                continue;
            }
            
            losts.add(l);
        }
        
        int lostTotal = 0;
        
        for (int cur : losts) {
            if (reserves.contains(cur - 1)) {
                reserves.remove(cur - 1);
            } else if (reserves.contains(cur + 1)) {
                reserves.remove(cur + 1);
            } else {
                lostTotal++;
            }
        }
        
        return n - lostTotal;
    }
}