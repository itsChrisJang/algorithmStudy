package self.baekjoon.dp;

import java.io.*;
import java.util.*;

// platform | Baekjoon
// number   | 1516
// title    | 게임 개발
// level    | Gold 3
// how      | Dp
// etc      | https://steady-coding.tistory.com/86
public class GameDeveloping1516_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb;

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        for(int i=0; i<=N; i++){
            a.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1]; // 특정 건물을 짓기 전에 먼저 지어야 할 건물의 개수
        int[] times = new int[N + 1]; // 특정 건물을 짓는 데 걸리는 시간

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());

                if (num == -1) {
                    break;
                }

                a.get(num).add(i);

                indegree[i]++;
            }
        }

        String ans = topologicalSort(a, indegree, times, N);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 위상 정렬
    public static String topologicalSort(ArrayList<ArrayList<Integer>> a, int[] indegree, int[] times, int N) {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        // 먼저 지어야할 건물이 없는 건물을 큐에 집어 넣음.
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // 특정 건물을 짓기 전까지 걸린 시간
        int[] result = new int[N + 1];

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : a.get(now)) {
                indegree[next]--;

                // next 건물을 짓기 전까지 걸린 시간 계산.
                result[next] = Math.max(result[next], result[now] + times[now]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // 특정 건물을 짓는 데 걸린 시간을 출력.
        for (int i = 1; i <= N; i++) {
            sb.append((result[i] + times[i]) + "\n");
        }

        return sb.toString();
    }
}