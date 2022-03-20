package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3. 문장 속 단어(indexOf(), substring())
public class LongestWordInSentence {
    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");

        // 처음부터 for문으로 단순 비교하기
        for(String x : s) {
            int len = x.length();
            if(len > m) {
                m = len;
                answer = x;
            }
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
