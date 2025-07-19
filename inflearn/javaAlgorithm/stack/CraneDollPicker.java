package self.inflearn.javaAlgorithm.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

// 3. 크레인 인형뽑기(카카오)
// Time Complexity : O(m×n)
public class CraneDollPicker {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int pos : moves) {
            for (int i=0; i<board.length; i++) {
                int pickedDoll = board[i][pos-1];
                if (pickedDoll != 0) {
                    board[i][pos-1] = 0;

                    if(!stack.isEmpty() && stack.peek().equals(pickedDoll)) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(pickedDoll);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        CraneDollPicker craneDollPicker = new CraneDollPicker();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i=0; i<m; i++) moves[i] = kb.nextInt();

        System.out.println(craneDollPicker.solution(board, moves));
    }
}
