package self.baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 16435
title    | 스네이크버드
level    | Siver 5
how      |
etc      |
 */
public class SneakBird16435 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int fruit[] = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(fruit);

        for(int i=0;i<N;i++) {
            if(fruit[i] <= L) {
                L++;
            }else {
                break;
            }
        }

        sb.append(L);
        sb.append("\n");

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}