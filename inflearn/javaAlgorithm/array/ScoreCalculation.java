package self.inflearn.javaAlgorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8. 등수구하기
// Input  : 5
//          87 89 92 100 76
// Output : 4 3 2 1 5
public class ScoreCalculation {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            int cnt = 1;
            for(int j=0; j<n; j++) {
                if(arr[j] > arr[i]) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        ScoreCalculation fs = new ScoreCalculation();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : fs.solution(n, arr)) System.out.print(x + " ");

    }
}
