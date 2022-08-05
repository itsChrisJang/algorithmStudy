package self.baekjoon.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
platform | Baekjoon
number   | 2671
title    | 잠수함식별
level    | Gold 5
how      |
etc      |
 */
public class Submarine2671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정규 표현식
        String regex = "^(100+1+|01)+$";

        String str = br.readLine();

        if(str.matches(regex)) {
          System.out.println("SUBMARINE");
        }else {
          System.out.println("NOISE");
        }

        br.close();
    }
}