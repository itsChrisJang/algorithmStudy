package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 4. 단어 뒤집기(StringBuilder이용법 또는 직접뒤집기)
//reverse
public class FlipAWord {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        FlipAWord fs = new FlipAWord();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for(int i=0; i<n; i++) {
            str[i] = br.readLine();
        }

        for(String x : fs.solution(n, str)) {
            System.out.println(x);
        }
    }
}
