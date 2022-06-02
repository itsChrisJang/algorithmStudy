package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 11650
title    | 좌표 정렬하기
level    | Siver 5
how      | Comparator
etc      |
 */
public class SortingCoordinate11650_Comparator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 0번째가 같다면 1번째로 오름차순
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                // 0번째로 오름차순
                return o1[0] - o2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        System.out.println(sb);

        sb.setLength(0);
        br.close();
    }
}