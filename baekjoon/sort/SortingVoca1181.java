package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class SortingVoca1181 {

    // 백준 1181번
    // 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
    // 1. 길이가 짧은 것부터
    // 2. 길이가 같으면 사전 순으로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String[] arr = new String[num];

        for(int i =  0 ; i < num ; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
            if(s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }else {
                return s1.length() - s2.length();
            }

        }
        });

        System.out.println(arr[0]);
        for(int i = 1; i < num; i++) {
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }
    }
}
/*
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        String[] arr = new String[N];

        in.nextLine();  // 개행 버림

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                // 단어 길이가 같을 경우
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                // 그 외의 경우
                else {
                    return s1.length() - s2.length();
                }
            }
        });


        System.out.println(arr[0]);

        for (int i = 1; i < N; i++) {
            // 중복되지 않는 단어만 출력
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }
    }

}

*********************************************************************************************

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        String temp = "";
        for(int i = 0; i<arr.length; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        Arrays.sort(arr, Comparator.comparing(String::length));
        for(int i = 0; i<arr.length; i++) {
            if(temp.equals(arr[i])) {
                continue;
            }
            else {
                System.out.println(arr[i]);
                temp = arr[i];
            }
        }
    }
}

 */
