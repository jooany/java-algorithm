import java.util.*;

class Solution {
    String number;
    HashSet<Integer> set;
    boolean[] visited;
    
    public int solution(String numbers) {
        number = numbers;
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        
        dfs("");
        
        int answer = 0;
        
        for (int num : set) {
           if (isPrimeNumber(num)) answer++;
        }
        
        return answer;
    }
    
    private void dfs(String s) {
        if (!s.equals("") && s.charAt(0) == '0') return;
        
        if (!s.equals("")) {
            set.add(Integer.valueOf(s));
        }
        
        for (int i = 0; i < number.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(s + number.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrimeNumber(int num) {
        if (num < 2) return false;
        
        if (num > 2 && num % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false; 
        }
        
        return true;
    }
}