package self.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 2476
title    | 주사위 게임
level    | Bronze 3
how      |
etc      |
 */
public class Dice2476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //최대값 저장할 변수 선언
        int max = 0;

        //참가 인원 수 만큼 반복하는 for문
        for(int i = 0; i < N; i++) {
            //사람이 바뀔때마다 금액을 초기화
            int money = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            //나오는 눈에 따른 금액 저장
            if(A == B && B == C ) {
                money = 10000 + (A * 1000);
            }else if(A != B && B != C && A != C) {
                money = Math.max(A, Math.max(B, C)) * 100;
            }else {
                if(A == B || A == C) {
                    money = 1000 + (A * 100);
                }else {
                    money = 1000 + (B * 100);
                }
            }
            //최대값 저장
            if(money > max) {
                max = money;
            }
        }
        System.out.println(max);
    }
}