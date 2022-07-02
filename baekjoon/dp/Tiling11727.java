package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 11727
title    | 2×n 타일링 2
level    | Silver 3
how      | dp
etc      | dp[n]=dp[n−1]+2×dp[n−2]
 */
public class Tiling11727 {
    static boolean[][] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;

        System.out.println(dp[n]);
    }
}