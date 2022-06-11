package self.baekjoon.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// platform | Baekjoon
// number   | 2042
// title    | 구간 합 구하기
// level    | Gold 1
// how      | implementation
// etc      |
// result   | 
public class PermutationSequence1722_ {
    static int[] perm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        perm = new int[N+1];
        for(int i=0; i<N; i++) {
            perm[i] = i+1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int problem = Integer.parseInt(st.nextToken());
        if(problem == 1) {
            permutation(perm, 0, N, 4);
        }else if(problem == 2) {
            permutation(perm, 0, N, 4);
        }


        br.close();
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    // 배열 출력
    static void print(int[] arr, int r) {
        for (int i = 0; i <r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
