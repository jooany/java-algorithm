import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        if (!hasTarget(words, target)) {
            return 0;
        }
        
        dfs(begin, 0, visited, begin, target, words);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private void dfs(String curr, int cnt, boolean[] visited, String begin, String target, String[] words) {
        // 탐색 조건 1: 바꾼 횟수 < 바꿀 수 있는 단어 개수
        if (cnt > words.length) return;
        
        if (curr.equals(target)) {
            answer = Math.min(answer, cnt);
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i] || !isOneAlphabetChange(curr, words[i])) continue;
            
            visited[i] = true;
            
            dfs (words[i], cnt + 1, visited, begin, target, words);
            
            visited[i] = false;
        }
        
        
    }
    
    private boolean hasTarget(String[] words, String target) {
        for (String word : words) {
            if (target.equals(word)) return true;
        }
        
        return false;
    } 
    
    private boolean isOneAlphabetChange(String curr, String toChange) {
        int diff = 0;
        
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != toChange.charAt(i)) {
                diff++;
            }
        }
        
        if (diff != 1) {
            return false;
        }
        
        return true;
    }
}