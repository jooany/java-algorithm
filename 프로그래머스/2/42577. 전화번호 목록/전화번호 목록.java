import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            String a = phone_book[i];
            String b = phone_book[i + 1];
            
            if (b.length() < a.length()) {
                continue;
            }
            
            if (b.substring(0, a.length()).equals(a)) {
                return false;
            }
        }
        
        return true;
    }
}