package self.baekjoon.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// platform | Baekjoon
// number   | 1929
// title    | 소수 구하기
// level    | Silver 3
// how      | Number Theory
// etc      | 에라토스테네스의 체
public class FindPrimeNumber1929_Eratos {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        prime = new boolean[N + 1];
        getPrime();

        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; i++) {
            if(!prime[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

        sb.setLength(0);
        br.close();
    }

    static void getPrime() {
        // true : 소수아님, false; 소수
        prime[0] = prime[1] = true;

        for(int i=2; i<=Math.sqrt(prime.length); i++) {
            for(int j=i*i; j<prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
}