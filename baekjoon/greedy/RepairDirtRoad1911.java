package self.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 1911
title    | 흙길 보수하기
level    | Silver 1
how      | greedy
etc      | sort Comparator
 */
public class RepairDirtRoad1911 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];	// 물 웅덩이 시작, 끝위치
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 물웅덩이의 시작 위치를 기준으로 오름차순 -> 시작 위치가 동일하면 끝 위치를 기준으로 오름차순
        Arrays.sort(arr, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 필요한 널빤지의 개수
        int cnt = 0;
        // 널빤지를 물웅덮이에 덮었을때, 덮을 수 있는 범위
        int range = 0;

        for(int i=0; i<N; i++) {
            if(arr[i][0] > range)
                range = arr[i][0];

            if(arr[i][1] >= range) {
                while(arr[i][1] > range) {
                    range += L;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

}