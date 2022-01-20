package Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2475_검증수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int sumOfSquares = 0;
		for (int i = 0; i < 5; i++) {
			int num = Integer.parseInt(st.nextToken());
			sumOfSquares += num * num;
		}
		System.out.print(sumOfSquares % 10);
	}
}