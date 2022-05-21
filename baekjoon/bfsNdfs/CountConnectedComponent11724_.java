package self.baekjoon.bfsNdfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CountConnectedComponent11724_ {
    // platform | Baekjoon
    // number   | 11724
    // title    | 연결 요소의 개수
    // level    | Silver 2
    // how      | DFS
    // etc      |
    static ArrayList<Integer>[] A;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i=1; i<N+1; i++) {      // 인접리스트 초기화
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            // 양방향 에지이므로 양쪽에 에지를 더한다.
            A[S].add(E);
            A[E].add(S);
        }

        int count = 0;
        for(int i=1; i<N+1; i++) {
            if(!visited[i]){    // 방문하지 않은 노드가 없을때까지 반복하기
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    static void DFS(int v) {
        if(visited[v]){
            return;
        }
        visited[v] = true;

        for(int i : A[v]) {
            // 연결 노드 중 방문하지 않았던 노드만 탐색하기
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
