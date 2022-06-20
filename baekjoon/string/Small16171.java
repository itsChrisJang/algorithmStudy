package self.baekjoon.string;

import java.io.IOException;
import java.util.Scanner;

/*
platform | Baekjoon
number   | 16171
title    | 나는 친구가 적다 (Small)
level    | Siver 5
how      |
etc      |
 */
public class Small16171 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String word = "";
        String find = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9))
                word += str.charAt(i);
        }
        System.out.println(word.indexOf(find) != -1 ? 1 : 0);
    }
}