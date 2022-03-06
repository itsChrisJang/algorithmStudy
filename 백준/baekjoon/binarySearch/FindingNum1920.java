package self.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindingNum1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        //배열은 정렬이 원칙.
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<m; i++) {
            if(Arrays.binarySearch(a, Integer.parseInt(st.nextToken())) >= 0) {
                sb.append("1").append("\n");
            }else {
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb);
        sb.setLength(0);
    }
}
