import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int length = s.length();
        
        for (int i = 1; i <= length; i++) { // N개 단위
            int totalLength = 0;
            int mainStringCnt = 1;
            String mainString = "";
            
            for (int j = 0; j < length; j += i) { // N단위 인덱스 순회
                int end = j + i > length ? length : j + i;
                String curr = s.substring(j, end);
                
                if (mainString.equals(curr)) {
                    mainStringCnt++;
                } else {
                    totalLength += mainString.length();
                    
                    if (mainStringCnt > 1) {
                        totalLength += String.valueOf(mainStringCnt).length();
                    }
                    
                    mainStringCnt = 1;
                    mainString = curr;
                }
            }
            
            totalLength += mainString.length();
                    
            if (mainStringCnt > 1) {
                totalLength += String.valueOf(mainStringCnt).length();
            }
            
            answer = Math.min(answer, totalLength);
        }
        
        
        return answer;
    }
}