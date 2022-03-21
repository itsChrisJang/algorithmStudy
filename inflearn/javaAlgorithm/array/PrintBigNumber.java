package self.inflearn.javaAlgorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1. 큰 수 출력하기
public class PrintBigNumber {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for(int i=1; i<n; i++) {
            if(arr[i] > arr[i-1]) answer.add(arr[i]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        PrintBigNumber fs = new PrintBigNumber();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : fs.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
