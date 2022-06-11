package self.baekjoon.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// platform | Baekjoon
// number   | 1256
// title    | 사전
// level    | Gold 3
// how      | DP
// etc      |
// result   | 
public class Dictionary1256_ {
    static ArrayList<String> stringCombination = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        nCr("abcd".toCharArray(), 1, "");


        br.close();
    }

    static void nCr(char[] str, int r, String result){
        if(r == 0){
            stringCombination.add(result);
            return;
        }else{
            for(int i = 0; i < str.length; i++){
                nCr(str, r-1, result+str[i]);
            }
        }
    }
}
