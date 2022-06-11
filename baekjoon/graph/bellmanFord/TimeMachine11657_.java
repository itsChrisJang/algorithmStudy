package self.baekjoon.graph.bellmanFord;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// platform | Baekjoon
// number   | 1516
// title    | 게임 개발
// level    | Gold 4
// how      | Bellman-Ford Algorithm
// etc      |
// ※ 모든 간선의 비용이 양수일 때는 다익스트라
// ※ 음수 간선이 포함되어 있으면 벨만-포드를 사용하면 된다.
class City {
    int end;
    int weight;

    City(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
public class TimeMachine11657_ {
    static int N, M;
    static ArrayList<ArrayList<City>> a;
    static long[] dist; // 자료형을 int로 할 경우 오버플로우 발생함.
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st  = new StringTokenizer(br.readLine());
        // N : 도시의 개수 N (1 ≤ N ≤ 500)
        N = Integer.parseInt(st.nextToken());
        // M : 버스 노선의 개수 M (1 ≤ M ≤ 6,000)
        M = Integer.parseInt(st.nextToken());

        // 인접 리스트
        a = new ArrayList<>();
        // 최단거리 배열
        dist = new long[N + 1];

        for(int i=0; i<=M; i++){
            a.add(new ArrayList<>());
            dist[i] = INF;
        }

        // 단방향 인접리스트 구현
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            a.get(A).add(new City(B, C));
        }

        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i] + "\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bellmanFord() {
        dist[1] = 0; // 시작점은 0으로 초기화.
        boolean update = false;

        // (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
        for (int i = 1; i < N; i++) {
            update = false;

            // 최단거리 초기화.
            for (int j = 1; j <= N; j++) {
                for (City city : a.get(j)) {
                    if (dist[j] == INF) {
                        break;
                    }

                    if (dist[city.end] > dist[j] + city.weight) {
                        dist[city.end] = dist[j] + city.weight;
                        update = true;
                    }
                }
            }

            // 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료.
            if (!update) {
                break;
            }
        }

        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
        // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (City city : a.get(i)) {
                    if (dist[i] == INF) {
                        break;
                    }

                    if (dist[city.end] > dist[i] + city.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}