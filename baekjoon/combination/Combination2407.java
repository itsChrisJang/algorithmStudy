package self.baekjoon.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Combination2407 {

    public static BigInteger dpCombi[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(str.nextToken());
        int m = Integer.parseInt(str.nextToken());

        dpCombi = new BigInteger[1001][1001];

        combination(n, m);

        System.out.println(dpCombi[n][m]);
    }

    static void combination(int n, int m) {
        for(int i=1;i<=n;i++){
            for(int j=0;j<=i;j++){
                if(j == 0 || j==i)
                    dpCombi[i][j] = new BigInteger("1");
                else
                    dpCombi[i][j] = dpCombi[i-1][j-1].add(dpCombi[i-1][j]);
            }
        }
    }
}