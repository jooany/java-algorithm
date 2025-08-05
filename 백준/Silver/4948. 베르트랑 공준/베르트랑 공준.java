import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            int n = Integer.parseInt(br.readLine());
            
            if (n == 0) break;

            if (n == 1 || n == 2) {
                System.out.println(1);
                continue;
            }
            
            int cnt = 0;
            int end = 2 * n;
            int start = (n + 1) % 2 == 0 ? n + 2 : n + 1;
            
            for (int i = start; i < end; i += 2) {
                if (isPrime(i)) cnt++;
            }
            
            System.out.println(cnt);
        }
    }
    
    private static boolean isPrime(int number) {
        if (number == 2) return true;
        if (number < 2 || number % 2 == 0) return false;
        
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        
        return true;
    }
}