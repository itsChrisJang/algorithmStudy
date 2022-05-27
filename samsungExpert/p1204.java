package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// platform | SW Expert Academy
// number   | 1204
// title    | 1일차 - 최빈수 구하기
// level    | D2
// how      |
// etc      |
// result   | 
public class p1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] scores;

        for(int test_case = 1; test_case <= T; test_case++) {
            scores = new int[101];

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            int maxScore = 0;
            int cnt = 0;

            while(st.hasMoreTokens()) {
                int point = Integer.parseInt(st.nextToken());
                scores[point] += 1;

                if(cnt <= scores[point]) {
                    maxScore = point;
                    cnt = scores[point];
                }
            }

            System.out.printf("#%d %d%n", N, maxScore);
        }
    }
}
