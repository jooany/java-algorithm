import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        
        /*
        1 < 1 2 1 > 5 (5 - 1 이 4)
        1 < 1 2 3 2 1 > 10
        
        내부 합이 n * n
        개수는 2 * n - 3 + 2(앞뒤) 니깐 2 * n - 1 이 답
        */
        
        StringTokenizer st;
        int start, end;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            
            System.out.println(getResult(end - start));
        }
    }
    
    private static int getResult(int distance) {
        int n = (int) Math.sqrt(distance);
        
        if (n * n == distance) {
            return 2 * n - 1;
        } else if (n * n + n >= distance) {
            return 2 * n;
        } else {
            return 2 * n + 1;
        }
    }
}