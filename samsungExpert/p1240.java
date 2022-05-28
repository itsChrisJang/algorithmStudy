package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// platform | SW Expert Academy
// number   | 1240
// title    | [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
// level    | D3
// how      |
// etc      |
// result   | 
public class p1240 {
    static String[] pwdCode = { "0001101", "0011001", "0010011", "0111101",
            "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] arr;
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine()," ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String code = "";
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                if(code.isEmpty()) {
                    for(int j=M-1; j>=0; j--) {
                        if(s.charAt(j) == '1') {
                            code = s.substring(j-55, j+1);
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + isValid(code));
        }
    }

    public static int[] toNum(String s) {
        int num[] = new int[8];
        int idx = 0;
        for (int i = 0; i < s.length(); i += 7) {
            String tmp = s.substring(i, i + 7);
            for (int j = 0; j < pwdCode.length; j++) {
                if (tmp.equals(pwdCode[j])) {
                    num[idx++] = j;
                    break;
                }
            }
        }
        return num;
    }

    public static int isValid(String code) {
        int num[] = toNum(code);
        int sum = 0;
        int total = 0;

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            if (i % 2 == 0) total += 3 * num[i];
            else total += num[i];
        }

        if (total % 10 == 0)
            return sum;
        return 0;
    }
}
