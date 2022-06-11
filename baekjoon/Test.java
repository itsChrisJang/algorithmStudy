package self.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int solution(String[] before, String[] after) {
        int answer = -1;
        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String str1 = str.substring(0, str.indexOf("]")+1);
        String str2 = str.substring(str.indexOf("]") + 3);
        System.out.println(str1);
        System.out.println(str2);


        // ["A", "B", "C"], ["B", "C", "A"]
        strToArr(str1);
        strToArr(str2);
    }

    static String[] strToArr(String str){
        String[] strArr = new String[5];
        int i = 0;
        while(str.indexOf("\"") > 0){
            int start = str.indexOf("\"");
            int end = str.indexOf("\"", start+1);
            String value = str.substring(start+1, end);
            strArr[i] = value;
            i++;
            str = str.substring(end+1);
        }

        System.out.println(strArr[0]);
        System.out.println(strArr[1]);
        System.out.println(strArr[2]);
        System.out.println(strArr[3]);
        return strArr;
    }
}