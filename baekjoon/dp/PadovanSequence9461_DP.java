package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// platform | Baekjoon
// number   | 9461
// title    | 파도반 수열
// level    | Siver 3
// how      | DP
//          | Func(N) = Func(N-2) + Func(N-3)
// etc      |
public class PadovanSequence9461_DP {
    public static Long[] seq = new Long[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        seq[0] = 0L;
        seq[1] = 1L;
        seq[2] = 1L;
        seq[3] = 1L;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            sb.append(padovan(Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.println(sb);
    }

    public static long padovan(int N) {
        if(seq[N] == null) {
            seq[N] = padovan(N - 2) + padovan(N - 3);
        }
        return seq[N];
    }
}