import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }
        int i = 1;
        int j = 2;
        int count = 1;
        int sum = arr[i];
        while (i < N){
            sum += arr[j];
            if(sum<N){
                j++;
                continue;
            }else if (sum > N){
                i++;
                j = i+1;
                sum = arr[i];
                continue;
            }else{
                count++;
                i++;
                j = i+1;
                sum = arr[i];
                continue;
            }
        }
        System.out.println(count);
    }
}