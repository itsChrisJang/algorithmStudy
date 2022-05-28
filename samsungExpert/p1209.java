package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// platform | SW Expert Academy
// number   | 1209
// title    | [S/W 문제해결 기본] 2일차 - Sum
// level    | D3
// how      |
// etc      |
// result   | 
public class p1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int[][] arr;
        int[] sum;
        for(int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());

            arr = new int[101][101];
            sum = new int[202];

            // 가로 배열에 값 넣고 가로 값 계산
            for(int i=0; i<100; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int widthSum = 0;
                for(int j=0; j<100; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    arr[i][j] = val;
                    widthSum += val;
                }
                sum[i] = widthSum;
            }

            // 세로 값 계산
            for(int i=0; i<100; i++) {
                int vertSum = 0;
                for (int j = 0; j < 100; j++) {
                    vertSum += arr[j][i];
                }
                sum[i+100] = vertSum;
            }

            // 대각선 값 계산
            int crossSumLeft = 0;
            int crossSumRight = 0;
            for(int i=0; i<100; i++) {
                crossSumLeft += arr[i][i];
                crossSumRight += arr[i][99-i];
            }
            sum[200] = crossSumLeft;
            sum[201] = crossSumRight;

            Arrays.sort(sum);
            System.out.println("#" + t + " " + sum[201]);
        }
    }
}
