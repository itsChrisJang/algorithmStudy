package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM11399_CountingSort {

    // 백준 11399번
    // ATM
    // Counting Sort
    // https://st-lab.tistory.com/147
    // 대기 시간을 최소로 그리디 알고리즘.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int waitingTime = 0;
        int sum = 0;

        for(int j=0; j<N; j++) {
            waitingTime += arr[j];
            sum += waitingTime;
        }

        System.out.println(sum);
    }
}