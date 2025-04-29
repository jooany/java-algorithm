import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        int maxPlayMinutes = 0;
        String name = "(None)";
        
        String convertedM = convertPlaySheet(m.replace("#", "").length(), m);
        
        for (String s : musicinfos) {
            String[] infos = s.split(",");
            
            int playMinutes = getPlayTime(infos[0], infos[1]);
            String playSheet = convertPlaySheet(playMinutes, infos[3]);
            
            if (playSheet.contains(convertedM) && maxPlayMinutes < playMinutes) {
                name = infos[2];
                maxPlayMinutes = playMinutes;
            }
        }
        
        return name;
    }
    
    private int getPlayTime(String start, String end) {
        return convertMinutes(end) - convertMinutes(start);
    }

    private int convertMinutes(String time) {
        String[] split = time.split(":");

        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private String convertPlaySheet(int playMinutes, String info) {
        ArrayList<String> infos = convertInfos(info);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < playMinutes; i++) {
            sb.append(infos.get(i % infos.size()));
        }

        return sb.toString();
    }

    private ArrayList<String> convertInfos(String info) {
        ArrayList<String> infos = new ArrayList<>();

        int index = 0;
        
        for (int i = 0; i < info.length(); i++) {
            if ('#' == info.charAt(i)) {
                index--;
                
                infos.set(index, "[" + infos.get(index) + "]");
            } else {
                infos.add(index, String.valueOf(info.charAt(i)));
            }
            
            index++;
        }

        return infos;
    }
}