package self.baekjoon.greedy;

import java.io.IOException;
import java.util.Scanner;

/*
platform | Baekjoon
number   | 11501
title    | 주식
level    | Silver 2
how      |
etc      |
 */
public class Stock11501 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        long ans[] = new long[testcase];

        for( int n = 0 ; n < testcase ; n++ ) {
            int days = sc.nextInt();
            long stocks[] = new long[days];
            long max = 0;

            for( int i = 0 ; i < days ; i++ ) {
                stocks[i] = sc.nextInt();
            }

            for( int i = days-1 ; i >= 0 ; i-- ) {
                if(stocks[i] > max) {
                    max = stocks[i];
                }else {
                    ans[n] += (max - stocks[i]);
                }
            }
        }

        for( long i : ans) {
            System.out.println(i);
        }
    }
}