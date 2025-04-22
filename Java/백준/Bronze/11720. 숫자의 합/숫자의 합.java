import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String stringNum = br.readLine();
        char[] numbers = stringNum.toCharArray();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += numbers[i] - '0';
        }
        bw.write(sum + "\n");
        bw.flush();
    }
}