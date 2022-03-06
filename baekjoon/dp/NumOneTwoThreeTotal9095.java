package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumOneTwoThreeTotal9095 {
    // 백준 9095번
    // Dynamic Programming (동적 프로그래밍)
    // 점화식 : dp[n] = dp[n-1] + dp[n-2] + dp[n-3]; // (n >= 4)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = stoi(br.readLine());
        int[] dp = new int[n+2]; // new int[n+1] 로 하면  런타임 에러(ArrayIndexOutOfBounds) 발생 new int[1001]로 바꿔줌
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
    static int stoi(String str) {return Integer.parseInt(str);}
}
