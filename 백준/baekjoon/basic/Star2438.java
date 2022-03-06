package self.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star2438 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<i+1;j++){
                sb.append("*");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
