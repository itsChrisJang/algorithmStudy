package self.baekjoon.math;

import java.io.IOException;
import java.util.Scanner;

/*
platform | Baekjoon
number   | 1731
title    | 추론
level    | Bronze 2
how      |
etc      |
 */
public class Inference1731 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] n = new int[num];

        for (int i = 0; i < n.length; i++) {
            n[i] = scan.nextInt();
        }
        scan.close();

        if (n[2] - n[1] == n[1] - n[0])
            System.out.println(n[n.length - 1] + (n[1] - n[0]));
        else
            System.out.println(n[n.length - 1] * (n[1] / n[0]));
    }
}