package self.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Star2439{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++){
            int starLoc = n-i;
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<n; j++){
                if(starLoc <= j){
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}