package self.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// platform | Baekjoon
// number   | 1543
// title    | 문서 검색
// level    | Silver 4
// how      | greedy
// etc      |
public class DocumentSearching1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long cnt = 0;

        String doc = br.readLine();
        String srchDoc = br.readLine();

        boolean[] arr = new boolean[doc.length()];

        int docLength = doc.length();
        int srchLength = srchDoc.length();

        for(int i=0; i<doc.length(); i++) {
            if(docLength - srchLength >= i) {
                String str = doc.substring(i, i+srchLength);

                if(str.equals(srchDoc)) {
                    int start = i;
                    if(!arr[start]) {
                        cnt++;
                        for(int j = start; j<start+srchLength; j++) {
                            arr[j] = true;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }


}