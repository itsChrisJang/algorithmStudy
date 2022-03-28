package self.baekjoon.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2749번
// 피사노 주기
// 피보나치 수를 나느눈 수를 k라고 할 때, k=10의 n승이면,
// 피사노 주기는 15x10의 n-1승이다.

// 해당 문제에서 k = 1,000,000
// 피사노 주기는 1,500,000
public class Fibonacci2749 {
    public static void main(String[] args) throws IOException {
        final int K = 1000000;
        final int PISANO = 1500000;

        // N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        N %= PISANO;

        long[] arr;
        if (N > PISANO) arr = new long[PISANO];
        else arr = new long[(int)N+1];

        // 피보나치 수 구하기
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % K;
        }

        // 출력
        System.out.println(arr[(int)N]);
    }
}