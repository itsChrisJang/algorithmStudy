package self.baekjoon.combination;

/**
 * 조합 : n 개 중에서 r 개 선택
 * @author qiiop
 */
public class Combination2 {
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 7};
        boolean[] visited = new boolean[n];

        //사용 예시 :
        combination(arr, visited, 0, 4, 2);
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void print(int[] arr, boolean[] visited, int n) {
        int chk = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                chk = chk + arr[i];
            }
        }

        if(n == 4) {
            if(chk == 8) {
                System.out.println(true);
                return;
            }
            System.out.println(false);
        }
    }
}