import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        for(int index = 0; index < N; index++){
            long sum = arr[index];
            int i = 0;
            int j = N-1;
            while(i < j){
                if(sum == arr[i] + arr[j]){
                    if(i != index && j != index){
                        count++;
                        break;
                    }else if(i==index){
                        i++;
                    }else if(j==index){
                        j--;
                    }
                }else if(arr[i] + arr[j] < sum){
                    i++;
                }else{
                    j--;
                }
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
    }
}