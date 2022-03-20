package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 문자 찾기
public class FindingString {
    public int solution(String str, char t) {
        int answer = 0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        // for 문 이용;
        /*for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == t) answer++;
        }*/
        // for each
        for(char x : str.toCharArray()) {
            if(x==t) answer++;
        }

        return answer;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FindingString fs = new FindingString();

        String str = br.readLine();
        char c = br.readLine().charAt(0);


        System.out.println(fs.solution(str, c));
    }
}
