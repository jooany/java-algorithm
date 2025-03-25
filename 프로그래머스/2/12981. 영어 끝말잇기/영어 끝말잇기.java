import java.util.*;

class Solution {
    private static HashSet<String> wordSet = new HashSet<>();
    
    public int[] solution(int n, String[] words) {
        char firstSpell = words[0].charAt(0);
        int turn = 1;
        
        for (int i = 0 ; i < words.length; i++) {
            if (checkLose(firstSpell, words[i])) {
                return new int[]{i % n + 1, turn};
            }
            
            wordSet.add(words[i]);
            firstSpell = words[i].charAt(words[i].length() - 1);
            
            if ((i+1) % n == 0) {
                turn++;
            }
        }
        
        return new int[2];
    }
    
    private static boolean checkLose(char firstSpell, String word) {
        return word.charAt(0) != firstSpell || wordSet.contains(word);
    }
}