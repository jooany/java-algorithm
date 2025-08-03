import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        int result = 0;
        
        String[] splitByMinus = exp.split("\\-");
        String[] splitFirstByPlus = splitByMinus[0].split("\\+");

        for (String sByP : splitFirstByPlus) {
            result += Integer.parseInt(sByP);
        }
        
        for (int i = 1; i < splitByMinus.length; i++) {
            int sum = 0;
            String[] splitByPlus = splitByMinus[i].split("\\+");
            
            for (String sByP : splitByPlus) {
                sum += Integer.parseInt(sByP);
            }
            
            result -= sum;
        }
        
        System.out.println(result);
    }
}