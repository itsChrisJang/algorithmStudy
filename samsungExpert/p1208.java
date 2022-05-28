package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// platform | SW Expert Academy
// number   | 1208
// title    | [S/W 문제해결 기본] 1일차 - Flatten
// level    | D3
// how      |
// etc      |
// result   | 
public class p1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr;
        for(int t = 1; t <= 10; t++) {
            int dump = Integer.parseInt(br.readLine());
            arr = new int[100];

            st = new StringTokenizer(br.readLine(), " ");
            System.out.print("#" + t + " ");

            int idx = 0;
            while(st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            for(int i=0; i<dump; i++) {
                arr[0]++;
                arr[99]--;
                Arrays.sort(arr);
            }

            System.out.println((arr[99] - arr[0]));
        }
    }
}
