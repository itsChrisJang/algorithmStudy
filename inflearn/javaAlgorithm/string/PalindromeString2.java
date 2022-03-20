package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 7. 회문문자열
public class PalindromeString2 {
    public String solution(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        // "".equalsIgnoreCase("") 대소문자 상관없이 같은 경우.
        if(str.equalsIgnoreCase(tmp)) answer = "YES";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        PalindromeString2 fs = new PalindromeString2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(fs.solution(str));
    }
}
