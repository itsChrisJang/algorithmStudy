package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindingGoodNum1253 {

    // 백준 1253번
    // Gold 3
    // '좋은 수 구하기'
    static int N;
    static int cnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] visited = new boolean[N];
        N =Integer.parseInt(br.readLine());
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        comb1(dp, visited, 0, 2, dp[N-1]);
    }

    static void comb1(int[] arr, boolean[] visited, int start, int r, int max) {
        if(r == 0) {
            count(arr, visited, max);
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, r - 1, max);
                visited[i] = false;
            }
        }
    }

    // 배열 출력
    static void count(int[] arr, boolean[] visited, int max) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true)
                sum += arr[i];
        }
        if(sum <= max) {
            cnt++;
        }
    }
}