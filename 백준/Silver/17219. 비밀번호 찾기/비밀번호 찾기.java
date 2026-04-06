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
        HashMap<String, String> map = new HashMap<>();
        //map에 N개의 사이트&주소 페어 저장
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String pw = st.nextToken();
            map.put(url, pw);
        }
        //map에서 input된 사이트에 해당하는 비번 추출
        for(int i = 0; i < M; i++){
            String targetUrl = br.readLine();
            String correspondingPW = map.get(targetUrl);
            bw.write(correspondingPW+"\n");
        }
        bw.flush();
        bw.close();
    }
}