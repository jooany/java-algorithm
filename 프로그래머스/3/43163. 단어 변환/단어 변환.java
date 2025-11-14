import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        // 종료 : words에 target이 없으면 return 0
        
        // begin 알파벳과 한개의 알파벳만 다른 알파벳을 찾아서 큐에 넣는다.
        // 큐 추출, 한개의 알파벳만 다른 알파벳을 찾아서 큐에 넣는다.
        // O(N^2) = 3 * 50 * 50
        
        HashSet<String> wordSet = new HashSet<>();
        for (String w : words) {
            wordSet.add(w);
        }
        
        if (!wordSet.contains(target)) {
            return 0;
        }
        
        Deque<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word curr = q.poll();
            
            if (target.equals(curr.word)) {
                return curr.cnt;
            }
            
            for (String word : wordSet) {
                int diff = 0;
                
                for (int i = 0; i < begin.length(); i++) {
                    if (word.charAt(i) != curr.word.charAt(i)) diff++;
                }
                
                if (diff != 1) continue;
                
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