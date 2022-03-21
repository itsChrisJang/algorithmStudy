package self.inflearn.javaAlgorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4. 피보나치 수열
//    배열쓰지 않고 해결
public class Fibonacci2 {
    int first = 1;
    public void solution(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i=2; i<n; i++) {
            c = a + b;
            System.out.print(c+ " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) throws IOException {
        Fibonacci2 fs = new Fibonacci2();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        fs.solution(n);
    }
}
