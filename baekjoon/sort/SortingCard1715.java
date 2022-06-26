package self.baekjoon.sort;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
platform | Baekjoon
number   | 1715
title    | 카드 정렬하기
level    | Gold 4
how      | PriorityQueue
etc      |
 */
public class SortingCard1715 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        for (int i=0; i<n; i++) {
            pq.add(sc.nextLong());
        }

        long num = 0;
        //우선순위 큐에 2개이상 들어있어야 비교가 가능하다.
        while (pq.size() > 1) {
            long temp1 = pq.poll();
            long temp2 = pq.poll();

            num += temp1 + temp2;
            pq.add(temp1 + temp2); //합한 묶음 다시 넣기
        }

        System.out.println(num);
    }
}