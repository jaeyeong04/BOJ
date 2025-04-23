import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        sort(arr,0,N);
        int i = 0;
        int j = N-1;
        int count = 0;
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == M){
                count++;
                i++;
                j--;
            }else if(sum < M){
                i++;
            }else if (sum > M){
                j--;
            }
        }
        System.out.println(count);
    }
}