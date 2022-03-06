package self.baekjoon.bfsNdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM15650 {

    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    // 백준 15650번
    // 백트래킹 > dfs 탐색방식
    // 백트래킹 란?
    // 해를 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해를 찾아가는 기법
    // 깊이 우선 탐색(DFS) 란?
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
        System.out.println(sb);

    }

    public static void dfs(int at, int depth) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {

            arr[depth] = i;
            dfs(i + 1, depth + 1);

        }
    }
}