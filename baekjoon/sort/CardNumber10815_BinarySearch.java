package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// platform | Baekjoon
// number   | 10815
// title    | 숫자 카드
// level    | Siver 4
// how      | BinarySearch
// etc      |
public class CardNumber10815_BinarySearch {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간을 기준으로 정렬
        Arrays.sort(arr);


        int M =Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            System.out.print(binarySearch(arr, N, temp) + " ");
        }
    }

    static int binarySearch(int[] cards, int N, int search) {
        int from = 0;
        int to = N - 1;
        int mid = 0;

        while(from <= to){
            // 중간 인덱스
            mid = (from + to) / 2;

            if(cards[mid] == search){
                return 1;
            }

            if(cards[mid] > search){
                to = mid - 1;
            }else {
                from = mid + 1;
            }
        }

        return 0;
    }
}