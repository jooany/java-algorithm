import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(); // 스택처럼 사용
        int remain = k;

        for (char c : number.toCharArray()) {
            while (remain > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                remain--;
            }
            sb.append(c);
        }

        // 제거가 남아있으면 뒤에서부터 제거
        if (remain > 0) {
            sb.setLength(sb.length() - remain);
        }

        return sb.toString();
    }
}