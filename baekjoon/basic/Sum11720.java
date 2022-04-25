package self.baekjoon.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Sum11720 {

    // 백준 11720번
    // 숫자 합 구하기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();  // N 은 쓸모가 없으므로 입력만 받는다.

        int sum = 0;

        for(byte value : br.readLine().getBytes()) {
            sum += (value - '0');   // 또는 (a-48)
        }
        System.out.print(sum);
    }
}