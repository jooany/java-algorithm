import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        ArrayList<Character> skills = new ArrayList<>();
        for (char c : skill.toCharArray()) {
            skills.add(c);
        }
        
        int cnt = 0;
        for (String s : skill_trees) {
            
            char[] skill_tree = s.toCharArray();
            int index = 0;
            
            for (int i = 0; i < skill_tree.length; i++) {
                
                if (skills.contains(skill_tree[i])) {
                    if (skill_tree[i] != skills.get(index)) break;
                    
                    index++;
                }
                
                if (i == skill_tree.length - 1) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}