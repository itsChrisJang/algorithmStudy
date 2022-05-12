package self.baekjoon.basic;

import java.io.IOException;

public class BinaryNumber {

    public static void main(String[] args) throws IOException {

        String[] strArr = new String[128];
        int[] intArr = new int[128];
        for(int i=1; i<=127;i++) {
            String binaryString = Integer.toBinaryString(i); //2진수
            strArr[i] = binaryString;
            intArr[i] = countChar(binaryString, '1');
        }

        for(int i=1; i<=127;i++) {
            System.out.println(i + " : " + strArr[i] + " / " + intArr[i]);
        }
    }

    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}