package self.inflearn.javaAlgorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9. 격자판 최대합
// Input  : 5
//          10 13 10 12 15
//          12 39 30 23 11
//          11 25 50 53 15
//          19 27 29 37 27
//          19 13 30 13 19
// Output : 155
public class PlaidMaximumSum {
    public int solution(int n, int[][] arr) {
        // ?
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;

        // 가로, 세로
        for(int i=0; i<n; i++) {
            sum1 = sum2 = 0;
            for(int j=0; j<n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        // 대각선
        sum1 = sum2 = 0;
        for(int i=0; i<n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        PlaidMaximumSum fs = new PlaidMaximumSum();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(fs.solution(n, arr));

    }
}
