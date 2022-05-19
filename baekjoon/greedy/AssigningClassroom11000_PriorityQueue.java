package self.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AssigningClassroom11000_PriorityQueue {

    // 백준 11000번
    // 강의실 배정
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N : 강의 갯수
        int N = Integer.parseInt(br.readLine());

        int[][] classes = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            classes[i][0] = Integer.parseInt(st.nextToken());
            classes[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(classes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 오름차순 정렬
                return o1[0] - o2[0];
            }
        });
        // Arrays.sort(classes, (o1, o2) -> o1[0] == o2[1] ? o1[1] - o1[1] : o1[0] - o1[01]);

        // 우선순위 큐에는 종료 시간만 들어가며, 오름차순으로 자동 정렬된다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(classes[0][1]);

        for(int i=1; i<N; i++) {
            // 시작 시간이 앞전 수업의 종료시간 보다 빠를때.
            if(pq.peek() <= classes[i][0])          // peek() : 큐의 처음에 있는 원소를 삭제하지 않고 가져온다.
                pq.poll();                          // poll() : 큐의 처음에 있는 원소를 가져오고 제거

            pq.add(classes[i][1]);
        }

        System.out.println(pq.size());
        br.close();
    }
}