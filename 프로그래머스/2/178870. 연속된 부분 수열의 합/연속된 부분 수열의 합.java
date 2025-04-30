class Solution {
    public int[] solution(int[] sequence, int k) {
        int i = 0;
        int j = 0;
        int sum = sequence[i];
        
        int start = 0;
        int end = sequence.length;
        
        while(j < sequence.length) {
            if (sum == k && (end - start) > j - i) {
                start = i;
                end = j;
            } else if (sum < k) {
                j++;
                if (j < sequence.length) sum += sequence[j];
            } else {
                sum -= sequence[i];
                i++;
            }
        }
        
        return new int[]{start, end};
    }
}