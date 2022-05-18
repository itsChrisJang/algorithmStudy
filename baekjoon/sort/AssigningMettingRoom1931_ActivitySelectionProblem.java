package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class AssigningMettingRoom1931_ActivitySelectionProblem {

    // 백준 1931번
    // 회의실 배정
    // 활동 선택 문제(Activity Selection problem)
    // 한 사람이 하나의 활동에 대해서만 작업할 수 있다
    // 즉, 하나의 활동을 선택하면 나머지 겹치지 않는 활동에 대해서 독립적이다.
    // 탐욕 선택이 이후의 결과에 영향을 미치지 않는다.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer st;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간을 기준으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간이 같을 경우 : 시작시간이 빠른순으로 정렬
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int previous_end_time = 0;

        for(int i=0; i<N; i++) {
            if(previous_end_time <= arr[i][0]) {
                previous_end_time = arr[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}