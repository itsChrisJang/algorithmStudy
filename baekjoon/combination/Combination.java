package self.baekjoon.combination;

/**
 * 조합 : n 개 중에서 r 개 선택
 * @author qiiop
 */
public class Combination {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];

       /* for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            comb(arr, visited, 0, n, i);
        }*/

        /*for (int i = 1; i <= n; i++) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination(arr, visited, 0, n, i);
        }*/
        System.out.println("\n" + 4 + " 개 중에서 " + 2 + " 개 뽑기");
        combination(arr, visited, 0, 4, 2);
    }

    // 백트래킹 사용
    // 백트래킹이란? 가능한 모든 방법을 탐색한다
    // 백트래킹은 현재 상태에서 가능한 모든 후보군을 따라 들어가며 해결책에 대한 후보를 구축해
    // 나아가다 가능성이 없다가 판단되면 즉시 후보를 포기하면서 정답을 찾아가는 범용적인 알고리즘이다.
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        System.out.println("r : " + r);
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        System.out.println("start : " + start);
        for (int i = start; i < n; i++) {
            System.out.println(" start : " + start  + ", i : " + i + ", r : " + r);
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            System.out.println();
            visited[i] = false;
        }
    }

    // 재귀 사용
    // 사용 예시 : comb(arr, visited, 0, n, r)
    static void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("i 번째 : " + visited[i] + ", ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}