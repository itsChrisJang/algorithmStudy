package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 10816
title    | 좌표 정렬하기
level    | Siver 5
how      | Counting Sort
etc      |
 */
public class CardNumber10816_CountingSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[20000001];

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(arr[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
        }

        System.out.println(sb);

        sb.setLength(0);
        br.close();
    }
}