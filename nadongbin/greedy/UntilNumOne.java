package self.nadongbin.greedy;

import java.util.Scanner;

public class UntilNumOne {

    // 그리디 알고리즘
    // 이코테) 1이 될 때까지
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;

        while(n >= k) {
            while(n % k != 0) {
                n = n-1;
                cnt++;
            }
            n = n / k;
            cnt++;
        }

        while(n > 1) {
            n = n-1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
