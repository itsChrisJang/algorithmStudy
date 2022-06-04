package self.baekjoon.math;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 2609
title    | 최대공약수와 최소공배수
level    | Siver 5
how      | \
etc      |
 */
public class p2609 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int d = gcd(a, b);	// 최대공약수

        System.out.println(d);
        System.out.println(a * b / d);

    }

    // 최대공약수 재귀 방식
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;

        // GCD(a, b) = GCD(b, r)이므로 (r = a % b)
        return gcd(b, a % b);
    }
}