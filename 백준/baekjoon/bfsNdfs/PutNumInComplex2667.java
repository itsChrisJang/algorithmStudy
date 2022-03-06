package self.baekjoon.bfsNdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PutNumInComplex2667 {
    // 백준 2667번

    static int map[][];
    static boolean visit[][]; // 방문 여부
    static int N; // 지도 최대 크기
    static int count = 1; // 총 단지 수
    static int x[] = {-1, 1, 0, 0}; // row
    static int y[] = {0, 0, -1, 1}; // col

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        visit = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && !visit[i][j]) { // 집이 있으면서 방문하지 않은 곳
                    dfs(i, j); // 연결 되어있는 단지 탐색
                    count++; // 다음 단지 수로 이동
                }
            }
        }

        // 총 단지 수
        System.out.println(count-1);
        // 단지 내 집의 수
        int result[] = new int[count];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != 0)
                    result[map[i][j]]++;
            }
        }
        // 단지수를 오름차순으로 정렬하여 출력
        Arrays.sort(result);
        for(int i=1; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void dfs(int i, int j) {
        map[i][j] = count; // 방문한 집 표시
        visit[i][j] = true;

        // 상하좌우로 이동하며 탐색
        for(int k=0; k<x.length; k++) {
            int ix = i + x[k];
            int jy = j + y[k];

            // 배열의 범위를 벗어나지 않는 범위 내에서 탐색
            if(ix >= 0 && ix < N && jy >= 0 && jy < N) {
                if(map[ix][jy] == 1 && !visit[ix][jy]) { // 집이 있으면서 방문하지 않은 곳
                    dfs(ix, jy); // 연결 되어있는 단지 탐색
                }
            }
        }
    }
}
