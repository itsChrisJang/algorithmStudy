package self.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class MultipleNumber {
/*
platform | Programmers
number   |
title    | 나누어 떨어지는 숫자 배열
level    | level 1
how      |
etc      |
 */
    public static void main(String[] args) {
        int[] arr = {5, 9, 6,10};
        solution(arr, 5);
    }

    public static ArrayList solution(int[] arr, int divisor) {
        int j = 0;
        ArrayList answer = new ArrayList();
        System.out.println(arr.length);
        for(int i=0; i<arr.length; i++) {
            if(arr[i] % divisor == 0) {
                answer.add(arr[i]);
            }
        }

         if(j == 0) {
             answer.add(-1);
             return answer;
         }

        Collections.sort(answer);

        return answer;
    }
}
