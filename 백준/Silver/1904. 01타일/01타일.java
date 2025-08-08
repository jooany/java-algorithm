import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N <= 2) {
            System.out.println(N);
            return;
        }
        
        long[] answers = new long[N + 1];
        answers[1] = 1L;
        answers[2] = 2L;
        
        for (int i = 3; i <= N; i++) {
            answers[i] = ( (long) answers[i - 1] + answers[i - 2]) % 15746;
        }
        
        System.out.println(answers[N] % 15746);
        
    }
}