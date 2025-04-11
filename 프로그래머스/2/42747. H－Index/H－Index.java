import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        
        for (int h = n; h >= 0; h--) {
            int cnt = 0;
            
            for (int j = n - 1; j >= 0; j--) {
                if (citations[j] < h) {
                    break;
                }
                
                cnt++;
                
                if (cnt == h) {
                    return h;
                }
            }
        }
        
        return 0;
    }
}