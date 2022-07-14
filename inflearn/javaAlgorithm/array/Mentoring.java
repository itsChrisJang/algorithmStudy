package self.inflearn.javaAlgorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
platform | inflearn java
number   | 12
title    | 멘토링
how      |
etc      |
 */
public class Mentoring {
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                int cnt = 0;
                for(int k=0; k<m; k++) {
                    int pi = 0, pj = 0;
                    for(int s=0; s<n; s++) {
                        if(arr[k][s] == i) pi=s;
                        if(arr[k][s] == j) pj=s;
                    }
                    if(pi < pj) cnt++;
                }
                if(cnt == m) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Mentoring fs = new Mentoring();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][6];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(fs.solution(n, m, arr));

    }
}
