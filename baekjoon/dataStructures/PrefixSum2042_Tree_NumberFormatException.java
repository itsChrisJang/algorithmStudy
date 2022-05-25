package self.baekjoon.dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// platform | Baekjoon
// number   | 2042
// title    | 구간 합 구하기
// level    | Gold 1
// how      | implementation
// etc      |
// result   | 
// NumberFormatException : int => long으로 변환
public class PrefixSum2042_Tree_NumberFormatException {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            long n = Long.parseLong(br.readLine());
            arr[i] = n;
        }
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1) {
                change(b, c);
            }else if(a == 2) {
                printSum(b, c);
            }
        }
        br.close();
    }

    private static void printSum(int b, long c) {
        long sum = 0;

        for(int i=b; i<=(int)c; i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }

    private static void change(int b, long c) {
        arr[b] = c;
    }
}
