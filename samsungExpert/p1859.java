package self.samsungExpert;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// platform | SW Expert Academy
// number   | 1859
// title    | 백만 장자 프로젝트
// level    | D2
// how      |
// etc      |
// result   | 
public class p1859 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int[] pay = new int[n];
            for(int i=0; i<n; ++i) {
                pay[i] = sc.nextInt();
            }
            long sum = 0;
            int max = 0;

            for(int i=n-1; i>=0; --i) {
                if(max<pay[i]) {
                    max = pay[i];
                }
                else {
                    int mg = max - pay[i];
                    sum+=mg;
                }
            }
            System.out.printf("#%d %d%n", test_case, sum);
        }
    }
}
