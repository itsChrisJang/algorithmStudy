package self.inflearn.javaAlgorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5. 소수(에라토스테네스 체)
// 소수 구하는 방법론에서 제일 빠름.
// Input  : 20
// Output : 8
public class PrimeNumber {
    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n+1];

        for(int i=2; i<=n; i++) {
            if(ch[i] == 0) {
                answer++;
                for(int j=i; j<=n; j=j+i) ch[j]=1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        PrimeNumber fs = new PrimeNumber();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fs.solution(n));

    }
}
