package self.baekjoon.bfsNdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 6603
title    | 로또
level    | Siver 2
how      |
etc      |
 */
public class Lotto6603 {
    static int[] S;
    static int[] result;
    static int k;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) {
                break;
            }
            result = new int[k];
            S = new int[k];
            for(int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);

            System.out.println();
        }// end of while

    }

    private static void dfs(int start, int depth) {
        if(depth == 6) {
            print();
        }
        for(int i = start; i < k; i++) {
            result[i] = 1;
            dfs(i+1, depth+1);
            result[i] = 0;
        }
    }

    private static void print() {
        for(int i =0; i < k; i++) {
            if(result[i] == 1) {
                System.out.print(S[i]+" ");
            }
        }
        System.out.println();
    }
}