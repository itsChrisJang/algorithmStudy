package self.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class DividingWord1251 {

    // 백준 1251번
    // 단어 나누기
    // 알파벳 소문자로 이루어진 단어를 가지고 아래와 같은 과정을 해 보려고 한다.
    // 먼저 단어에서 임의의 두 부분을 골라서 단어를 쪼갠다.
    // 즉, 주어진 단어를 세 개의 더 작은 단어로 나누는 것이다.
    // 각각은 적어도 길이가 1 이상인 단어여야 한다.
    // 이제 이렇게 나눈 세 개의 작은 단어들을 앞뒤를 뒤집고, 이를 다시 원래의 순서대로 합친다.

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new DividingWord1251().go();
    }

    public void go() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        split(input);

        System.out.println(list.get(0));
    }

    public  String split(String input){
        String[] st = new String[3];

        for(int i = 1; i < input.length()-1; ++i){
            for(int j = i+1; j < input.length(); ++j){
                st[0] = input.substring(0,i);
                st[1] = input.substring(i,j);
                st[2] = input.substring(j, input.length());
                reverse(st);
            }
        }
        Collections.sort(list); // default : 오름차순 정렬
        return list.get(0);
    }

    public void reverse(String[] a){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<3; ++i){
            for(int j=a[i].length()-1; j>=0; --j){
                sb.append(Character.toString(a[i].charAt(j)));
            }
        }
        list.add(sb.toString());
        sb.setLength(0);        // 초기화해서 메모리 해제
    }
}
