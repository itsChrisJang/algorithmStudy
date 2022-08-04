package self.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 2908
title    | 상수
level    | Bronze 2
how      |
etc      |
 */
public class Constant2908 {
    static int mod = 9901;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n1 = Integer.parseInt(new StringBuffer(st.nextToken()).reverse().toString());
        int n2 = Integer.parseInt(new StringBuffer(st.nextToken()).reverse().toString());

        if(n1 > n2)
            sb.append(n1);
        else if(n1 < n2)
            sb.append(n2);

        System.out.println(sb.toString());

        sb.setLength(0);
        br.close();
    }
}