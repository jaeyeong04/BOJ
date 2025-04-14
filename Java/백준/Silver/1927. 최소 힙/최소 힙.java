import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(minHeap.isEmpty()){
                    bw.write(0 +"\n");
                }else{
                    bw.write(minHeap.remove() +"\n");
                }
            }else{
                minHeap.add(x);
            }
            bw.flush();
        }
        
    }
}