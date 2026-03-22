import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int N;
    public static int blueCnt = 0;
    public static int whiteCnt = 0;
    public static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
               arr[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        recur(0, N-1, 0, N-1);
        bw.write(whiteCnt + "\n" + blueCnt);
        bw.flush();
        bw.close();
    }
    public static void recur(int Xstart, int Xend, int Ystart, int Yend){
        if(checkColor(Xstart, Xend, Ystart, Yend)){
            if(arr[Ystart][Xstart] == 0){
                whiteCnt++;
            }else{
                blueCnt++;
            }
            return;
        }
        int midX = (Xstart+Xend)/2;
        int midY = (Ystart+Yend)/2;
        recur(Xstart, midX, Ystart, midY);
        recur(midX+1, Xend, Ystart, midY);
        recur(Xstart, midX, midY+1, Yend);
        recur(midX+1, Xend, midY+1, Yend);
    }

    public static boolean checkColor(int Xstart, int Xend, int Ystart, int Yend){
        int color = arr[Ystart][Xstart];
        for(int row = Ystart; row <= Yend; row++){
            for(int col = Xstart; col <= Xend; col++){
                if(color != arr[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}