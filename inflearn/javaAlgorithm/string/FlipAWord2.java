package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 4. 단어 뒤집기(StringBuilder이용법 또는 직접뒤집기)
// study => yduts
// 12345 => 1,5 변경/ 2,4 변경 / 3 변경
public class FlipAWord2 {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str){
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() - 1;
            while(lt<rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        FlipAWord2 fs = new FlipAWord2();

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
