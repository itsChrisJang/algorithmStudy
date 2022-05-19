package self.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PowerStripScheduling1700 {

    // 백준 1700번
    // 멀티탭 스케줄링
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // N : 멀티탭 구멍의 개수(1 ≤ N ≤ 100)
        int N = Integer.parseInt(st.nextToken());
        // K : 전기 용품의 총 사용횟수 (1 ≤ K ≤ 100)
        int K = Integer.parseInt(st.nextToken());

        int[] order = new int[K];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        // 콘센트 사용 여부.
        boolean[] use = new boolean[101];
        int put = 0;
        int ans = 0;
        for(int i=0; i<K; i++) {
            int temp = order[i];

            if(!use[temp]) {    // 콘센트가 꽂혀 있지 않은 경우/ use => false
                if(put < N) {   // 콘센트를 꽂을 공간이 있는 경우
                    use[temp] = true;
                    put++;
                }else {         // 콘센트를 꽂을 공간이 없는 경우
                    ArrayList<Integer> arrList = new ArrayList<>();
                    for(int j=i; j<K; j++){  //현재 꽂혀 있는 콘센트가 나중에도 사용되는지 체크
                        if(use[order[j]] && !arrList.contains(order[j])) {
                            arrList.add(order[j]);
                        }
                    }

                    if(arrList.size() != N) {   // 나중에도 사용되는 콘센트가 구멍의 개수보다 작을 경우.
                        for(int j=0; j<use.length; j++) {
                            if(use[j] && !arrList.contains(j)) {    // 그 콘센트를 제거한다.
                                use[j] = false;
                                break;
                            }
                        }
                    }else {                     //현재 꽂혀 있는 모든 콘센트가 나중에도 사용될 경우
                        int remove = arrList.get(arrList.size() - 1);   // 가장 마지막에 사용될 콘센트를 제거.
                        use[remove] = false;
                    }

                    use[temp] = true;
                    ans++;
                }
            }
        }

        System.out.println(ans);

        br.close();
    }
}