package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 10942
title    | 팰린드롬?
level    | Gold 4
how      | dp
etc      | 단순 for문 구현시 timeout => dp로 해결
 */
public class Palindrome10942 {
    static boolean[][] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N+1];
        dp = new boolean[N+1][N+1];
        for(int i=0; i<N; i++) {
            arr[i+1] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        getDp(N);
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 팰린드롬
//            int[] pd = new int[e-s+1];
//            int idx = 0;
//            for(int j=s; j<=e; j++) {
//                pd[idx++] = arr[j];
//            }

            // 단순 for문
//            if(pdCheck(pd))
//                sb.append(1);
//            else
//                sb.append(0);

            // dp 접근
            if(dp[s][e]) {
                sb.append(1);
            }
            else {
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    // 단순 for문으로 팰린드롬 체크!
    // => 시간 초과
    static boolean pdCheck(int[] target) {
        int len = target.length;
        for(int i=0; i<=target.length/2; i++) {
            if(target[i] != target[len-i-1]) {
                return false;
            }
        }
        return true;
    }

    // DP 풀이
    static void getDp(int n) {
        // S ~ E 길이 : 1
        for(int i=1; i<=n; i++) {
            dp[i][i] = true;
        }

        // S ~ E 길이 : 2
        for(int i=1; i<=n-1; i++) {
            if(arr[i] == arr[i+1]) {
                dp[i][i+1] = true;
            }else {
                dp[i][i+1] = false;
            }
        }

        // S ~ E 길이 : 3 이상
        // 1) 양 끝의 숫자가 같다.
        // 2) 남은 안의 숫자들이 팰린드롬이면 이 길이의 숫자들도 팰린드롬이다.
        for(int i=3; i<=n; i++) {           // i : S ~ E 길이
            for(int j=1; j<=n-i+1; j++) {   // i 만큼의 길이를 보고 팰린드롬을 찾기 위한 시작 인덱스.
                int k = j + i - 1;
                if(arr[j] == arr[k])       // 조건 1)
                    if(dp[j+1][k-1])        // 조건 2)
                        dp[j][k] = true;
            }
        }

        //
    }
}