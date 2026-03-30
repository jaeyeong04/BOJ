import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        int count = 0;
        for(int i = 1; i < graph.length; i++){
            if(visited[i] == false){
                bfs(i);
                count++;
            }else{
                continue;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            int targetNode = queue.remove();
            if(visited[targetNode] == true){
                continue;
            }else{
                visited[targetNode] = true;
            }
            for(int i=0; i < graph.length; i++){
                if(graph[targetNode][i] == 1 && visited[i] == false){
                    queue.add(i);
                }
            }
        }
    }
}