package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewelry {
    int mass;
    int value;

    public Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}
public class JewelryThief1202_PriorityQueue {

    // 백준 1202번
    // 보석 도둑
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // N : 보석의 총 갯수.
        int N = Integer.parseInt(st.nextToken());
        // K : 가방의 갯수.
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[N];
        int[] bagsArr = new int[K];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // M : 보석의 무게
            int M = Integer.parseInt(st.nextToken());
            // V : 보석의 가격
            int V = Integer.parseInt(st.nextToken());
            jewelries[i] = new Jewelry(M, V);
        }

        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.mass == o2.mass) {
                    return o2.value - o1.value;
                }
                return o1.mass - o2.mass;
            }
        });

        for(int i=0; i<K; i++) {
            // C : 가방의 무게
            bagsArr[i] = Integer.parseInt(br.readLine());
        }

        // 가방의 무게를 오름차순 정렬
        Arrays.sort(bagsArr);

        long answer = 0L;
        // PriorityQueue 우선순위 큐
        // 일반적인 큐의 구조 FIFO(First In First Out)를 가지면서,
        // 데이터가 들어온 순서대로 데이터가 나가는 것이 아닌
        // 우선순위를 먼저 결정하고 그 우선순위가 높은 데이터가 먼저 나가는 자료구조
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // 높은 숫자가 우선 순위
        for(int i=0, j=0; i<K; i++) {
            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣는다.
            while(j < N && jewelries[j].mass <= bagsArr[i]) {
                pq.offer(jewelries[j++].value);
            }

            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer + "\n");
        br.close();
    }
}