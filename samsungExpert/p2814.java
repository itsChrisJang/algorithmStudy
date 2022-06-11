package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// platform | SW Expert Academy
// number   | 2814
// title    | 최장 경로
// level    | D3
// how      |
// etc      | 다시 풀기
// result   | 
public class p2814 {
    static boolean[] visited;
    static int[][] arr;
    static  int N;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int[] sum;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arr = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = arr[y][x] = 1;

                for (int j = 1; j < N + 1; j++) {
                    //여기서 visited 배열을 초기화 시켜주면 아래 36줄의 visited[i] = false 문 필요없음
                    //visited = new boolean[N+1];
                    dfs(1, j);
                    visited[j] = false;
                }

                System.out.println("#" + t + " " + max);
            }
        }
    }

    static void dfs(int cnt, int v) {
        visited[v] = true;

        for(int i=0; i<N+1; i++) {
            if(arr[v][i] == 1 && !visited[i]) {
                dfs(cnt+1, i);
                visited[i] = false;
            }
        }
        max = Math.max(cnt, max);
    }
}
