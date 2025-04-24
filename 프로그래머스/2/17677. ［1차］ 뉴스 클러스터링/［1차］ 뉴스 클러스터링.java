import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            if (!isAlphabet(str1.charAt(i)) || !isAlphabet(str1.charAt(i + 1))) continue;
            
            s1.add(str1.substring(i, i + 2).toUpperCase());
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            if (!isAlphabet(str2.charAt(i)) || !isAlphabet(str2.charAt(i + 1))) continue;
                                                   
            s2.add(str2.substring(i, i + 2).toUpperCase());
        }
        
        Collections.sort(s1);
        Collections.sort(s2);
        
        
        int i = 0;
        int j = 0;
        int len1 = s1.size();
        int len2 = s2.size();
        int eqCnt = 0;
        
        while (i < len1 && j < len2) {
            String ss1 = s1.get(i);
            String ss2 = s2.get(j);

            if (ss1.equals(ss2)) {
                eqCnt++;
                i++;
                j++;
            } else if (ss1.compareTo(ss2) < 0) {
                i++;
            } else {
                j++;
            }
        }
        
        if (eqCnt == 0 && len1 == 0 && len2 == 0) {
            return 65536;
        }
        
        double a = (double) eqCnt / (len1 + len2 - eqCnt);
        
        return (int) (65536 * a);
    }
    
    private boolean isAlphabet(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }
}