package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 7. 회문문자열
public class PalindromeString {
    public String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        for(int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len - i -1)) return "NO";
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        PalindromeString fs = new PalindromeString();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(fs.solution(str));
    }
}
