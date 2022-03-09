package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuyingCard11052 {

    // 백준 11052번
    // DP
    /*
     * 카드 N개를 구매해야한다.
        카드팩에 들어있는 카드가 적은 것부터 산다.
        카드 N개를 구매하는데 드는 비용의 최대를 구하는 문제이다.

        DP를 풀때 일반항 형태로 정의하는 것이 중요하다.

        일단, 케이스 단위로 생각해보자.
        카드 i개를 구매하는 방법은?
        카드 1개가 들어있는 카드팩을 구매하고, 카드 i-1개를 구입한다.
        카드 2개가 들어있는 카드팩을 구매하고, 카드 i-2개를 구입한다.
        카드 3개가 들어있는 카드팩을 구매하고, 카드 i-3개를 구입한다.
       => D[i] = P[n] + D[i-n]
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //D[i] = P[n] + D[i-n]
        int[] P = new int[N+1];
        int[] D = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                D[i] = Math.max(D[i], D[i-j] + P[j]);
            }
        }

        System.out.println(D[N]);
        br.close();
    }
}