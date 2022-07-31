package self.baekjoon.implementation;

import java.util.*;

/*
platform | Baekjoon
number   | 1205
title    | 등수 구하기
level    | Silver 5
how      |
etc      |
 */
public class Ranking1205 {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int new_score = scanner.nextInt();
        int p = scanner.nextInt();

        Integer[] arr = new Integer[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        // 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        if(n == p && new_score <= arr[arr.length-1])
            System.out.print(-1);
        else {
            int rank = 1;
            for(int i=0; i<arr.length; i++){
                if(new_score < arr[i])
                    rank++;
                else
                    break;
            }
            System.out.print(rank);
        }
    }
}