import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] matrix;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int numNode = Integer.parseInt(br.readLine());
        matrix = new int[numNode+1][numNode+1];
        visited = new boolean[numNode+1];
        visited[1] = true;
        int numEdge = Integer.parseInt(br.readLine());
        for(int i = 0; i < numEdge; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }
        int answer = bfs();
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    public static int bfs(){
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            //pivot은 이번에 방문한 노드
            int pivot = queue.remove();
            for(int i = 1; i < matrix.length; i++){
                int target;
                if(matrix[pivot][i] == 1 && visited[i] == false){
                    queue.add(i);
                    visited[i] = true;
                    matrix[pivot][i] = 0;
                    matrix[i][pivot] = 0;
                    count++;
                }
            }
        }
        return count;
    }
}