package self.samsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// platform | SW Expert Academy
// number   | 1206
// title    | [S/W 문제해결 기본] 1일차 - View
// level    | D3
// how      |
// etc      |
// result   | 
public class p1206 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());
            System.out.print("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 한층씩 판별
            arr = new int[T+4];

            int idx = 0;
            while(st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            // n이 n-2 ~ n+2 큰지 판별, 크면 cnt++;
            for(int i=2; i<T+2; i++){
                cnt += check(i);
            }

            System.out.println(cnt);
        }
    }

    static int check(int idx){
        int b2 = arr[idx] - arr[idx-2];
        int b1 = arr[idx] - arr[idx-1];
        int f2 = arr[idx] - arr[idx+2];
        int f1 = arr[idx] - arr[idx+1];
        int min = Math.min(b2,Math.min(b1,Math.min(f2,f1)));
        if(min > 0) {
            return min;
        }else {
            return 0;
        }
    }
}
