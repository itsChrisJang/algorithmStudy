package self.codingTest.dkTechIn;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2 {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\qiiop\\OneDrive\\Desktop\\personal\\코딩테스트\\디케이테크인_코딩테스트_java\\input2.log");

        try (
                FileInputStream inputStream = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        ) {

            String line = "";
            String regex = "[\\[](.*?)[\\]]";
            List<String[]> list = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                if (line.trim().length() > 0) {
                    System.out.println(line);
                    String[] strArr = line.split(regex);
                    System.out.print(strArr[0]);
                    System.out.print(strArr[1]);
                    System.out.print(strArr[2]);
                    System.out.print(strArr[3]);
                    System.out.println();
                    list.add(strArr);
//                    System.out.println(strArr.toString());
                }
            }
            System.out.println("list.size() : " + list.size());
//            for (int i = 0; i < list.size(); i++) {
//                System.out.print((list.get(i))[1]);
//                System.out.print((list.get(i))[2]);
//                System.out.print((list.get(i))[3]);
//                System.out.println();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
