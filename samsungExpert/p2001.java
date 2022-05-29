package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// platform | SWEA
// number   | 2001
// title    | 파리 퇴치
// level    | D2
// how      |
// etc      |
// result   | 
public class p2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[][] arr;
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arr = new int[N+1][N+1];
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for(int i=0; i<N-M+1; i++) {
                for(int j=0; j<N-M+1; j++) {
                    int sum = 0;
                    for(int k=0; k<M; k++) {
                        for(int p=0; p<M; p++) {
                            sum += arr[i+k][j+p];
                        }
                        if(max < sum)
                            max = sum;
                    }
                }
            }

            System.out.println("#" + t + " " + max);
        }

    }

}
