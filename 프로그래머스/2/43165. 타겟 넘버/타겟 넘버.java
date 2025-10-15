class Solution {
    static int[] nums;
    static int targetNum;
    int answer = 0;
    
    // DFS 풀이
    public int solution(int[] numbers, int target) {
        nums = numbers;
        targetNum = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    private void dfs(int i, int result) {
        if (i == nums.length) {
            if (result == targetNum) answer++;
            
            return;
        }
        
        dfs(i + 1, result + nums[i]);
        dfs(i + 1, result - nums[i]);
    }
    
}