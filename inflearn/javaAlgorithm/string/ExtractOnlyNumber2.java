package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9. 숫자만 추출
// input  : g0en2T0s8eSoft
// output : 208
public class ExtractOnlyNumber2 {
    public int solution(String s) {
        String answer = "";
        for(char x : s.toCharArray()) {
            // Character.isDigit(x)
            // : 명시된 char x 값이 숫자인지 판단하여 true/false
            if(Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) throws IOException {
        ExtractOnlyNumber2 fs = new ExtractOnlyNumber2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(fs.solution(str));
    }
}
