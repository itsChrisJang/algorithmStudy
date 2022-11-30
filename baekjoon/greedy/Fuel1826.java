package self.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 1826
title    | 연료 채우기
level    | Gold 3
how      | greedy
etc      | 우선순위 큐
 */
public class Fuel1826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<GasStation> stations = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            stations.add(new GasStation(a, b));
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> fuels = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        while (P < L) {
            while (!stations.isEmpty() && stations.peek().a <= P) {
                fuels.add(stations.poll().b);
            }

            if (fuels.isEmpty()) {
                System.out.println(-1);
                return;
            }

            answer++;
            P += fuels.poll();
        }

        System.out.println(answer);
    }

    public static class GasStation implements Comparable<GasStation> {
        int a;
        int b;

        public GasStation(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(GasStation o) {
            return this.a - o.a;
        }
    }

}