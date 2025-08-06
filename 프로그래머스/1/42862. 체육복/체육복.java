import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] clothes = new int[n + 1];
        Arrays.fill(clothes, 1);
        
        for (int l : lost) {
            clothes[l]--;
        }
        
        for (int r : reserve) {
            clothes[r]++;
        }
        
        for (int i = 1; i <= n; i++) {
            
            if (clothes[i] > 0) {
                
                answer++;
                
            } else if (clothes[i] == 0) {

                if (i > 1 && clothes[i - 1] == 2) {
                    answer++;
                } else if (i + 1 <= n && clothes[i + 1] == 2) {
                    answer++;
                    clothes[i + 1]--;
                }
                
            }
        }
        
        return answer;
    }
}