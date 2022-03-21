package self.inflearn.javaAlgorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3. 가위바위보
public class RockPaperScissors {
    public String solution(int n, int[] a, int[] b) {
        String answer = "";
        for(int i=0; i<n; i++) {
            if(a[i] == b[i]) answer += "D";
            else if(a[i] == 1 &&  b[i] == 3) answer += "A";
            else if(a[i] == 2 &&  b[i] == 1) answer += "A";
            else if(a[i] == 3 &&  b[i] == 2) answer += "A";
            else answer += "B";
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        RockPaperScissors fs = new RockPaperScissors();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st2.nextToken());
        }

        for(char x : fs.solution(n, a, b).toCharArray()) System.out.println(x);
    }
}
