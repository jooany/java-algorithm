import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 접두사가 포함된다면 문자열을 사전순 정렬했을 때, 양 옆으로 정렬될 수 밖에 없다.
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            
            String curr = phone_book[i];
            String next = phone_book[i + 1];
            
            if (curr.length() < next.length() 
                && curr.equals(next.substring(0, curr.length()))
               ) {
                return false;
            }
        }
        
        return true;
    }
}