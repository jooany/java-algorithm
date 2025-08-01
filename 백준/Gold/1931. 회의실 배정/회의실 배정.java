import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int meetingCnt = Integer.parseInt(br.readLine());
        
        // {{1,2}, {3,4}}
        ArrayList<int[]> times = new ArrayList<>(meetingCnt);

        for (int i = 0; i < meetingCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            times.add(new int[]{start, end});
        }
        
        times.sort((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            
            return a[1] - b[1];
        });
        
        int result = 0;
        int end = 0;
        
        for (int[] time : times) {
           if (end > time[0]) continue;
            
            end = time[1];
            result++;
        }
        
        System.out.println(result);
    }
}