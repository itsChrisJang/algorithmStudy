package self.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HappyKindergarden13164_ {

    // 백준 13164번
    // 행복 도서관
    // # 사람 수 - 그룹의 수 = diff(결합의 수)
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> diff = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken()); // 사람 인원 수
        int K = Integer.parseInt(st.nextToken()); // 그룹 수

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            al.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < al.size() - 1; i++){
            diff.add(al.get(i+1) - al.get(i)); //인접에 대한 차를 구함
        }

        Collections.sort(diff); // 오름차순

        int result = 0;

        for(int i = 0; i < N-K; i++){
            result += diff.get(i);
        }

        System.out.print(result);
    }
}