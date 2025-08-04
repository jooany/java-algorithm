import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine());
        int[] distances = new int[cityCount - 1];
        int[] oilPrices = new int[cityCount];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < oilPrices.length; i++) {
            oilPrices[i] = Integer.parseInt(st.nextToken());
        }
        
        // 현재 도로 이전의 도시들에서 가장 기름값이 낮은 곳에서 충전하기
        // 기름값 최소 도시만큼 곱해서 더한다.
        int result = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < distances.length; i++) {
            min = Math.min(min, oilPrices[i]);
            
            result += distances[i] * min;
        }
        
        System.out.println(result);
    }
}