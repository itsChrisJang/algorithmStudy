package self.baekjoon.implementation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 1966
title    | 프린터 큐
level    | Siver 3
how      | Queue
etc      |
 */
public class PrinterQueue1966_Queue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            // N : 문서의 개수
            int N = Integer.parseInt(st.nextToken());
            // M : 몇 번째로 인쇄되었는지 궁금한 문서가
            //     현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                q.add(new int[] { i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;	// 출력 횟수

            while(q.size() != 0) {

                int[] front = q.poll();
                // front 원소가 가장 큰 원소인지 판단하는 변수.
                boolean isMax = true;

                // max 비교.
                for(int i=0; i<q.size(); i++) {
                    if(front[1] < q.get(i)[1]) {
                        q.offer(front);
                        for(int j=0; j<i; j++){
                            q.offer(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                // 최대값이 아니면 count 안한다.
                if(isMax == false) {
                    continue;
                }

                count++;
                // 찾는 자릿수 값이면 while문 종료
                if(front[0] == M) {
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}