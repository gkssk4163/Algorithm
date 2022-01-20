package Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2562_최댓값 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int max = 0;
		int maxIndex = 0;
		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			if (num > max) {
				max = num;
				maxIndex = i;
			}
		}

		System.out.println(max);
		System.out.println(maxIndex);
	}
}