package self.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
platform | Baekjoon
number   | 2751
title    | 수 정렬하기 2
level    | Siver 5
how      | CollectionsSort
etc      | arrays.sort()를 사용시에 시간 복잡도가 O(n^2)이 될 수 있다. => 시간초과
 */
public class SortingNumber2751_CollectionsSort {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for(int i=0; i<N; i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}