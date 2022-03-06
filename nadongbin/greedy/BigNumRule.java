package self.nadongbin.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BigNumRule {

    // 그리디 알고리즘
    // 이코테) 큰 수의 법칙
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();
       int m = sc.nextInt();
       int k = sc.nextInt();

       //7,3
       int[] arr = new int[n];

       for(int i=0;i < n; i++) {
           arr[i] = sc.nextInt();
       }

       // sorting
       Arrays.sort(arr);

       int first = arr[n-1];
       int second = arr[n-2];

       // 가장 큰 수가 더해지는 횟수 계산
       int cnt = (m / (k + 1)) * k; //(7/4) *3
       cnt += m % (k + 1);          // 7 % 4

       int result = 0;
       result += cnt * first; // 가장 큰 수 더하기
       result += (m - cnt) * second; // 두 n번째로 큰 수 더하기

       System.out.println(result);
    }
}
