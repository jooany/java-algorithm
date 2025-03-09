import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // <신고한id, 이용자id Set>
        Map<String, Set<String>> reported = new HashMap<>();
        Map<String, Integer> mailCount = new HashMap<>();
        
        for(String r : report) {
            String[] split = r.split(" ");
            
            Set<String> reporters = reported.computeIfAbsent(split[1], a -> new HashSet<>());
            reporters.add(split[0]);
        }
        
        reported.entrySet()
            .stream()
            .forEach(entry -> {
                Set<String> reporters = entry.getValue();
                
                if (reporters.size() < k) {
                    return;
                }
                
                reporters
                    .stream()
                    .forEach(reporter -> mailCount.put(reporter, mailCount.getOrDefault(reporter, 0) + 1));
            });
        
        return Arrays.asList(id_list)
            .stream()
            .map(id -> mailCount.getOrDefault(id, 0))
            .mapToInt(Integer::intValue)
            .toArray();
    }
}