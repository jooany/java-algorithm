import java.util.*;

class Solution {
    
    static String[][] allTickets;
    static String[] answers;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        allTickets = tickets;
        answers = new String[tickets.length + 1];
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            } else {
                return a[0].compareTo(b[0]);
            }
        });
          
        dfs("ICN", new StringBuilder("ICN"), 0);
           
        return answers;
    }
    
    private boolean dfs(String curr, StringBuilder answer, int cnt) {
        if (cnt == visited.length) {
            
            answers = answer.toString()
                .split(" ");
            
            return true;
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (!curr.equals(allTickets[i][0]) || visited[i]) continue;
            
            int len = answer.length();
            visited[i] = true;
            
            if (dfs(allTickets[i][1], answer.append(" ").append(allTickets[i][1]), cnt + 1)) {
                return true;
            }
            
            visited[i] = false;
            answer.setLength(len);
        }
        
        return false;
    }
}