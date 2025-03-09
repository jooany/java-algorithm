import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList();
        
        // <장르, {{고유번호, 재생횟수}, ... }>
        Map<String, List<int[]>> mapByGenre = new HashMap<>();
        Map<String, Integer> totalPlayByGenre = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!mapByGenre.containsKey(genres[i])) {
                mapByGenre.put(genres[i], new ArrayList());
                totalPlayByGenre.put(genres[i], 0);
            }
            
            mapByGenre.get(genres[i])
                    .add(new int[]{i, plays[i]});
                
            totalPlayByGenre.put(genres[i], totalPlayByGenre.get(genres[i]) + plays[i]);
        }
        
        totalPlayByGenre.entrySet()
            .stream()
            .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
            .forEach( entry -> {
                List<int[]> list = mapByGenre.get(entry.getKey())
                    .stream()
                    .sorted((o1, o2) -> 
                            Integer.compare(o1[1], o2[1]) == 0 
                            ? Integer.compare(o1[1], o2[1]) 
                            : Integer.compare(o2[1], o1[1]))
                    .collect(Collectors.toList());
                
                for (int i = 0 ; i < list.size() && i < 2; i++) {
                    result.add(list.get(i)[0]);
                }
            });
        
        return result.stream()
                   .mapToInt(Integer::intValue)
                   .toArray();
    }
}