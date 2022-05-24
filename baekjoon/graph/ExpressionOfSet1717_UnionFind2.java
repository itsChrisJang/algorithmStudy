package self.baekjoon.graph;

import java.io.*;
import java.util.StringTokenizer;

// platform | Baekjoon
// number   | 1717
// title    | 집합의 표현
// level    | Gold 4
// how      | Graph
// etc      | https://brenden.tistory.com/33
public class ExpressionOfSet1717_UnionFind2 {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i < N+1; i++) {     // 대표 노드 초기화
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){             // 질의 계산하는 부분.
            st = new StringTokenizer(br.readLine(), " ");
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(question == 0) {              // union
                union(a, b);
            }else if(question == 1) {        // 두원소 같은지 보기
                sb.append((checkSame(a, b) ? "YES" : "NO") + "\n");
            }else{
                continue;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // x의 부모를 찾는 연산
    static int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);     // value를 index로 바꿔서 또 찾아보기
    }

    // y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b)
            parent[b] = a;

    }

    // x와 y의 부모가 같은지 확인
    static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b)  return true;

        return false;
    }
}