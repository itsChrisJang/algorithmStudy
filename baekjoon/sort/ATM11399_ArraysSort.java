package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM11399_ArraysSort {

    // 백준 11399번
    // ATM
    // (1 ≤ Pi ≤ 1,000) => 배열에 넣고 Arrays.sort() 가능.
    // Arrays.sort()
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순으로 정렬
        Arrays.sort(arr);

        // 전 사람 대기 시간.
        int waitingTime = 0;
        int sum = 0;

        for(int j=0; j<N; j++) {
            waitingTime += arr[j];
            sum += waitingTime;
        }

        System.out.println(sum);
    }
}