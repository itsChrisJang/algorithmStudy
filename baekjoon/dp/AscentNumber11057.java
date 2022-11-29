package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AscentNumber11057 {

    // 백준 11057번
    // DP
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //DP[N][K]는 N개 자리의 숫자 중 가장 맨뒤의 숫자가 K일때의 경우의 수
        int[][] dp = new int[N+1][10];

        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i < N+1; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        System.out.println(dp[N][0] % 10007);
    }
}