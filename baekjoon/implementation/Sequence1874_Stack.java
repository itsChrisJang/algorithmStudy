package self.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
platform | Baekjoon
number   | 1874
title    | 스택 수열
level    | Siver 3
how      | Stack
etc      |
 */
public class Sequence1874_Stack {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();    // 출력할 결과물 저장

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        int start = 0;

        // N 번 반복
        while (N-- > 0) {
            int value = Integer.parseInt(br.readLine());

            if(value > start) {
                for(int i=1+start; i<=value; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = value;
            }else if(stack.peek() != value) {
                sb.setLength(0);
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}