package self.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class LecturingTour2109_Comparator {

    // 백준 2109번
    // 순회강연
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        // N : 강연 요청 갯수(0 ≤ n ≤ 10,000)
        int N = Integer.parseInt(br.readLine());

        int[][] classes = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            classes[i][0] = Integer.parseInt(st.nextToken());
            classes[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(classes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] == o1[0]) {
                    // 이동 소요일수 오름차순
                    return o1[1] - o2[1];
                }
                // 가격 내림차순
                return o2[0] - o1[0];
            }
        });

        int sum = 0;

        boolean[] check = new boolean[10001];
        for(int i=0; i<N; i++) {
            // 비용에 해당하는 날짜를 D라고 하자.
            // D일부터 1일까지 역순으로 해당 비용을 받는 강연 스케줄이 들어갈
            // 자리가 있는지 확인한다.
            for (int j = classes[i][1]; j >= 1; j--) {
                if(!check[j]) {
                    check[j] = true;
                    sum += classes[i][0];
                    break;
                }
            }
        }

        System.out.println(sum);

        br.close();
    }
}