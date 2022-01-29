package Baekjoon.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_4153_직각삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			if (num1 == 0 && num2 == 0 && num3 == 0) break;

			int min1 = Math.min(num1, num2);
			int max1 = Math.max(num1, num2);
			int min2 = Math.min(max1, num3);
			int max2 = Math.max(max1, num3);

			if ((min1 * min1) + (min2 * min2) == (max2 * max2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}