package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// platform | SW Expert Academy
// number   | 1244
// title    | [S/W 문제해결 응용] 2일차 - 최대 상금
// level    | D3
// how      |
// etc      | 다시 풀기
// result   | 
public class p1244 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] arr;
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            System.out.print("#" + t + " ");
            arr = st.nextToken().split("");
        }
    }
}
