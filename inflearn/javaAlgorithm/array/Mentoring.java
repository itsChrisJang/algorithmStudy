package self.inflearn.javaAlgorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12. 멘토링
// Input  : 5
//          2 3 1 7 3
//          4 1 9 6 8
//          5 5 2 4 4
//          6 5 2 6 7
//          8 4 2 2 2
// Output : 4
public class Mentoring {
    public int solution(int n, int[][] arr) {
        int answer = 0, max=Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) {
            int cnt=0;
            for(int j=1; j<=n; j++) {
                for(int k=1; k<5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Mentoring fs = new Mentoring();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][6];
        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(fs.solution(n, arr));

    }
}
