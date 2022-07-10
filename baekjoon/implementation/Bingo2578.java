package self.baekjoon.implementation;

import java.util.Scanner;

/*
platform | Baekjoon
number   | 2578
title    | 빙고
level    | Silver 4
how      |
etc      |
 */
public class Bingo2578 {
    static int[][] map = new int[5][5];
    static int answer = 0;
    static int bingo = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 사회자가 부르는 숫자
        for (int i = 0; i < 25; i++) {
            int number = sc.nextInt();
            answer++;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (map[j][k] == number) { // 찾아서
                        map[j][k] = -1; // -1 로 설정해두고

                        if (check(j, k) >= 3) {
                            System.out.println(answer);
                            return;
                        }
                    }
                }
            }
        }

    }

    private static int check(int r, int c) {
        int cnt = 0;
        // 가로 방향 보기
        for (int i = 0; i < 5; i++) {
            int rcnt = 0;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == -1)
                    rcnt++;
            }
            if (rcnt == 5)
                cnt++;
        }

        // 세로 방향 보기
        for (int i = 0; i < 5; i++) {
            int ccnt = 0;
            for (int j = 0; j < 5; j++) {
                if (map[j][i] == -1)
                    ccnt++;
            }
            if (ccnt == 5)
                cnt++;
        }
        // 우상향 대각선 보기
        int ccnt = 0;
        for (int i = 4; i >= 0; i--) {

            if (map[4-i][i] == -1)
                ccnt++;
            if (ccnt == 5)
                cnt++;
        }

        // 우하향대각선
        ccnt= 0;
        for ( int i=0; i<5; i++) {
            if ( map[i][i] == -1 ) ccnt++;
            if (ccnt == 5) cnt ++;
        }
        return cnt;
    }
}