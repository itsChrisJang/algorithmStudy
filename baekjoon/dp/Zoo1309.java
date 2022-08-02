package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
platform | Baekjoon
number   | 1309
title    | 동물원
level    | Silver 1
how      |
etc      |
            dp[N][0] = dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]
            dp[N][1] = dp[N - 1][0] + dp[N - 1][2]
            dp[N][2] = dp[N - 1][0] + dp[N - 1][1]
 */
public class Zoo1309 {
    static int mod = 9901;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][3];
        // 초기값
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        long ans = (dp[N][0] + dp[N][1] + dp[N][2]) % mod;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}