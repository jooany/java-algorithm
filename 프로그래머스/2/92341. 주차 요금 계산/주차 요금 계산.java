import java.util.*;

class Solution {
    private static final String LAST_TIME = "23:59";
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, CarInfo> carInfos = new HashMap<>();
        
        for (String record : records) {
            String[] split = record.split(" ");
            
            if (split[2].equals("IN")) {
                if (!carInfos.containsKey(split[1])) {
                    carInfos.put(split[1], new CarInfo(split[1], split[0]));
                } else {
                    carInfos.get(split[1]).setLatestStartMinutes(split[0]);
                }
            }
            
            if (split[2].equals("OUT")) {
                carInfos.get(split[1]).calculateTotalMinutes(split[0]);
            }
        }
        

        carInfos.forEach((k, v) -> {
            v.calculateTotalMinutes(LAST_TIME);
            
            if (v.totalMinutes <= fees[0]) {
                v.fee = fees[1];
            } else {
                int excessMinutes = v.totalMinutes - fees[0];
                
                v.fee = fees[1] + (excessMinutes / fees[2]) * fees[3];
                
                if (excessMinutes % fees[2] != 0) {
                    v.fee += fees[3];
                }
            }
        });
        
        return carInfos.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .mapToInt(e -> e.getValue().getFee())
            .toArray();
        
    }
    
    private static class CarInfo {
        private String number;
        private Integer latestStartMinutes;
        private int totalMinutes;
        private int fee;
        
        public CarInfo(String number, String startTime) {
            this.number = number;
            setLatestStartMinutes(startTime);
        }
        
        public void setLatestStartMinutes(String startTime) {
            this.latestStartMinutes = toMinutesByTime(startTime);
        }
        
        public void calculateTotalMinutes(String endTime) {
            if (latestStartMinutes == null) return;
            
            this.totalMinutes += toMinutesByTime(endTime) - latestStartMinutes;
            
            latestStartMinutes = null;
        }
        
        public void setFee(int fee) {
            this.fee = fee;
        }
        
        public int getFee() {
            return this.fee;
        }

        private Integer toMinutesByTime(String time) {
            return Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3, 5));
        }
    }
}