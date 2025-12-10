import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] matrix;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] firstLineInputArray = br.readLine().split(" ");
        N = Integer.parseInt(firstLineInputArray[0]);
        M = Integer.parseInt(firstLineInputArray[1]);
        matrix = new int[N][M];
        for(int i = 0; i < N; i++){
            String[] rowInput = br.readLine().split("");
            for(int j = 0; j < M; j++){
                matrix[i][j] = Integer.parseInt(rowInput[j]);
            }
        }
        bfs();
        bw.write(String.valueOf(matrix[N-1][M-1]));
        bw.flush();
    }

    public static void bfs(){
        //시작 좌표는 어차피 (0, 0)
        int[] startCoord = {0, 0};
        queue.add(startCoord);
        while(!queue.isEmpty()){
            int[] coord = queue.remove();
            int x = coord[0];
            int y = coord[1];
            if(x == M-1 && y == N-1) return;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(matrix[ny][nx] == 1){
                    int[] arr = {nx, ny};
                    queue.add(arr);
                    matrix[ny][nx] = matrix[y][x] + 1;
                }
            }
        }
    }
}