package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestWordInSentence {
    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;;
        String[] s = str.split(" ");

        /*
         * 처음부터 for문으로 단순 비교하기
        for(String x : s) {
            int len = x.length();
            if(len > m) {
                m = len;
                answer = x;
            }
        }*/

        while((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            // len >= m 이면 동일한 length시에 뒤에껄로 초기화 됨.
            if(len > m) {
                m = len;
                answer = tmp;
            }
            if(str.length() > m) answer = str;
            str = str.substring(pos + 1);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        LongestWordInSentence fs = new LongestWordInSentence();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(fs.solution(str));
    }
}
