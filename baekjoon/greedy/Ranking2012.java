package self.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// platform | Baekjoon
// number   | 2012
// title    | 등수 매기기
// level    | Silver 3
// how      | greedy
// etc      |
public class Ranking2012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long sum = 0;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++) {
            sum += Math.abs(arr[i] - (i+1));
        }

        System.out.println(sum);
    }


}