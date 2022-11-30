package self.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
platform | Baekjoon
number   | 2258
title    | 정육점
level    | Gold 4
how      | greedy
etc      | PriorityQueue
 */
public class ButcherShop2258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        PriorityQueue<info> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new info(cost, weight));
        }

        boolean isTrue = false;
        int wholeCost = 0;
        long wholeWeight = 0;

        int saveBeforeCost = -1;
        int sameCost = 0;

        int answer = Integer.MAX_VALUE;

        while(!pq.isEmpty()){
            info info = pq.poll();
            int weight = info.weight;
            int cost = info.cost;
            if(saveBeforeCost != cost){
                saveBeforeCost = cost;
                sameCost = 0;
            }else{
                sameCost += cost;
            }

            wholeWeight += weight;
            wholeCost = cost;

            if(wholeWeight >= M){
                isTrue = true;
                answer = Math.min(answer, wholeCost + sameCost);
            }
        }
        if(isTrue) {
            System.out.println(answer);
        }
        else System.out.println(-1);
    }

}
class info implements Comparable<info>{
    int cost;
    int weight;

    info(int cost, int weight){
        this.cost = cost;
        this.weight = weight;
    }

    @Override
    public int compareTo(info o) {
        if(this.cost == o.cost) return o.weight - this.weight;
        return this.cost - o.cost;
    }
}