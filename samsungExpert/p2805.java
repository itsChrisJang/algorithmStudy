package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// platform | SWEA
// number   | 2805
// title    | 농작물 수확하기
// level    | D3
// how      |
// etc      |
// result   | 
public class p2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[][] arr;
        for (int t = 1; t <= T; t++) {
            // 초기화 해야함.
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1][N + 1];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j)-'0';
                }
            }

            int sum = 0, mid = N / 2, area = 0;
            for (int i = 0; i < N; i++) {
                int start = mid - area;
                int end = mid + area;
                for (int j = start; j <= end; ++j) {
                    sum += arr[i][j];
                }

                if(i >= mid) {
                    area--;
                }else {
                    area++;
                }

            }
            System.out.println("#" + t + " " + sum);
        }
    }
}
