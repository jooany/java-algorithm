import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        HashSet<String> wordSet = new HashSet<>();
        for (String w : words) {
            wordSet.add(w);
        }
        
        if (!wordSet.contains(target)) {
            return 0;
        }
        
        HashSet<String> visited = new HashSet<>();
        visited.add(begin);
        
        Deque<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word curr = q.poll();
            
            if (target.equals(curr.word)) {
                return curr.cnt;
            }
            
            for (String word : wordSet) {
                if (visited.contains(word)) continue;
                
                int diff = 0;
                
                for (int i = 0; i < begin.length(); i++) {
                    if (word.charAt(i) != curr.word.charAt(i)) diff++;
                }
                
                if (diff != 1) continue;
                
                visited.add(word);
                q.offer(new Word(word, curr.cnt + 1));
                
            }
        }
        
        
        return 0;
    }
    
    private static class Word {
        String word;
        int cnt;
        
        Word(String word, int cnt) {
            this.word = word; 
            this.cnt = cnt;
        }
    }
}