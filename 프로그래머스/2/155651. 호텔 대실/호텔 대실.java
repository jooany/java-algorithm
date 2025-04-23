import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        BookTime[] times = new BookTime[book_time.length];
        
        for (int i = 0; i < times.length; i++) {
            times[i] = new BookTime(book_time[i][0], book_time[i][1]);
        }
        
        boolean[] visited = new boolean[times.length];
        int answer = 0;
        
        Arrays.sort(times, Comparator.comparing(t -> t.in));
        
        for (int j = 0; j < times.length; j++) {
            if (visited[j]) continue;
            
            answer++;
            
            int possibleCheckIn = times[j].out + 10;
            
            for (int k = j + 1; k < times.length; k++) {
                if (visited[k]) continue;
                
                if (possibleCheckIn <= times[k].in) {
                    visited[k] = true;
                    possibleCheckIn = times[k].out + 10;
                }
            }
        }
        
        return answer;
    }
    
    private static class BookTime {
        int in;
        int out;
        
        BookTime (String in, String out) {
            this.in = toMinutes(in);
            this.out = toMinutes(out);
        }
        
        private int toMinutes(String time) {
            String[] t = time.split(":");
            
            return 60 * Integer.parseInt(t[0]) + Integer.parseInt(t[1]);
        }
    }
}