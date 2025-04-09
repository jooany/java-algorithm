import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> list = new ArrayList<>();
        
        // 2/2,1/2,1,3 or 2,1,3
        String s1 = s.replace("},", "/").replace("{", "").replace("}", "");
        
        String[] bundles = s1.split("/");
        
        for (String b : bundles) {
            String[] numbers = b.split(",");
            
            list.add(
                Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );
        }
        
        list.sort((o1, o2) -> o1.size() - o2.size());
        
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        
        for (List<Integer> l : list) {
            for(Integer num : l) {
                if (!set.contains(num)) {
                    set.add(num);
                }
            }
        }
        
        // LinkedHashSet -> int[]
        return set.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}