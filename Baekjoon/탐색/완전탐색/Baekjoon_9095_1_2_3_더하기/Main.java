package Baekjoon.탐색.완전탐색.Baekjoon_9095_1_2_3_더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			count = 0;
			int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			bruteforce(n);
			System.out.println(count);
		}
	}

	private static void bruteforce(int n) {
		if (n < 0) return;
		if (n == 0) {
			count++;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			bruteforce(n - i);
		}
	}
}