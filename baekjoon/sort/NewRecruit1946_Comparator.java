package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NewRecruit1946_Comparator {

    // 백준 1946번
    // 신입사원
    // Comparator 사용.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int N = 0;
        int[][] caseArr = null;

        StringTokenizer st;

        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            caseArr = new int[N][2];

            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                caseArr[j][0] = Integer.parseInt(st.nextToken());
                caseArr[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(caseArr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // 오름차순 정렬
                    return o1[1] - o2[1];
                }
            });

            int precious_rank = caseArr[0][0];
            int cnt = 1;
            for(int k=1; k<N; k++) {
                if(precious_rank > caseArr[k][0]) {
                    precious_rank = caseArr[k][0];
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}