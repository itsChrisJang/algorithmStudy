package self.codingTest.kakaoBank.test20220319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int[] answer = {};
    static int suc = 0;
    static int fail = 0;

    public int[] solution(int money, int limit) {
        divide(limit, money, 0, 0);

        answer = new int[2];
        answer[0] = suc;
        answer[1] = fail;
        System.out.println(answer);
        return answer;
    }

    public static void divide(int tryAmt, int remain, int index, int beforeFlag){
        // 시도 금액이 클 경우
        if(tryAmt > remain){
            fail++;
            if(tryAmt == 1){
                return;
            }
            tryAmt = tryAmt/2;
            divide(tryAmt, remain, index+1, 0);
        // 잔액이 크거나 같은 경우
        } else{
            suc++;
            remain = remain - tryAmt;

            // 첫 송금 성공
            if(index == 0){
                return;
            }
            // 두번 연속 성공
            if(beforeFlag == 1){
                return;
            }
            divide(tryAmt, remain, index+1, 1);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ", ");

        int money = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        Solution sl = new Solution();

        sl.solution(money, limit);
    }
}