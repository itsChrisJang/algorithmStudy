package self.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SNS2533_DPAndTree {
    // platform | Baekjoon
    // number   | 2533
    // title    | 사회망 서비스(SNS)
    // level    | Gold 3
    // how      | DP + Tree
    // etc      |
    static int n;
    static boolean[] visited;
    static Node[] tree;
    // dp : 해당 지점까지의 얼리어답터 인원수(트리 구조이기 때문에 자식 노드들의 dp개수를 더해온다)
    static int[][] dp;	// [y][x]일 때, y : 노드 번호, x : 0 -> 해당 노드번호가 earlyAdaptor가 아닐때, 1 -> 해당 노드번호가 earlyAdaptor일 때

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        tree = new Node[n + 1];
        StringTokenizer st;
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            tree[start] = new Node(end, tree[start]);
            tree[end] = new Node(start, tree[end]);
        }

        // 트리 구조이기 때문에 1부터 시작
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int number) {
        visited[number] = true;
        dp[number][0] = 0;
        dp[number][1] = 1;

        for(Node next = tree[number]; next != null; next = next.next) {
            if(!visited[next.n]) {	// dfs 중복 방문 방지(안해도되는데 확인해보기)
                dfs(next.n);	// dfs 재귀호출을 통해 자식 노드의 dp값을 미리 구한다.
                dp[number][0] += dp[next.n][1];	// 자식 노드가 무조건 얼리어답터여야한다.
                dp[number][1] += Math.min(dp[next.n][0], dp[next.n][1]);	// 왜냐하면 최소의 얼리어답터 인원을 뽑기 때문에 자식 노드가 얼리어답터 일수도, 아닐수도 있다.
            }
        }
    }
}

class Node {
    int n;
    Node next;

    public Node(int n, Node next) {
        this.n = n;
        this.next = next;
    }
}