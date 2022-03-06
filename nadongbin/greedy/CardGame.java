package feb20;

import java.util.Scanner;
public class CardGame {

    // 그리디 알고리즘
    // 이코테) 숫자 카드 게임
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        int row = sc.nextInt();
        int col = sc.nextInt();
        int result = 0;

        // 한 줄씩 입력 받아 확인하기
        for(int i=0;i<row;i++) {
            // 현재 줄에서 '가장 작은 수' 찾기
            int min_value = 10001;
            for(int k=0;k<col;k++) {
                int v = sc.nextInt();
                min_value = Math.min(min_value, v);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }

        System.out.println(result);
    }
}
