package self.baekjoon.bfsNdfs;

import java.util.Scanner;

/*
platform | Baekjoon
number   | 2178
title    | 미로
level    | Silver 1
how      | BFS
etc      |
 */
class Dot {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Maze2178 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int N;
    static int M;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j)-'0';
                visited[i][j] = false;
            }
        }
        visited[0][0] = true;
        BFS(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }

    static public void BFS(int x, int y) {

        Queue<Dot> q = new LinkedList<Dot>();
        q.add(new Dot(x, y));
        //큐가 끝날때 까지
        while (!q.isEmpty()) {
            Dot d = q.poll();
            for (int i = 0; i < 4; i++) {
                //다음 방문할 좌표 nextX, nextY
                int nextX = d.x + dx[i];
                int nextY = d.y + dy[i];

                //다음 좌표가 범위를 넘어갈때 건너뛰기
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                //이미 방문했던 점이면 건너뛰기
                if (visited[nextX][nextY] || arr[nextX][nextY] == 0) {
                    continue;
                }
                //다음에 방문할 좌표를 큐에 넣는다.
                q.add(new Dot(nextX, nextY));
                //배열안에 다음 방문할 곳은 현재 방문했던 점보다 1칸 더 가야하므로 +1
                arr[nextX][nextY] = arr[d.x][d.y] + 1;
                //다음 좌표는 방문했음으로 표시
                visited[nextX][nextY] = true;
            }
        }
    }
}