import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        if (!hasTarget(words, target)) {
            return 0;
        }
        
        int answer = Integer.MAX_VALUE;
        boolean[] visited = new boolean[words.length];
        ArrayDeque<Word> deque = new ArrayDeque<>();
        deque.offer(new Word(begin, 0));
        
        while(!deque.isEmpty()) {
            Word word = deque.poll();
            
            if (target.equals(word.curr)) {
                return word.cnt;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i] || !isOneAlphabetChange(word.curr, words[i])) continue;
                
                deque.offer(new Word(words[i], word.cnt + 1));
                visited[i] = true;
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
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
    
    static class Word {
        String curr;
        int cnt;
        
        Word(String curr, int cnt) {
            this.curr = curr;
            this.cnt = cnt;
        }
    }
}