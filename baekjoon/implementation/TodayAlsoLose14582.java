package self.baekjoon.implementation;

import java.io.IOException;
import java.util.Scanner;

/*
platform | Baekjoon
number   | 14582
title    | 오늘도 졌다
level    | Siver 5
how      |
etc      |
 */
public class TodayAlsoLose14582 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String[] teamA = sc.nextLine().split(" ");
        String[] teamB = sc.nextLine().split(" ");

        int score = 0;
        for (int i = 0; i < teamA.length; i++) {
            score += Integer.parseInt(teamA[i]);
            if (score > 0) {
                System.out.println("Yes");
                return;
            }
            score -= Integer.parseInt(teamB[i]);
        }
        System.out.println("No");
    }
}