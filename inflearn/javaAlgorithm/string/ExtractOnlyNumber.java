package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9. 숫자만 추출
// input  : g0en2T0s8eSoft
// output : 208
public class ExtractOnlyNumber {
    public int solution(String s) {
        int answer = 0;
        for(char x : s.toCharArray()) {
            if(x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        ExtractOnlyNumber fs = new ExtractOnlyNumber();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(fs.solution(str));
    }
}
