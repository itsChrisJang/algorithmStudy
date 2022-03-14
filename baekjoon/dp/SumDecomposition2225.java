package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumDecomposition2225 {

    // 백준 2225
    // DP : DP[K][N] = DP[K][N-1] + DP[K-1][N]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int[][] dp = new int[201][201]; // k번 더해서 n이 되는 경우의 수

        for(int i=1;i<=k;i++) {
            dp[i][0]=1;
        }
        for(int i=1;i<=k;i++) {
            for(int j=1;j<=n;j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000; // 1000000000으로 나누는 걸 출력할 때 주면 틀렸다고 뜸.
            }
        }
        System.out.println(dp[k][n]);
    }


}