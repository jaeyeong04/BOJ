import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] S = new int[21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();
            int n;
            switch (action) {
                case "add":
                    n = Integer.parseInt(st.nextToken());
                    add(n);
                    break;
                case "remove":
                    n = Integer.parseInt(st.nextToken());
                    remove(n);
                    break;
                case "check":
                    n = Integer.parseInt(st.nextToken());
                    bw.write(check(n) + "\n");
                    break;
                case "toggle":
                    n = Integer.parseInt(st.nextToken());
                    toggle(n);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
                default:
                    break;
            }
        }
        bw.flush();
    }

    public static void add(int n){
        S[n] = 1;
    }

    public static void remove(int n){
        S[n] = 0;
    }

    public static int check(int n){
         return S[n];   
    }

    public static void toggle(int n){
        if(S[n] == 1){
            S[n] = 0;
        } else if(S[n] == 0){
            S[n] = 1;
        }
    }

    public static void all(){
        for(int i = 1; i < S.length; i++){
            S[i] = 1;
        }
    }

    public static void empty(){
        for(int i = 1; i < S.length; i++){
            S[i] = 0;
        }
    }
}