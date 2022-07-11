package self.baekjoon.backtracking;

import java.util.Scanner;

/*
platform | Baekjoon
number   | 1182
title    | 부분수열의 합
level    | Silver 2
how      |
etc      |
 */
public class SumOfSubsequence1182 {
    static int[] num;
    // 정수의 개수
    private static int S;
    // 정수의 합
    private static int N;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        dfs(0, 0);

        // S 0일때 처리
        if (S == 0)
            System.out.println(answer - 1);
        else
            System.out.println(answer);

    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) answer++;
            return;
        }

        // 1. 해당 인덱스 더함
        dfs(depth + 1, sum + num[depth]);

        // 2. 해당 인덱스 더하지않음
        dfs(depth + 1, sum);
    }
}