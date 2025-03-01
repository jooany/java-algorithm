import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] challengers = new int[N+2];
        
        for (int i = 0; i < stages.length; i++) {
            challengers[stages[i]] += 1;
        }
                
                
        HashMap<Integer, Float> resultMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            resultMap.put(i,0f);
        }
                
        // resultMap 스테이지에 해당하는 실패율을 구하여 저장한다.
        int total = stages.length;
        
        for (int k = 1; k <= N; k++) {
            if (total == 0) {
                continue;
            } else {
                resultMap.put(k, (float) challengers[k] / total);
                total -= challengers[k];
            }
        }
                
        // map의 실패율 값을 내림차순으로 정렬하고, 같은 값인 경우엔 스테이지 번호 오름차순으로 정렬한다.
        return resultMap.entrySet()
            .stream()
            .sorted(
                Comparator.comparing(Map.Entry<Integer, Float>::getValue).reversed()
                          .thenComparing(Map.Entry::getKey)
             )
            .map(Map.Entry::getKey)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}