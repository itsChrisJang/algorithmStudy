package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 6. 중복 문자 제거
public class RemovingDuplicatedString {
    public String solution(String str) {
        String answer = "";
        for(int i=0; i<str.length(); i++) {
            //중복 제거 확인 out
            //System.out.println(str.charAt(i) + " " + i + str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        RemovingDuplicatedString fs = new RemovingDuplicatedString();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(fs.solution(str));
    }
}
