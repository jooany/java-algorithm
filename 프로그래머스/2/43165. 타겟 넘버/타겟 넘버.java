class Solution {
    static int n;
    static int targetNum;
    static boolean[] visited;
    static int[] nums;
    int answer;
    
    public int solution(int[] numbers, int target) {
        /*
        타겟 넘버가 되는 모든 경우의 수 -> 완전 탐색
        */
        
        nums = numbers;
        n = numbers.length;
        targetNum = target;
        visited = new boolean[n];
        
        dfs(0, 0);
        
        return answer;
    }
    
    private void dfs(int index, int result) {
        if (index == n) {
            if (result == targetNum) answer++;
            return;
        }
        
        dfs(index + 1, result + nums[index]);
        dfs(index + 1, result - nums[index]);
    }
}