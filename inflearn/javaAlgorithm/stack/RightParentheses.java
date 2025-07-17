package self.inflearn.javaAlgorithm.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

// 1. 올바른 괄호
// Time Complexity : O(n)
public class RightParentheses {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {

            if (x == '(') stack.push(x);
            else {
                if (stack.isEmpty()) return "NO";
                else stack.pop();
            }
        }

        if (!stack.isEmpty()) return "NO";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        RightParentheses rightParentheses = new RightParentheses();

        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(rightParentheses.solution(str));
    }
}
