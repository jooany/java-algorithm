import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String word;
        char before = '0';
        HashSet<Character> used = new HashSet<>();
        int noneGroup = 0;
        
        for (int i = 0; i < n; i++) {
            word = br.readLine();
            
            for (char alphabet : word.toCharArray()) {
                if (before == alphabet) continue;
                
                if (used.contains(alphabet)) {
                    noneGroup++;
                    break;
                }
                
                before = alphabet;
                used.add(alphabet);
            }
            
            before = '0';
            used.clear();
        }
        
        System.out.println(n - noneGroup);
    }
}