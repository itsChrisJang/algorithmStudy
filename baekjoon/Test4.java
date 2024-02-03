package self.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test4 {


    public static void main(String[] args) throws IOException {
        int[] A = {1, 2, 4, 4, 3};
        int[] B = {2, 3, 1, 3, 1};
        System.out.println(solution(4, A, B));
    }

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int targetVertex = 0;
    public static boolean solution(int N, int[] A, int[] B) {
        // DFS
        // 1. 그래프 그린다.
        for(int i=0; i<A.length; i++) {
            // 점마다 연결된 것들 부여한다.
            graph.computeIfAbsent(A[i], integer -> new ArrayList<>()).add(B[i]);
            graph.computeIfAbsent(B[i], integer -> new ArrayList<>()).add(A[i]);
        }
        // 탐색 범위 정의
        targetVertex = N;

        Set<Integer> visited = new HashSet<>();
        return dfs(1, 2, visited);
    }

    private static boolean dfs(int currentVertex, int next, Set<Integer> visited) {
        // 1부터 N까지 온 경우
        if (currentVertex == targetVertex) {
            return true;
        }
        visited.add(currentVertex);

        // 현재 꼭지점과 연결된 정보 가져오기
        List<Integer> connectedVertexs = graph.getOrDefault(currentVertex, new ArrayList<>());
        // 해당 꼭지점에서 가야할 방향 연결되어 있는지 확인
        if (connectedVertexs.contains(next)) {
            return dfs(next, next+1, visited);
        }

        visited.remove(currentVertex);
        return false;
    }

}
