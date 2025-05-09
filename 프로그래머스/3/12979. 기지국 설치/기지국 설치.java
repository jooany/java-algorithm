class Solution {
    private int answer;
    private int wLength;
    
    public int solution(int n, int[] stations, int w) {
        wLength = 2 * w + 1;
        int start = 1;
        
        for (int s : stations) {
            if (start > n) break;
            
            if (start >= s - w) {
                start = s + w + 1;
                continue;
            }
            
            answer += getStationCount(s - w - start);
            start = s + w + 1;
        }
        
        if (start <= n) {
            answer += getStationCount(n - start + 1);
        }

        return answer;
    }
    
    private int getStationCount(int apartment) {
        int answer = 0;
            
        if (apartment < wLength) {
            answer++;
        } else {
            answer += apartment / wLength;

            if (apartment % wLength != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}