import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int[] w = new int[N];
        for(int i = 0; i< N; i++){
            w[i] = arr[i]*(N-i);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            if(w[i] > max){
                max = w[i];
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}