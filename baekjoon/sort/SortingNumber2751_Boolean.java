package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
platform | Baekjoon
number   | 2751
title    | 수 정렬하기 2
level    | Siver 5
how      | boolean[] 생성 + 절대값 비교
etc      |
 */
public class SortingNumber2751_Boolean {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // ~1,000,000 ~ 1,000,000
        // 절대값 비교
        // 0 보다 작을 경우 : index 0 ~ 1,000,000
        boolean[] arr = new boolean[20000001];
        for(int i=0; i<N; i++){
            arr[Integer.parseInt(br.readLine()) +1000000] = true;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i]) {
                sb.append(i - 1000000).append("\n");
            }
        }

        System.out.println(sb);
    }
}