package self.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SectionSum11659 {

    // 백준 11659번
    // 구간 합 구하기
    static int[] S;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        S = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        // 왜? 5 5 데이터를 읽지 않는것일까?
        for(int j=0; j<=M; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            new SectionSum11659().printFromTo(from-1, to-1);
        }

        br.close();
    }

    void printFromTo(int from, int to) {
        int sum = 0;

        for(int i = from; i<=to; i++) {
            sum += S[i];
        }

        System.out.println(sum);
    }
}