package self.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 2485
title    | 가로수
level    | Silver 4
how      | GCD(최대공약수)
etc      |
 */
public class StreetTrees2485_GCD {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int gcd = 0;
        for(int i=0;i<N-1;i++){
            int distance = arr[i+1] - arr[i];
            gcd = gcd(distance,gcd);
        }
        // 전체 가로수의 수 : (최대위치-최소위치)/최대공약수+1
        System.out.println((arr[N-1]-arr[0])/gcd+1-(arr.length));
    }

    // 최대공약수 재귀 방식
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;

        // GCD(a, b) = GCD(b, r)이므로 (r = a % b)
        return gcd(b, a % b);
    }
}