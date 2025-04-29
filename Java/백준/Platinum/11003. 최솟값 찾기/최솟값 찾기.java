import java.io.*;
import java.util.*;

import static java.util.Arrays.sort;


public class Main {

    static class Node{
        public int index;
        public int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> D = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(st.nextToken());
            while(!D.isEmpty() && D.getLast().value > now){
                D.removeLast();
            }
            Node a = new Node(i, now);
            D.addLast(a);
            if(D.getFirst().index <= i-L){
                D.removeFirst();
            }
            bw.write(D.getFirst().value + " ");

        }
        bw.flush();
        bw.close();
    }
}