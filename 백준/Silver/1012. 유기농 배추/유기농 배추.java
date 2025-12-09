import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] matrix;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int testCaseIndex = 0; testCaseIndex < T; testCaseIndex++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            matrix = new int[N+1][M+1];
            int count = 0;
            //input에 맞춰서 matrix 그리기
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[y][x] = 1;
            }
            //matrix 순회하며 1이 아닌 값 찾아서 dfs 실행 및 count 업데이트
            for(int row = 0; row < N; row++){
                for(int col = 0; col < M; col++){
                    if(matrix[row][col] == 1){
                        dfs(col, row);
                        count += 1;
                    }
                }
            }
           bw.write(count + "\n");
        }
        bw.flush();
    }

    public static void dfs(int x, int y){
        if(matrix[y][x] == 0){
            return;
        }
        if(matrix[y][x] == 1){
            matrix[y][x] = 0;
            //상하좌우에 1이 있을 시, 그 위치에 대해 dfs 실행
            //더 이상 1이 없을 때 dfs 종료됨
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx > M || ny < 0 || ny > N) continue;
                if(matrix[ny][nx] == 1){
                    dfs(nx, ny);
                }
            }
        }
    }
}