package self.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// platform | Baekjoon
// number   | 1541
// title    | 잃어버린 괄호
// level    | Silver 2
// how      | Greedy
// etc      | 단순 구현
public class LoseBracket1541_Simple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] str = input.split("-");

        int answer = 0;
        for(int i=0; i<str.length; i++) {
            String s = str[i];
            if(i == 0){
                answer = answer + sum(s);
            }else{
                answer = answer - sum(s);
            }
        }
        System.out.println(answer);

        br.close();
    }

    static int sum(String a) {
        int sum = 0;

        if(a.indexOf("+") > 0) {
            String[] str = a.split("[+]");
            for(int i=0; i<str.length; i++){
                sum += Integer.parseInt(str[i]);
            }
        }else {
            sum = Integer.parseInt(a);
        }

        return sum;
    }
}