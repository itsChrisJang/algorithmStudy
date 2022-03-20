package self.inflearn.javaAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11. 문자열 압축
// input  : KKHSSSSSSSE
// output : K2HS7E
// input  : KSTTTSEEKFKKKDJJGG
// output : KST3SE2KFK3DJ2G2
public class CompressString {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer();

        s = s + " ";
        char before = s.charAt(0);
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == before) {
                cnt++;
            }else if(c != before){
                sb.append(String.valueOf(before));
                if(cnt > 1) {
                    sb.append(String.valueOf(cnt));
                }
                cnt = 1;
                before = c;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        CompressString fs = new CompressString();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(fs.solution(str));
    }
}
