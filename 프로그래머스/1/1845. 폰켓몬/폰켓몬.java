import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> uniquePhoneKetMon = new HashSet<>();
        
        for (int num : nums) {
            uniquePhoneKetMon.add(num);
        }
        
        return Math.min(nums.length / 2, uniquePhoneKetMon.size());
    }
}