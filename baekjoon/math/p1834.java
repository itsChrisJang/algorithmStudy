package self.baekjoon.math;

import java.io.IOException;
import java.util.Scanner;

/*
platform | Baekjoon
number   | 1834
title    | 나머지와 몫이 같은 수
level    | Bronze 1
how      |
etc      |
 */
public class p1834 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();
        long sum  = 0;
        for(long i=1;i<num;i++)
        {
            sum += (num+1)*i;
        }

        System.out.println(sum);
    }
}