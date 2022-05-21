package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  TastingWine2156_DP {

    // 백준 2156번
    // 포도주 시식
    // DP(동적 계획법)
    // # 점화식
    // oox : dp[i-1]
    // oxo : dp[i-2] + arr[i]
    // xoo : dp[i-3] + arr[i-1] + arr[i]
    // =>
    // Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] dp = new Integer[N + 1];
        int[] arr = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];

        /*
         *  (N이 1로 주어질 수 있으므로 이럴 때를 위해 조건식을 달아둔다.
         *  또한 dp[2]는 어떤 경우에도 첫 번째와 두 번째를 합한 것이 최댓값이다.
         */
        if(N > 1) {
            dp[2] = arr[1] + arr[2];
        }

        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
        }

        System.out.println(dp[N]);

    }
}