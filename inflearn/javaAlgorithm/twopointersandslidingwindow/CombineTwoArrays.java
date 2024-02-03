package self.inflearn.javaAlgorithm.twopointersandslidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1. 두 배열 합치기(two pointers algorithm)
// Time Complexity : O(nlogn)
public class CombineTwoArrays {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();

        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if(a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while (p1 < n) answer.add(a[p1++]);
        while (p2 < m) answer.add(b[p2++]);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        CombineTwoArrays combineTwoArrays = new CombineTwoArrays();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] a = new int[n];
        st = new StringTokenizer(str, " ");

        int i = 0;
        while(st.hasMoreTokens()) {
            a[i++] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        String str2 = br.readLine();
        int[] b = new int[m];
        st = new StringTokenizer(str2, " ");

        i = 0;
        while(st.hasMoreTokens()) {
            b[i++] = Integer.parseInt(st.nextToken());
        }

        System.out.println(combineTwoArrays.solution(n, m,  a, b));
    }
}
