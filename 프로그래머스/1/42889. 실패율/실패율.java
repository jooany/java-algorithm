import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> stageMap = new HashMap<>();
        for (int i = 1; i <= N + 1; i++) {
            stageMap.put(i,0);
        }
        
        // stageMap 스테이지는 키로, 해당 스테이지에 도달한 플레이어 카운트를 값으로 저장한다.
        for (int j = 0; j < stages.length; j++) {
            stageMap.put(stages[j], stageMap.get(stages[j]) + 1);
        }
                
        HashMap<Integer, Float> resultMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            resultMap.put(i,0f);
        }
        
        // resultMap 스테이지에 해당하는 실패율을 구하여 저장한다.
        for (int k = 1; k <= N; k++) {
            
            int basePlayerCount = 0;
            
            for (int l = k; l <= N + 1; l++) {
                basePlayerCount += stageMap.get(l);
            }
            
            if (basePlayerCount == 0) {
                continue;
            }

            resultMap.put(k, (float) stageMap.get(k) / basePlayerCount);
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