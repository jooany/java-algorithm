import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        
        int n = 0;
        int sum = 0;
        for (int i = 0; i < K; i++) {
            n = Integer.parseInt(br.readLine());
            
            if (n == 0) {
                sum -= stack.pop();
                continue;
            }
            
            stack.push(n);
            sum += n;
        }
        
        System.out.print(sum);
    }
}