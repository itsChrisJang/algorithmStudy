package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// platform | SWEA
// number   | 5215
// title    | 햄버거 다이어트
// level    | D3
// how      |
// etc      |
// result   | 
public class p5215 {
    static int N, L;
    static int[] score;
    static int[] cal;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            score = new int[N+1];
            cal = new int[N+1];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            // 초기화 해야함.
            ans = 0;
            hamburger(0, 0, 0);

            System.out.println("#" + t + " " + ans);
        }
    }

    static  void hamburger(int idx, int sumt, int sumc) {
        if (sumc > L)
            return;
        if (idx == N) {
            if (sumt > ans) {
                ans = sumt;
            }
            return;
        }

        hamburger(idx + 1, sumt + score[idx], sumc + cal[idx]);
        hamburger(idx + 1, sumt, sumc);
    }

}
