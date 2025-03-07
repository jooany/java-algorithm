import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        //TODO: 과일 key, 수량 value
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        //TODO: 시작일 최대 (100000 - 10 + 1) * 할인 과일 체크 (10)
        Map<String, Integer> tempMap = new HashMap<>();
        
        for (int i = 0; i < discount.length - 9; i++) {
            for (int j = i; j < i + 10; j++) {
                tempMap.put(discount[j], tempMap.getOrDefault(discount[j], 0) + 1);
            }
            
            if (map.equals(tempMap)) {
                answer++;
            }
            
            tempMap.clear();
        }
        
        return answer;
    }
}