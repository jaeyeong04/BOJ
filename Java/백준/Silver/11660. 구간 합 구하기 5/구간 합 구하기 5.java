import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] A = new int[n+1][n+1];
        for(int row = 1; row <= n; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 1; col <= n; col++){
                A[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] D = new int[n+1][n+1];
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= n; col++){
                D[row][col] = D[row-1][col] + D[row][col-1] - D[row-1][col-1] + A[row][col];
            }
        }
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            bw.write(D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1] + "\n");
        }
        bw.flush();
    }
}