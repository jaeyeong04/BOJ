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
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        //graph를 2차원 배열로 나타내기
        graph = new int[V+1][V+1];
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        visited = new boolean[V+1];
        recursiveDFS(start, bw);
        bw.write("\n");
        visited = new boolean[V+1];
        bfs(start, bw);
        bw.flush();
    }
   

    public static void recursiveDFS(int v, BufferedWriter bw) throws IOException {
        if(visited[v] == true){
            return;
        }else{
            visited[v] = true;
            bw.write(v + " ");
        }
        for(int i = 1; i < graph.length; i++){
            if(graph[v][i] == 1 && visited[i] == false) {
                recursiveDFS(i, bw);
            }
        }
    }

    public static void bfs(int v, BufferedWriter bw) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            int visitedNode = queue.remove();
            if(visited[visitedNode] == true){
                continue;
            }else{
                visited[visitedNode] = true;
                bw.write(visitedNode + " ");
            }
            for(int i = 1; i < graph.length; i++){
                if(graph[visitedNode][i] == 1 && visited[i] == false) {
                    queue.add(i);
                }
            }
        }
    }
}