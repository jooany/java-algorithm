import java.util.*;
import java.util.stream.*;

class Solution {
    private static final Map<Integer, Map<String, Integer>> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for (int c : course) {
            map.put(c, new HashMap<>());
            
            for (String o : orders) {
                char[] menus = o.toCharArray();
                Arrays.sort(menus);
                combinations(0, menus, "", c);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        map.entrySet()
            .stream()
            .forEach(entry -> {
                Map<String, Integer> menuGroup = entry.getValue();
                
                final Integer max = menuGroup.entrySet()
                    .stream()
                    .map(Map.Entry::getValue)
                    .filter(v -> v > 1)
                    .max(Integer::compareTo)
                    .orElse(0);
                
                menuGroup.entrySet()
                    .stream()
                    .sorted((o1,o2) -> o2.getValue() - o1.getValue())
                    .forEach(eentry -> {
                        if (max == eentry.getValue()) {
                            result.add(eentry.getKey());
                        }
                    });
            });
            
        return result.stream()
            .sorted()
            .toArray(String[]::new);
    }
    
    private static void combinations(int idx, char[] menu, String result, int menuCount) {
        if (result.length() == menuCount) {
            Map<String, Integer> menuGroup = map.get(menuCount);
            
            menuGroup.put(result, menuGroup.getOrDefault(result, 0) + 1);
        }
        
        for (int i = idx ; i < menu.length; i++) {
            combinations(i + 1, menu, result + menu[i], menuCount);
        }
    }
}