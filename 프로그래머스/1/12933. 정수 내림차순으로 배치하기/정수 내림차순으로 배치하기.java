import java.util.*;

class Solution {
    public long solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        
        Arrays.sort(chars);
        
        char[] answerChars = new char[chars.length];
        
        for (int i = chars.length - 1; i >= 0; i--) {
            answerChars[i] = chars[chars.length - 1 - i];
        }
        
        return Long.valueOf(String.valueOf(answerChars));
    }
}