import java.util.*;

class Solution {
    private static int max = 0;
    private static int[] apeach;
    private static int[] answer = new int[11];
        
    public int[] solution(int n, int[] info) {
        apeach = info;
        
        backtrack(n, 0, new int[11]);
            
        return max == 0 ? new int[]{-1} : answer;
    }
    
    private static void backtrack(int n, int idx, int[] ryan) {
        /*
        n : 라이언의 남은 화살 개수
        idx : 포인트 점수에 따라 화살 개수를 저장할 인덱스
        ryan : 현재 까지의 라이언 배열
        */
        
        // 라이언의 화살 개수를 다 썼다면, 어피치 점수와 라이언 점수를 계산해서 라이언이 이긴 경우에만,
        // && 어피치와 라이언 점수 차이가 max 보다 큰 경우에만,
        // 라이언 배열을 answer 배열의 값으로 복사해서 저장한다.
        
        if (idx == 11) {
            if (n == 0) {
                int gap = getPointGap(ryan);

                if (gap <= 0) return;

                if (max < gap) {
                    max = gap;
                    answer = Arrays.copyOf(ryan, 11);
                }

                if (max == gap) {
                    for (int i = 10; i >= 0; i--) {  // 역순으로 비교하여 가장 작은 화살 수를 우선시
                        if (ryan[i] > answer[i]) {
                            answer = Arrays.copyOf(ryan, 11);
                            break;
                        } else if (ryan[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }
        } else { // 라이언 화살 개수 남았으면, 1부터 n발까지 해당 idx에 저장하고 그 다음 idx+1로 백트래킹
            for (int shot = 0; shot <= n; shot++) {
                ryan[idx] = shot;

                backtrack(n - shot, idx + 1, ryan);

                ryan[idx] = 0;
            }
        }
    }
    
    private static int getPointGap(int[] ryan) {
        int gap = 0;
        
        for (int i = 0; i <= 10; i++) {
            if (ryan[i] > apeach[i]) {
                gap += (10 - i);
            } else if (apeach[i] > 0){
                gap -= (10 - i);
            }
        }
        
        return gap;
    }
}