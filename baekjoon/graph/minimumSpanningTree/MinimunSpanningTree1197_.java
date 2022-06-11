package self.baekjoon.graph.minimumSpanningTree;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// platform | Baekjoon
// number   | 1197
// title    | 최소 스패닝 트리
// level    | Gold 4
// how      | Minimun Spanning Tree
// etc      |
public class MinimunSpanningTree1197_ {
    static int[] parent;
    static PriorityQueue<pEdge> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        // N : 정점의 개수 (1 ≤ N ≤ 10,000)
        int N = Integer.parseInt(st.nextToken());
        // M : 간선의 개수 (1 ≤ M ≤ 100,000)
        int M = Integer.parseInt(st.nextToken());

        queue = new PriorityQueue<>();
        parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        // 단방향 인접리스트 구현
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            queue.add(new pEdge(s, e, v));
        }

        int useEdge = 0;
        int result = 0;
        while (useEdge < N - 1) {
            pEdge now = queue.poll();
            if (find(now.s) != find(now.e)) // 같은 부모가 아니라면 -> 연결해도 싸이클이 생기지 않는다면
            {
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }

        System.out.println(result);
        br.close();
    }

    public static void union(int a, int b) { // union 연산 : 대표 노드끼리 연결하여 줌
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    public static int find(int a) { // find 연산
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]); // 재귀함수의 형태로 구현 -> 경로 압축 부분
    }
}

class pEdge implements Comparable<pEdge> {
    int s;
    int e;
    int v;
    pEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(pEdge o) {
        // TODO Auto-generated method stub
        return this.v - o.v;
    }
}