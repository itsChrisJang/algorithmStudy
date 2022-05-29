package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// platform | SWEA
// number   | 1984
// title    | 중간 평균값 구하기
// level    | D2
// how      |
// etc      |
// result   | 
public class p1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[] arr;
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            int max = 0;
            int min = 0;
            for(int i=0; i<10; i++) {
                int val = Integer.parseInt(st.nextToken());
                if(val >= max) {
                    max = val;
                }

                if(i == 0) min = val;

                if(val <= min) {
                    min = val;
                }
                sum += val;
            }

            sum = sum - max - min;
            double d = sum/(double) 8;
            System.out.println("#" + t + " " + Math.round(d));
        }

    }

}
