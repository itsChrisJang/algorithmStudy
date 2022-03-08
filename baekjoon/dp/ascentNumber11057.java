package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AscentNumber11057 {

    static int cnt = 0;
    static int N =0;

    // 백준 11067번
    // DP
    // 시간 초과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(; N>=1; N--) {
            String[] str = new String[N];
            //0 10 100 1000
            // 1 2   3    4
            int from = (N == 1) ? 0 : (int) Math.pow(10, N-1);

            int to = ((int) Math.pow(10, N)) - 1;

            for(;from <= to; from++) {
                str = String.valueOf(from).split("");
                check(str);
            }
        }

        System.out.println(cnt%10007);

    }

    static void check(String[] str) {
        for(int i=0; i<str.length; i++) {

            if(i != N - 1) {
                if(strToInt(str[i]) > strToInt(str[i+1])) break;
            }else {
                cnt++;
            }
        }
    }

    static int strToInt(String str) {
        return Integer.parseInt(str);
    }
}