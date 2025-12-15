import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N+1];
        d[0] = 0;
        d[1] = 0;
        for(int i = 2; i <= N; i++){
            d[i] = 1 + d[i-1];
            if(i%2 == 0){
                d[i] = Math.min(d[i], 1 + d[i/2]);
            }
            if(i%3 == 0){
                d[i] = Math.min(d[i], 1 + d[i/3]);
            }
        }
        bw.write(String.valueOf(d[N]));
        bw.flush();
    }
}