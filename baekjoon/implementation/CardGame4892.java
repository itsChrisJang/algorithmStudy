package self.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 4892
title    | 숫자 맞추기
level    | Bronze 3
how      | 
etc      |
*/
public class CardGame4892 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = 1;

        while (true) {
            int n = sc.nextInt();

            if (n == 0) break;

            int n1 = 3 * n;

            if (n1 % 2 == 0) {
                int n4 = n / 2;
                System.out.println(cnt + ". even " + n4);
            } else {
                int n4 = (n - 1) / 2;
                System.out.println(cnt + ". odd " + n4);
            }

            cnt++;
        }

    }
}