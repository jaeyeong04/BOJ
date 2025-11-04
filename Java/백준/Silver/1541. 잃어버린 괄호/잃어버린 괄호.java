import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        int sum = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");
        while(subtraction.hasMoreTokens()){
            String currentString = subtraction.nextToken();
            int temp = 0;
            StringTokenizer addition = new StringTokenizer(currentString, "\\+");
            while(addition.hasMoreTokens()){
                temp += Integer.parseInt(addition.nextToken());
            }
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }else{
                sum -= temp;
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}