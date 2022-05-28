package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// platform | SW Expert Academy
// number   | 1954
// title    | 달팽이 숫자
// level    | D2
// how      |
// etc      |
// result   | 
public class p1954 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] dd = {0, 1, 2, 3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            int n = 1, x = 0, y = 0, d = 0;
            while(n <= N*N) {
                int X = x + dx[dd[d]], Y = y + dy[dd[d]];
                if(X < 0 || X >= N || Y < 0 || Y >= N || arr[X][Y] != 0) {
                    d = (d + 1) % 4;        // 방향 바뀜
                    X = x + dx[dd[d]];
                    Y = y + dy[dd[d]];
                }
                arr[x][y] = n++;
                x = X;
                y = Y;
            }
            System.out.printf("#%d%n", t);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) System.out.print(arr[i][j] + " ");
                System.out.println();
            }
        }
    }
}
