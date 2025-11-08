import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 2];
        
        for (int l : lost) {
            clothes[l]--;
        }
        
        for (int r : reserve) {
            clothes[r]++;
        }
        
        int lostTotal = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] == -1) {
                if (clothes[i - 1] == 1) {
                    clothes[i - 1]--;
                } else if (clothes[i + 1] == 1) {
                    clothes[i + 1]--;
                } else {
                    lostTotal++;
                }
            }
        }
        
        return n - lostTotal;
    }
}