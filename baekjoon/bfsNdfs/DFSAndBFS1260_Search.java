package self.baekjoon.bfsNdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSAndBFS1260_Search {
    // platform | Baekjoon
    // number   | 1260
    // title    | DFS와 BFS
    // level    | Silver 2
    // how      |
    // etc      |
    static ArrayList<Integer>[] A;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 정점의 개수 N(1 ≤ N ≤ 1,000)
        int N = Integer.parseInt(st.nextToken());
        // 간선의 개수 M(1 ≤ M ≤ 10,000)
        int M = Integer.parseInt(st.nextToken());
        // 탐색을 시작할 정점의 번호
        int V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
        DFS(V);

        //방문 배열 초기화
        System.out.println();
        visited = new boolean[N + 1];
        BFS(V);
    }

     static void DFS(int v) {
        if(visited[v])
            return;

        System.out.print(v + " ");
        visited[v] = true;

        for(int i : A[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    // BFS 구현
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            System.out.print(now_node + " ");
            for (int i : A[now_node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
