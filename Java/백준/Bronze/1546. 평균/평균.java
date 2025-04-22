import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        double[] initialScores = new double[n];
        double max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            initialScores[i] = Integer.parseInt(st.nextToken());
            if(initialScores[i] > max){
                max = initialScores[i];
            }
        }
        double[] newScores = new double[n];
        double sum = 0;
        for(int i = 0; i < n; i++){
            newScores[i] = (initialScores[i]/max)*100;
            sum += newScores[i];
        }
        bw.write(Double.toString(sum/n));
        bw.flush();
    }
}