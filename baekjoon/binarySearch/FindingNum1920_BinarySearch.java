package self.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// platform | Baekjoon
// number   | 1920
// title    | 수 찾기
// level    | Silver 4
// how      | Binary Search
// etc      |
public class FindingNum1920_BinarySearch {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열은 반드시 정렬되어있어야한다.
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int binarySearch(int key) {
        int start = 0;
        int end = A.length - 1;

        while(start <= end) {
            int middle = (start + end) / 2;

            if(key > A[middle]){
                start = middle + 1;
            }else if(key < A[middle]) {
                end = middle - 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

}
