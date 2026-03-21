import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            sortedArr[i] = x;
        }
        Arrays.sort(sortedArr);
        //HashMap 사용해서 key=배열의 element, value=rank로 만들기
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for(int i = 0 ; i < N; i++){
            if(!rankMap.containsKey(sortedArr[i])){
                rankMap.put(sortedArr[i], rank);
                rank++;
            }
        }
        //답 출력
        for(int i = 0; i < N; i++){
            bw.write(rankMap.get(arr[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}