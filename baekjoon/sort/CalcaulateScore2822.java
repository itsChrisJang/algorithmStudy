package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
platform | Baekjoon
number   | 2822
title    | 점수 계산
level    | Silver 5
how      | Comparator
etc      |
*/
public class CalcaulateScore2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[8][2];
        int[] result = new int[5];
        StringBuffer sb = new StringBuffer();
        int answer = 0;

        for (int i = 0; i < 8; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0])
                    return 1;
                else if (o1[0] == o2[0])
                    return 0;
                else
                    return -1;
            }
        });

        for (int i = 0; i < 5; i++) {
            answer += arr[i][0];
            result[i] = arr[i][1] + 1;
        }

        Arrays.sort(result);

        System.out.println(answer);
        for (int i = 0; i < 5; i++) {
            System.out.print(result[i] + " ");
        }

    }
}