package self.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroOneTileIteration1904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		System.out.println(Tile(N));

	}

	public static int Tile(int a) {

		if (a == 1) {
			return 1;
		}

		if (a == 2) {
			return 2;
		}

		// 초기 값
		int val1 = 1;
		int val2 = 2;
		int sum = 0;

		for (int i = 2; i < a; i++) {
			sum = (val2 + val1) % 15746;	// 이전 값과 이전의 이전 값의 합
			val1 = val2;	// 이전의 이전 값은 이전 값으로 변경
			val2 = sum;		// 이전 값은 현재 합 값으로 변경
		}

		return sum;

	}

}