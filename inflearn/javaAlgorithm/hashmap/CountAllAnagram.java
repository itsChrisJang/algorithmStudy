package self.inflearn.javaAlgorithm.hashmap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// 4. 모든 아나그램 찾기
// Soluetion : Hash, Sliding Window
// Time Complexity : O(n)
public class CountAllAnagram {
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for (char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);

        for (int i=0; i<b.length()-1; i++)
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);

        int lt = 0;
        for (int rt = b.length()-1; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            if (am.equals(bm)) answer++;

            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if(am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        CountAllAnagram countAllAnagram = new CountAllAnagram();

        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(countAllAnagram.solution(a, b));
    }
}
