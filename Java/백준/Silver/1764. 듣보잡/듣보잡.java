import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] arrN = new String[N];
        String[] arrM = new String[M];
        for(int i = 0; i < N; i++){
            arrN[i] = br.readLine();
        }
        for(int i = 0; i < M; i++){
            arrM[i] = br.readLine();
        }
        int count = 0;
        Arrays.sort(arrN);
        Arrays.sort(arrM);
        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i < M; i++){
            if(Arrays.binarySearch(arrN, arrM[i]) >= 0){
                count++;
                answer.add(arrM[i]);
            }
        }
        bw.write(count + "\n");
        for(int i = 0; i < answer.size(); i++){
            bw.write(answer.get(i) + "\n");
        }
        bw.flush();
    }
}