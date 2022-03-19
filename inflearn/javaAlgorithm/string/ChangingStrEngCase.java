package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangingStrEngCase {
    public String solution(String str) {
        String answer = "";
        for(char x : str.toCharArray()) {
            /*
             * 단순 is메서드 사용.
                if(Character.isLowerCase(x)) answer += Character.toUpperCase(x);
                else answer += Character.toLowerCase(x);
            */

            // ASCII로 구현 소문자 65 ~ 90 대문자 97 ~ 122 / 대소문자 차이 32
            if(x >= 97 && x <= 122) answer += (char)(x-32);
            else answer += (char)(x+32);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        ChangingStrEngCase fs = new ChangingStrEngCase();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(fs.solution(str));
    }
}
