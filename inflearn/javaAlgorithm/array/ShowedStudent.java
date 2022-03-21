package self.inflearn.javaAlgorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2. 보이는 학생
public class ShowedStudent {
    public int solution(int n, int[] arr) {
        int answer = 1, max = arr[0];
        for(int i=1; i<n; i++) {
            if(arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        ShowedStudent fs = new ShowedStudent();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(fs.solution(n, arr));
    }
}
