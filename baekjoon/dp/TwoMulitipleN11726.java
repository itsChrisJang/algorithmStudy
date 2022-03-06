package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoMulitipleN11726 {

    // 백준 11726번
    // 점화식 : dp[n] = dp[n-1] + dp[n-2]; // (n >= 3)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = strToInt(br.readLine());

        if(n == 2) {
            System.out.println(2);
            return;
        }else if(n == 1) {
            System.out.println(1);
            return;

        }
        int[] np = new int[n];

        np[0] = 1;
        np[1] = 2;
        for(int i = 3; i <= n; i++) {
            np[i-1] = np[i-2] + np[i-3];
        }
        sb.append(np[n-1]%10007);
        System.out.println(sb);
        sb.setLength(0);
    }

    static int strToInt(String str) { return Integer.parseInt(str); }
}
